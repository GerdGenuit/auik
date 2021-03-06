﻿-- Plain atl_analyseposition
SELECT
  atl_analyseposition.id,
  atl_analyseposition.grkl,
  atl_analyseposition.wert,
  atl_analyseposition.analyse_von,
  atl_analyseposition.bericht,
  atl_analyseposition.normwert,
  atl_analyseposition.einheiten_id,
  atl_analyseposition.parameter_id,
  atl_analyseposition.probenahme_id,
  atl_analyseposition._enabled,
  atl_analyseposition._deleted,
  atl_probenahmen.datum_der_entnahme,
  atl_probepkt.objektid AS probepkt_id
FROM
  auik.atl_analyseposition
  LEFT JOIN auik.atl_probenahmen
    ON atl_analyseposition.probenahme_id = atl_probenahmen.id
  LEFT JOIN auik.atl_probepkt
    ON atl_probenahmen.objektid = atl_probepkt.objektid

UNION

-- bsb / csb - ration
SELECT 
  -bsb.id AS id, 
  NULL::character varying(255) AS grkl, 
  bsb.wert / csb.wert AS wert, 
  bsb.analyse_von, 
  bsb.bericht, 
  NULL::double precision AS normwert, 
  0::integer AS einheiten_id, 
  'P00011'::character varying(255) AS parameter_id, 
  bsb.probenahme_id, 
  bsb._enabled, 
  bsb._deleted,
  atl_probenahmen.datum_der_entnahme,
  atl_probepkt.objektid AS probepkt_id
FROM 
  auik.atl_analyseposition bsb
  JOIN auik.atl_analyseposition csb
    ON (bsb.probenahme_id = csb.probenahme_id AND
        bsb.parameter_id = 'L16250' AND
        csb.parameter_id = 'L15330' AND
        bsb.wert IS NOT NULL AND 
        csb.wert IS NOT NULL AND 
        csb.wert != 0)
  LEFT JOIN auik.atl_probenahmen
    ON csb.probenahme_id = atl_probenahmen.id
  LEFT JOIN auik.atl_probepkt
    ON atl_probenahmen.objektid = atl_probepkt.objektid

UNION

-- (doc * m³) / 1000 DOC-Tagesfracht
SELECT 
  -doc.id AS id, 
  NULL::character varying(255) AS grkl, 
  ((doc.wert * menge.wert) / 1000)::real AS wert, 
  doc.analyse_von, 
  doc.bericht, 
  NULL::double precision AS normwert, 
  22::integer AS einheiten_id, 
  'P00015'::character varying(255) AS parameter_id, 
  doc.probenahme_id, 
  doc._enabled, 
  doc._deleted,
  atl_probenahmen.datum_der_entnahme,
  atl_probepkt.objektid AS probepkt_id
FROM 
  auik.atl_analyseposition menge
  JOIN auik.atl_analyseposition doc
    ON (menge.probenahme_id = doc.probenahme_id AND
        menge.parameter_id = 'P00013' AND 
        doc.parameter_id = 'L15210' AND
        menge.wert IS NOT NULL AND
        doc.wert IS NOT NULL)
  LEFT JOIN auik.atl_probenahmen
    ON doc.probenahme_id = atl_probenahmen.id
  LEFT JOIN auik.atl_probepkt
    ON atl_probenahmen.objektid = atl_probepkt.objektid

UNION

-- (toc * m³) / 1000 TOC-Tagesfracht (Ein Wert pro Datum)
SELECT 
  -toc.id AS id, 
  NULL::character varying(255) AS grkl, 
  ((toc.wert * menge.wert) / 1000)::real AS wert, 
  toc.analyse_von, 
  toc.bericht, 
  NULL::double precision AS normwert, 
  22::integer AS einheiten_id, 
  'P00014'::character varying(255) AS parameter_id, 
  toc.probenahme_id, 
  toc._enabled,
  toc._deleted,
  atl_probenahmen.datum_der_entnahme,
  atl_probepkt.objektid AS probepkt_id
FROM 
  auik.atl_analyseposition menge
  JOIN auik.atl_analyseposition toc
    ON (menge.probenahme_id = toc.probenahme_id AND
        menge.parameter_id = 'P00013' AND 
        toc.parameter_id = 'L15230' AND
        menge.wert IS NOT NULL AND
        toc.wert IS NOT NULL)
  LEFT JOIN auik.atl_probenahmen
    ON toc.probenahme_id = atl_probenahmen.id
  LEFT JOIN auik.atl_probepkt
    ON atl_probenahmen.objektid = atl_probepkt.objektid
  JOIN (
	SELECT 
	  atl_probepkt.objektid, 
	  probe.datum_der_entnahme,
	  count(*) AS anzahl_proben
	FROM 
	  auik.atl_probepkt
	  JOIN auik.atl_probenahmen probe
	    ON (probe.objektid = atl_probepkt.objektid AND
		atl_probepkt._deleted = false AND
		probe._deleted = false)
	  JOIN auik.atl_analyseposition menge
	    ON (menge.probenahme_id = probe.id AND
		menge._deleted = false AND
		menge.parameter_id = 'P00013' AND
		menge.wert IS NOT NULL)
	  JOIN auik.atl_analyseposition toc
	    ON (toc.probenahme_id = probe.id AND
		toc._deleted = false AND 
		toc.parameter_id = 'L15230' AND
		toc.wert IS NOT NULL)
	GROUP BY
	  atl_probepkt.objektid, 
	  probe.datum_der_entnahme
        ) AS anzahl_proben
    ON (anzahl_proben.objektid = atl_probepkt.objektid AND
        anzahl_proben.datum_der_entnahme = atl_probenahmen.datum_der_entnahme AND
        anzahl_proben.anzahl_proben = 1)

UNION

-- ((((toc_1 * (m³_1/m³_g)) + ((toc_2 * (m³_2/m³_g))) * (m³_1+m³_2)) / 1000 TOC-Tagesfracht (Zwei Werte (Tanks) pro Datum)
SELECT 
  -menge_1.id AS id, 
  NULL::character varying(255) AS grkl, 
  ((((toc_1.wert * (menge_1.wert / (menge_1.wert + menge_2.wert)))
   + (toc_2.wert * (menge_2.wert / (menge_1.wert + menge_2.wert))))
   * (menge_1.wert + menge_2.wert)) / 1000)::real AS wert, 
  menge_1.analyse_von, 
  menge_1.bericht, 
  NULL::double precision AS normwert, 
  22::integer AS einheiten_id, 
  'P00014'::character varying(255) AS parameter_id, 
  menge_1.probenahme_id, 
  menge_1._enabled,
  menge_1._deleted,
  probe_1.datum_der_entnahme,
  atl_probepkt.objektid AS probepkt_id
FROM 
  auik.atl_analyseposition menge_1
  JOIN auik.atl_analyseposition toc_1
    ON (menge_1.probenahme_id = toc_1.probenahme_id AND
        menge_1.parameter_id = 'P00013' AND 
        toc_1.parameter_id = 'L15230' AND
        menge_1.wert IS NOT NULL AND
        toc_1.wert IS NOT NULL AND
        (NOT menge_1._deleted) AND
        (NOT toc_1._deleted))
  JOIN auik.atl_probenahmen probe_1
    ON (toc_1.probenahme_id = probe_1.id AND
        (NOT probe_1._deleted))
  JOIN auik.atl_probenahmen probe_2
    ON (probe_1.objektid = probe_2.objektid AND
        probe_1.datum_der_entnahme = probe_2.datum_der_entnahme AND
        probe_1.id != probe_2.id AND
        (NOT probe_2._deleted))
  JOIN auik.atl_analyseposition menge_2
    ON (menge_2.probenahme_id = probe_2.id AND
        menge_2.parameter_id = 'P00013' AND 
        menge_2.wert IS NOT NULL AND
        (NOT menge_2._deleted))
  JOIN auik.atl_analyseposition toc_2
    ON (menge_2.probenahme_id = toc_2.probenahme_id AND
        toc_2.parameter_id = 'L15230' AND
        toc_2.wert IS NOT NULL AND
        (NOT toc_2._deleted))
  JOIN auik.atl_probepkt
    ON probe_1.objektid = atl_probepkt.objektid
;