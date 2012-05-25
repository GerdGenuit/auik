﻿SELECT
  -- Primary / Foreign Key: inka_uebergabestelle
  '05711000'::character varying(8)	AS gemeindekennzahl,
  1::integer				AS gemeinde_ver,
  indeinl_genehmigung.objektid::integer	AS uebergabestelle_lfd_nr,
  1::integer				AS uebergabestelle_ver,
  -- Primary Key
  atl_probepkt.objektid::integer	AS messstelle_lfd_nr,
  1::integer				AS messstelle_ver,

  -- Historisierung
  '1970-01-01'::date					AS gueltig_von, 	-- NOT NULL
  NULL::date 						AS gueltig_bis,
  NULL::timestamp without time zone			AS aenderungs_datum,
  '1970-01-01 00:00:00'::timestamp without time zone	AS erfassungs_datum,	-- NOT NULL
  1::integer 						AS historien_nr,	-- NOT NULL
  true::boolean						AS ist_aktuell_jn, 	-- NOT NULL

  -- Daten
  -- Foreign Key: inka_genehmigung
  indeinl_genehmigung.objektid::integer		AS genehmigung_nr,		-- NOT NULL
  1::integer					AS genehmigung_ver,		-- NOT NULL
  3::integer					AS messstelle_typ,		-- NOT NULL
  'There be dragons'::character varying(50)	AS beschr_messpunkt,
  false::boolean				AS relevant_sum_fracht_jn	-- NOT NULL

FROM auik.indeinl_genehmigung
  LEFT OUTER JOIN auik.basis_objektverknuepfung
    ON (indeinl_genehmigung.objektid = basis_objektverknuepfung.ist_verknuepft_mit
      OR indeinl_genehmigung.objektid = basis_objektverknuepfung.objekt)
  LEFT OUTER JOIN auik.atl_probepkt
    ON (atl_probepkt.objektid = basis_objektverknuepfung.ist_verknuepft_mit
      OR atl_probepkt.objektid = basis_objektverknuepfung.objekt)

WHERE 
  indeinl_genehmigung.anhang IS NOT NULL AND 
  indeinl_genehmigung.gen59 AND 
  indeinl_genehmigung._deleted = FALSE; -- AND
--  basis_objekt._deleted = FALSE AND
--  basis_objekt.inaktiv = FALSE;
