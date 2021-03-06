/**
 * Copyright 2005-2042, Stadt Bielefeld
 *
 * This file is part of AUIK (Anlagen- und Indirekteinleiter-Kataster).
 *
 * AUIK is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 2 of the License, or (at your
 * option) any later version.
 *
 * AUIK is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with AUIK. If not, see <http://www.gnu.org/licenses/>.
 *
 * AUIK has been developed by Stadt Bielefeld and Intevation GmbH.
 */

package de.bielefeld.umweltamt.aui.mappings;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.NullPrecedence;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import de.bielefeld.umweltamt.aui.HibernateSessionFactory;
import de.bielefeld.umweltamt.aui.SettingsManager;
import de.bielefeld.umweltamt.aui.mappings.atl.AtlEinheiten;
import de.bielefeld.umweltamt.aui.mappings.atl.AtlKlaeranlagen;
import de.bielefeld.umweltamt.aui.mappings.atl.AtlParameter;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisAdresse;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisGemarkung;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisLage;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisMapAdresseLage;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisObjekt;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisObjektarten;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisObjektchrono;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisObjektverknuepfung;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisOrte;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisSachbearbeiter;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisStrassen;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisTabStreets;
import de.bielefeld.umweltamt.aui.mappings.indeinl.Anh49Abfuhr;
import de.bielefeld.umweltamt.aui.mappings.indeinl.Anh49Fachdaten;
import de.bielefeld.umweltamt.aui.mappings.vaws.VawsWassereinzugsgebiete;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import de.bielefeld.umweltamt.aui.utils.StringUtils;

/**
 * This is a service class for all custom queries from the basis package.
 *
 * @author <a href="mailto:post@connz.de">Conny Pearce (u633z)</a>
 * @see de.bielefeld.umweltamt.aui.mappings.DatabaseQuery
 */
abstract class DatabaseBasisQuery extends DatabaseIndeinlQuery
{

	/** Logging */
	private static final AuikLogger log = AuikLogger.getLogger();

	/* ********************************************************************** */
	/* Queries for package BASIS */
	/* ********************************************************************** */

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class BasisAdresse */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Get all BasisAdresse with a given search string in the selected
	 * property that contain a Betreiber. <br>
	 * If property is <code>null</code>, we search in all three properties.
	 * 
	 * @param property
	 *            Name of the property
	 * @param search
	 *            Search string
	 * @return <code>List&lt;BasisAdresse&gt;</code> List of BasisAdresse
	 *         with the given search string in the given property
	 */
	public static List<BasisAdresse> getBasisAdresse(String property,
		String search)
	{

		String modSearch = search.trim().toLowerCase() + "%";
		log.debug("Suche nach '" + modSearch + "' (" + property + ").");

        String query =  "SELECT DISTINCT adresse " + 
                        "FROM BasisAdresse as adresse JOIN adresse.basisObjekts objekt ";
        if (property == null)
		{
            query += "WHERE LOWER(adresse.betrname) like '" + modSearch + "' OR LOWER(betranrede) like '" + modSearch + "' OR LOWER(betrnamezus) like '" + modSearch + "'";
		}
		else if (property.equals("name"))
		{
            query += "WHERE LOWER(adresse.betrname) like '" + modSearch + "'";
		}
		else if (property.equals("anrede"))
		{
            query += "WHERE LOWER(adresse.betranrede) like '" + modSearch + "'";
		}
		else if (property.equals("zusatz"))
		{
            query += "WHERE LOWER(adresse.betrzus) like '" + modSearch + "'";
		}
		else
		{
			log.debug("Something went really wrong here...");
		}
        query += " AND adresse.deleted = false";
        query += " ORDER BY adresse.betrname ASC, adresse.betrnamezus ASC";

        return HibernateSessionFactory.currentSession().createQuery(query).list();
	}

	/**
	 * Get a nicely formatted street and house number for a BasisAdresse
	 * 
	 * @param betreiber
	 *            BasisAdresse
	 * @return String
	 */
	public static String getBetriebsgrundstueck(BasisAdresse betreiber)
	{
		String strasse = betreiber.getStrasse();
		Integer hausnr = betreiber.getHausnr();
		String zusatz = betreiber.getHausnrzus();
		return (strasse != null ? strasse + " " : "")
				+ (hausnr != null ? hausnr.toString() : "")
				+ (zusatz != null ? zusatz : "");
	}

	/**
	 * Get a formatted string for a BasisStandortAdresse
	 * 
	 * @param standort
	 *            BasisAdresse
	 * @return String
	 */
	public static String getStandortString(BasisAdresse standort)
	{
		String strasse = standort.getStrasse();
		Integer hausnr = standort.getHausnr();
		String zusatz = standort.getHausnrzus();
		return (strasse != null ? strasse + " " : "")
				+ (hausnr != null ? hausnr.toString() : "")
				+ (zusatz != null ? zusatz : "");
	}


	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class BasisGemarkung */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	private static BasisGemarkung[] gemarkungen = null;

	/**
	 * Get an array with all <code>BasisGemarkung</code>en
	 * 
	 * @return <code>BasisGemarkung[]</code>
	 */
	public static BasisGemarkung[] getBasisGemarkungen()
	{
		if (DatabaseBasisQuery.gemarkungen == null)
		{
			DatabaseBasisQuery.gemarkungen = DatabaseQuery.getOrderedAll(
																			new BasisGemarkung())
					.toArray(new BasisGemarkung[0]);
		}
		return DatabaseBasisQuery.gemarkungen;
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class BasisGemarkung */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Get all BasisGemarkungen and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Gemarkungen</code>
	 */
	public static List<BasisGemarkung> getGemarkungenlist()
	{
		List<BasisGemarkung> gemarkungenlist = new DatabaseAccess()
				.executeCriteriaToList(
										DetachedCriteria.forClass(BasisGemarkung.class)
												.addOrder(Order.asc("gemarkung")),
										new BasisGemarkung());
		return gemarkungenlist;
	}

	/**
	 * Get next id for new BasisGemarkung
	 * 
	 * @return <code>BasisGemarkung</code>
	 */
	public static Integer newGemarkungID()
	{
		Integer id = new DatabaseAccess().executeCriteriaToUniqueResult(
																		DetachedCriteria.forClass(BasisGemarkung.class)
																				.setProjection(
																								Property.forName("id")
																										.max()),
																		new Integer(0));
		return id + 1;
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class BasisObjekt */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Liefert eine Liste von Objekten, die einem bestimmten Betreiber
	 * zugeordnet sind.
	 * 
	 * @param betreiber
	 *            Der Betreiber.
	 * @param abteilung
	 *            Die Abteilung, wenn nach ihr gefiltert werden soll, sonst
	 *            <code>null</code>.
	 * @return Eine Liste von BasisObjekten dieses Betreibers.
	 */
	public static List<BasisObjekt> getObjekteByBetreiber(
		BasisAdresse betreiber, String abteilung)
	{
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(BasisObjekt.class)
				.createAlias("basisStandort", "lage")
				.createAlias("basisObjektarten", "art")
				.add(Restrictions.eq("basisAdresse", betreiber))
				.addOrder(Order.asc("inaktiv"))
				.addOrder(Order.asc("lage.strasse"))
				.addOrder(Order.asc("lage.hausnr"))
				.addOrder(Order.asc("art.objektart"));
		if (abteilung != null)
		{
			detachedCriteria.add(Restrictions.eq("art.abteilung", abteilung));
		}
		return new DatabaseAccess().executeCriteriaToList(detachedCriteria,
															new BasisObjekt());
	}

	/**
	 * Liefert eine Liste von Objekten, die einem bestimmten Standort zugeordnet
	 * sind.
	 * 
	 * @param betreiber
	 *            Die Standortadresse.
	 * @param abteilung
	 *            Die Abteilung, wenn nach ihr gefiltert werden soll, sonst
	 *            <code>null</code>.
	 * @param artid
	 *            Die Objektart, die (nicht) dargestellt werden soll.
	 * @return Eine Liste von BasisObjekten an diesem Standort.
	 */
	
	public static List<BasisObjekt> getObjekteByStandort(
			BasisAdresse betreiber, String abteilung)
		{
			DetachedCriteria detachedCriteria = DetachedCriteria
					.forClass(BasisObjekt.class)
					.createAlias("basisStandort", "lage")
					.createAlias("basisObjektarten", "art")
					.add(Restrictions.eq("basisStandort", betreiber))
					.addOrder(Order.asc("inaktiv"))
					.addOrder(Order.asc("lage.strasse"))
					.addOrder(Order.asc("lage.hausnr"))
					.addOrder(Order.asc("art.objektart"));
			if (abteilung != null)
			{
				detachedCriteria.add(Restrictions.eq("art.abteilung", abteilung));
			}
			return new DatabaseAccess().executeCriteriaToList(detachedCriteria,
																new BasisObjekt());
		}
	
	
	public static List<BasisObjekt> getObjekteByAdresse(
		BasisAdresse adresse, String abteilung, Integer artid,
		Boolean matchArtId)
	{
        log.debug("Fetching objects at " + adresse);
        //Find objects witch matching standortid
		String query = "SELECT o.* from auik.basis_objekt o "+
                       " WHERE (o.standortid = "+ adresse.getId() +
                       " OR o.betreiberid = "+ adresse.getId() +
                       " ) AND o._deleted = false " +
                       " ORDER BY o.inaktiv, o.objektartid";

        String filter = " ";
        if (abteilung != null)
		{
            filter += " AND art.abteilung = '" + abteilung + "' ";
		}
		if (artid != null)
		{
			if (matchArtId)
			{
                filter += "AND art.id = " + artid + " ";
			}
			else
			{
                filter += "AND art.id != " + artid + " ";

			}
		}

        SQLQuery q = HibernateSessionFactory.currentSession().createSQLQuery(query);

        q.addEntity("o", BasisObjekt.class);
        return q.list();
}
	
	
    	public static List<BasisObjekt> getObjekteByStandort(
    		BasisAdresse standort, String abteilung, Integer artid,
    		Boolean matchArtId)
    	{
            log.debug("Fetching objects at " + standort);
            //Find objects witch matching standortid
    		String query1 = "SELECT o.* from auik.basis_objekt o, auik.basis_adresse a, auik.basis_objektarten art "+
                           " WHERE a.id = " + standort.getId() + " AND o.standortid = a.id";
            //Find objects with standortid of basis_adresse objects with matching fields
            String query2 = " UNION " +
                     "SELECT o.* from auik.basis_objekt o, auik.basis_adresse a, auik.basis_adresse a2, auik.basis_objektarten art " + 
                     " WHERE a.id = " + standort.getId() + " AND a2.strasse = a.strasse AND a2.hausnr = a.hausnr  AND o.standortid = a2.id"
                     + " AND CASE WHEN " + 
                     " (a.hausnrzus IS NOT NULL) THEN (a2.hausnrzus = a.hausnrzus) ELSE (a2.hausnrzus IS NULL) END";

            String filter = " ";
            if (abteilung != null)
    		{
                filter += " AND art.abteilung = '" + abteilung + "' ";
    		}
    		if (artid != null)
    		{
    			if (matchArtId)
    			{
                    filter += "AND art.id = " + artid + " ";
    			}
    			else
    			{
                    filter += "AND art.id != " + artid + " ";

    			}
    		}
            query1 += filter;
            query2 += filter + ";";
            SQLQuery q = HibernateSessionFactory.currentSession().createSQLQuery(query1 + query2);
            //log.debug(query1 + query2);
            q.addEntity("o", BasisObjekt.class);
            return q.list();
	}	

    	/**
    	 * Liefert eine Liste von Objekten, die einer bestimmten Strasse, Hausnummer und Hausnummernzusatz
    	 * zugeordnet sind.
    	 * 
    	 * @param adr
    	 *            Die Standortadresse.
    	 * @param abteilung
    	 *            Die Abteilung, wenn nach ihr gefiltert werden soll, sonst
    	 *            <code>null</code>.
    	 * @param artid
    	 *            Die Objektart, die (nicht) dargestellt werden soll.
    	 * @return Eine Liste von BasisObjekten an diesem Standort.
    	 */
    	
    	public static List<BasisObjekt> getObjekteByStrasse(BasisAdresse adr,
			String abteilung, Integer artid, Boolean matchArtId) {
    		    		
		String strasse = adr.getStrasse().replaceAll("'", "''");
		Integer nr = adr.getHausnr();
		String zus = adr.getHausnrzus();

		log.debug("Fetching objects at " + adr);
		// Find objects witch matching fields
		String query = "SELECT o.*, a.* from auik.basis_objekt o, auik.basis_adresse a, auik.basis_objektarten art "
				+ " WHERE o.standortid = a.id AND o.objektartid = art.id "
				+ "AND a.strasse = '" + strasse + "' AND a.hausnr = " + nr;
		if (zus != null) {
			query += " AND a.hausnrzus = '" + zus + "' ";
		} else {
			query += " AND a.hausnrzus IS NULL ";
		}

		query += " AND o._deleted = false ";
		
		String filter = " ";
		if (abteilung != null) {
			filter += " AND art.abteilung = '" + abteilung + "' ";
		}
		if (artid != null) {
			if (matchArtId) {
				filter += "AND art.id = " + artid + " ";
			} else {
				filter += "AND art.id != " + artid + " ";

			}
		}
		query += filter
				+ "ORDER BY o.inaktiv, a.betrname, art.objektart, o.beschreibung;";
		SQLQuery q = HibernateSessionFactory.currentSession().createSQLQuery(
				query);
		// log.debug(query1 + query2);
		q.addEntity("o", BasisObjekt.class);
		return q.list();

	}

	/**
	 * Liefert eine Liste von Objekten einer Objektart sind.
	 * 
	 * @param artid
	 *            Die Objektart, die (nicht) dargestellt werden soll.
	 * @return Eine Liste von BasisObjekten an diesem Standort.
	 */
	public static List<BasisObjekt> getObjekteByArt(Integer artid)
	{
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(BasisObjekt.class)
				.createAlias("basisAdresse", "betreiber")
				.createAlias("basisObjektarten", "art")
				.add(Restrictions.eq("art.id", artid))
				.addOrder(Order.asc("inaktiv"))
				.addOrder(Order.asc("betreiber.betrname"))
				.addOrder(Order.asc("art.objektart"));

		return new DatabaseAccess().executeCriteriaToList(detachedCriteria,
															new BasisObjekt());
	}

	/**
	 * Cascade a priority to all objects from the same BasisAdresse and
	 * BasisLage
	 * 
	 * @param prioritaet
	 *            String
	 * @param basisObjekt
	 *            BasisObjekt
	 * @return <code>true</code> if every merge was successful,
	 *         <code>false</code> otherwise
	 */
	public static Boolean cascadePriority(String prioritaet,
		BasisObjekt basisObjekt)
	{
		Boolean result = true;
		List<BasisObjekt> list = new DatabaseAccess()
				.executeCriteriaToList(
										DetachedCriteria
												.forClass(BasisObjekt.class)
												.add(Restrictions.eq("basisAdresse",
																		basisObjekt.getBasisAdresse()))
												.add(Restrictions.eq("basisLage",
																		basisObjekt.getBasisLage())),
										new BasisObjekt());
		for (BasisObjekt objekt : list)
		{
			objekt.setPrioritaet(prioritaet);
			result = result && objekt.merge();
		}
		return result;
	}

	/**
	 * Get a list of all priorities. The list contains an array with
	 * <code>BasisLage</code>, <code>BasisAdresse</code>,
	 * <code>String</code> (priority) and <code>BasisSachbearbeiter</code>
	 * 
	 * @return <code>List&lt;?&gt;</code>
	 */
	public static List<?> getObjektsWithPriority()
	{
		return new DatabaseAccess()
				.executeCriteriaToList(
										DetachedCriteria
												.forClass(BasisObjekt.class)
												.add(Restrictions.eq("inaktiv", false))
												.add(Restrictions.eq("deleted", false))
												.add(Restrictions.isNotNull("prioritaet"))
												.add(Restrictions
														.isNotNull("basisSachbearbeiter"))
												.setProjection(
																Projections.distinct(Projections
																		.projectionList()
																		.add(Projections
																				.property("basisLage"))
																		.add(Projections
																				.property("basisAdresse"))
																		.add(Projections
																				.property("prioritaet"))
																		.add(Projections
																				.property("basisSachbearbeiter"))))
												.addOrder(Order.asc("prioritaet"))
												.addOrder(Order.asc("basisLage"))
												.addOrder(Order.asc("basisAdresse")),
										new BasisObjekt());
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class BasisObjektarten */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	private static BasisObjektarten[] objektarten = null;

	/**
	 * Get all BasisObjektarten and sort them by their name
	 * 
	 * @return <code>BasisObjektarten[]</code>
	 */
	public static BasisObjektarten[] getObjektarten()
	{
		if (DatabaseBasisQuery.objektarten == null)
		{
			DatabaseBasisQuery.objektarten = DatabaseQuery.getOrderedAll(
																			new BasisObjektarten(), "objektart")
					.toArray(
								new BasisObjektarten[0]);
		}
		return DatabaseBasisQuery.objektarten;
	}

	/**
	 * Get all BasisObjektarten and sort them by their name and kind
	 * 
	 * @return <code>BasisObjektarten[]</code>
	 */
	public static List<BasisObjektarten> getObjektartenlist()
	{
		List<BasisObjektarten> objektartenlist = new DatabaseAccess()
				.executeCriteriaToList(
										DetachedCriteria.forClass(BasisObjektarten.class)
												.addOrder(Order.asc("abteilung"))
												.addOrder(Order.asc("objektart")),
										new BasisObjektarten());
		return objektartenlist;
	}

	/**
	 * Get next id for new BasisObjektarten
	 * 
	 * @return <code>BasisObjektartenID</code>
	 */
	public static Integer newObjektartenID()
	{
		Integer id = new DatabaseAccess().executeCriteriaToUniqueResult(
																		DetachedCriteria
																				.forClass(BasisObjektarten.class)
																				.setProjection(Property.forName("id")
																						.max()),
																		new Integer(0));
		return id + 1;
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class BasisObjektchrono */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Go throw the BasisObjektchrono Set and grep the earliest chrono.
	 * 
	 * @param objekt
	 *            BasisObjekt
	 * @return BasisObjektchrono
	 */
	public static Timestamp getLastChronoDateForObjekt(BasisObjekt objekt)
	{
		// // TODO: When we can load the lazy initialized stuff properly, do
		// this:
		// Set<BasisObjektchrono> chronos = objekt.getBasisObjektchronos();
		// if (!(DatabaseAccess.isInitialized(chronos))) {
		// // TODO: Load the Set
		// }
		// BasisObjektchrono max = null;
		// for (BasisObjektchrono chrono : chronos) {
		// if ((max == null) || max.getDatum().before(chrono.getDatum())) {
		// max = chrono;
		// }
		// }
		// return max;
		return new DatabaseAccess()
				.executeCriteriaToUniqueResult(
												DetachedCriteria
														.forClass(BasisObjektchrono.class)
														.add(Restrictions.eq("basisObjekt", objekt))
														.setProjection(
																		Projections.distinct(Projections
																				.max("datum"))), new Timestamp(
														0));
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package indeinl : class Anh49Abfuhr */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Go throw the Anh49Abfuhr Set and grep the earliest abfuhrdatum.
	 * 
	 * @param objekt
	 *            Anh49Fachdaten
	 * @return Anh49Abfuhr
	 */
	public static Timestamp getLastAbfuhrDateForObjekt(Anh49Fachdaten objekt)
	{

		return new DatabaseAccess()
				.executeCriteriaToUniqueResult(
												DetachedCriteria
														.forClass(Anh49Abfuhr.class)
														.add(Restrictions.eq("anh49Fachdaten", objekt))
														.setProjection(
																		Projections.distinct(Projections
																				.max("abfuhrdatum"))),
												new Timestamp(0));
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package indeinl : class Anh49Abfuhr */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Go throw the Anh49Abfuhr Set and grep the earliest naechsteabfuhr.
	 * 
	 * @param objekt
	 *            Anh49Fachdaten
	 * @return Anh49Abfuhr
	 */
	public static Timestamp getNextAbfuhrDateForObjekt(Anh49Fachdaten objekt)
	{

		return new DatabaseAccess()
				.executeCriteriaToUniqueResult(
												DetachedCriteria
														.forClass(Anh49Abfuhr.class)
														.add(Restrictions.eq("anh49Fachdaten", objekt))
														.setProjection(
																		Projections.distinct(Projections
																				.max("naechsteabfuhr"))),
												new Timestamp(0));
	}

	// TODO: This may be replaced with objekt.getBasisObjektchonos() if we find
	// an easy way to load them as they are lazy loaded.
	public static List<BasisObjektchrono> getChronos(BasisObjekt objekt)
	{
		return new DatabaseAccess().executeCriteriaToList(
															DetachedCriteria.forClass(BasisObjektchrono.class)
																	.add(Restrictions.eq("basisObjekt", objekt))
																	.addOrder(Order.asc("datum")),
															new BasisObjektchrono());
	}

	public static List<BasisObjektchrono> getAllChronos(BasisObjekt objekt)
	{
		return new DatabaseAccess()
				.executeCriteriaToList(
										DetachedCriteria
												.forClass(BasisObjektchrono.class)
												.createAlias("basisObjekt", "objekt")
												.add(Restrictions.eq("objekt.basisAdresse",
																		objekt.getBasisAdresse()))
												.add(Restrictions.eq("objekt.basisLage",
																		objekt.getBasisLage()))
												.addOrder(Order.asc("datum")), new BasisObjektchrono());
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class BasisObjektverknuepfung */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Liefert alle verknuepften Objekte zu einem bestimmten BasisObjekt.
	 * 
	 * @param objekt
	 *            Das BasisObjekt.
	 * @return Eine Liste mit Objekten.
	 */
	public static List<BasisObjektverknuepfung> getLinkedObjekts(
		BasisObjekt objekt)
	{
		return new DatabaseAccess()
				.executeCriteriaToList(
										DetachedCriteria
												.forClass(BasisObjektverknuepfung.class)
												.add(Restrictions.or(Restrictions
														.eq("basisObjektByIstVerknuepftMit",
															objekt), Restrictions.eq(
																						"basisObjektByObjekt", objekt))),
										new BasisObjektverknuepfung());
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class BasisSachbearbeiter */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	private static BasisSachbearbeiter[] sachbearbeiter = null;

	/**
	 * Get a sorted array of all enabled BasisSachbearbeiter
	 * 
	 * @return <code>BasisSachbearbeiter[]</code>
	 */
	public static BasisSachbearbeiter[] getEnabledSachbearbeiter()
	{
		if (DatabaseBasisQuery.sachbearbeiter == null)
		{
			DatabaseBasisQuery.sachbearbeiter = new DatabaseAccess()
					.executeCriteriaToArray(
											DetachedCriteria
													.forClass(BasisSachbearbeiter.class)
													.add(Restrictions.eq("enabled", true))
													.addOrder(Order.asc("name")),
											new BasisSachbearbeiter[0]);
		}
		return DatabaseBasisQuery.sachbearbeiter;
	}

	/**
	 * Get the current BasisSachbearbeiter.
	 * 
	 * @return <code>BasisSachbearbeiter</code>
	 */
	public static BasisSachbearbeiter getCurrentSachbearbeiter()
	{
		return BasisSachbearbeiter.findByKennummer(SettingsManager.getInstance()
				.getSetting("auik.prefs.lastuser"));
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class BasisSachbearbeiter */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Get all BasisSachbearbeiter and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Parameter</code>
	 */
	public static List<BasisSachbearbeiter> getSachbearbeiterlist()
	{
		List<BasisSachbearbeiter> sachbearbeiterlist = new DatabaseAccess()
				.executeCriteriaToList(
										DetachedCriteria.forClass(BasisSachbearbeiter.class)
												.addOrder(Order.asc("name")),
										new BasisSachbearbeiter());
		return sachbearbeiterlist;
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class BasisLage */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Check if a location already exists
	 * 
	 * @param strasse
	 *            The street
	 * @param hausnr
	 *            The house number
	 * @param zusatz
	 *            Addition to the house number
	 * @return <code>true</code>, if the given location exists,
	 *         <code>false</code> otherwise
	 */
	public static boolean basisStandortExists(String strasse, Integer hausnr,
		String zusatz)
	{
		return (!(new DatabaseAccess()
				.executeCriteriaToList(
										DetachedCriteria
												.forClass(BasisAdresse.class)
												.add(Restrictions.eq("strasse", strasse))
												.add(Restrictions.eq("hausnr", hausnr))
												.add(DatabaseAccess.getRestrictionsEqualOrNull(
																								"hausnrzus", zusatz)),
										new BasisAdresse())
				.isEmpty()));
	}

    /**
     * Returns a List of all BasisAdresse and BasisLage objects that are connected through a BasisMapAdresseLage object
     * Output format is List<[BasisAdresse][BasisLage]>
 	 * 
	 * @param strasse
	 *            String
	 * @param hausnr
	 *            Integer (-1: all)
	 * @param ort
	 *            String
	 * @return <code>List&lt;Object[]&gt;</code>
	 */     
    public static List<Object[]> findStandorteNew(String strasse,
        Integer hausnr, String ort)
	{
        //Check which parameters are set
        boolean bStrasse = (strasse != null && strasse.length() > 0);
        boolean bHausnr = (hausnr != null && hausnr != -1);
        boolean bOrt = (ort != null && ort.length() > 0);
        String str = strasse.toLowerCase();
        str = str.replace("'", "''");

        String query = 
            "SELECT * FROM " +
            " (SELECT DISTINCT ON (a.strasse, a.hausnr, a.hausnrzus) a.*, m.* " +
            "FROM auik.basis_adresse a JOIN auik.basis_map_adresse_lage m ON m.adresseid = a.id";
            if(bStrasse || bHausnr || bOrt){
                query += " WHERE ";
                if(bStrasse){
                    query += " lower(a.strasse) like '" + str + "%' ";
                }
                if(hausnr != null && hausnr != -1){
                    if(bStrasse){
                        query += " AND ";
                    }
                    query += " a.hausnr = " + hausnr;
                }
                if(bOrt){
                    if(bStrasse || bHausnr){
                        query += " AND ";
                    }
                    query += " lower(a.ort) like '" + ort.toLowerCase() + "%' ";
                }
            query += " AND a._deleted = false";
            }
            query += ") AS q ORDER BY q.strasse ASC, q.hausnr ASC, q.hausnrzus ASC;";
            SQLQuery q = HibernateSessionFactory.currentSession().createSQLQuery(query);
            q.addEntity("a", BasisAdresse.class);
            q.addEntity("m", BasisMapAdresseLage.class);
            return q.list();
    }
 
    /**
     * Returns a List of BasisAdresse objects for the given parameters
     * Output format is List<[BasisAdresse]>
 	 * 
	 * @param Name
	 *            String
	 * @param strasse
	 *            String
	 * @param hausnr
	 *            Integer (-1: all)
	 * @param ort
	 *            String
	 * @return <code>List&lt;BasisAdresse[]&gt;</code>
	 */     
   
	public static List<BasisAdresse> findBetreiber(String name, String strasse,
		Integer hausnr, String ort)
	{
		//Check which parameters are set
	    boolean bName = (name != null && name.length() > 0);
	    boolean bStrasse = (strasse != null && strasse.length() > 0);
	    boolean bHausnr = (hausnr != null && hausnr != -1);
	    boolean bOrt = (ort != null && ort.length() > 0);
        String str = strasse.toLowerCase();
        str = str.replace("'", "''");
	
		String query = "SELECT DISTINCT adresse "
				+ "FROM BasisObjekt as obj JOIN obj.basisAdresse adresse";
		if (bName || bStrasse || bHausnr || bOrt) {
			query += " WHERE ";
			if (bName) {
				query += "LOWER(adresse.betrname) like '" + name.toLowerCase()
						+ "%' AND ";
			}
			if (bStrasse) {
				query += "LOWER(adresse.strasse) like '"
						+ strasse.toLowerCase() + "%' AND ";
			}
			if (bHausnr) {
				query += "adresse.hausnr = " + hausnr + " AND ";
			}
			if (bOrt) {
				query += "LOWER(adresse.ort) like '" + ort.toLowerCase()
						+ "%' AND ";
			}

			query += "adresse.deleted = false ";

			query += "ORDER BY adresse.strasse ASC, adresse.hausnr ASC, adresse.hausnrzus ASC, adresse.betrname ASC";
		}
		return HibernateSessionFactory.currentSession().createQuery(query)
				.list();
	}
 
    /**
     * Returns a List of BasisAdresse objects for the given parameters
     * Output format is List<[BasisAdresse]>
 	 * 
	 * @param Name
	 *            String
	 * @param strasse
	 *            String
	 * @param hausnr
	 *            Integer (-1: all)
	 * @param ort
	 *            String
	 * @return <code>List&lt;BasisAdresse[]&gt;</code>
	 */     
   
	public static List<BasisAdresse> findStandorte(String name, String strasse,
		Integer hausnr, String ort)
	{
		//Check which parameters are set
	    boolean bName = (name != null && name.length() > 0);
	    boolean bStrasse = (strasse != null && strasse.length() > 0);
	    boolean bHausnr = (hausnr != null && hausnr != -1);
	    boolean bOrt = (ort != null && ort.length() > 0);
        String str = strasse.toLowerCase();
        str = str.replace("'", "''");
	
		String query = "SELECT DISTINCT adresse "
				+ "FROM BasisObjekt as obj JOIN obj.basisStandort adresse";
		if (bName || bStrasse || bHausnr || bOrt) {
			query += " WHERE ";
			if (bName) {
				query += "LOWER(adresse.betrname) like '" + name.toLowerCase()
						+ "%' AND ";
			}
			if (bStrasse) {
				query += "LOWER(adresse.strasse) like '"
						+ strasse.toLowerCase() + "%' AND ";
			}
			if (bHausnr) {
				query += "adresse.hausnr = " + hausnr + " AND ";
			}
			if (bOrt) {
				query += "LOWER(adresse.ort) like '" + ort.toLowerCase()
						+ "%' AND ";
			}

			query += "adresse.deleted = false ";

			query += "ORDER BY adresse.strasse ASC, adresse.hausnr ASC, adresse.hausnrzus ASC, adresse.betrname ASC";
		}
		return HibernateSessionFactory.currentSession().createQuery(query)
				.list();
	}	
	
	
	public static List<BasisAdresse> findStandorte(String strasse,
			Integer hausnr, String ort)
			{
				//Check which parameters are set
			    boolean bStrasse = (strasse != null && strasse.length() > 0);
			    boolean bHausnr = (hausnr != null && hausnr != -1);
			    boolean bOrt = (ort != null && ort.length() > 0);
		        String str = strasse.toLowerCase();
		        str = str.replace("'", "''");
			
			    String query =  "SELECT DISTINCT adresse " + 
			            "FROM BasisMapAdresseLage as map JOIN map.basisAdresse adresse";
			        if(bStrasse || bHausnr || bOrt){
			            query += " WHERE ";
			            if(bStrasse){
			                query += "LOWER(adresse.strasse) like '" + str + "%' ";
			            }
			            if(hausnr != null && hausnr != -1){
			                if(bStrasse){
			                    query += " AND ";
			                }
			                query += " adresse.hausnr = " + hausnr;
			            }
			            if(bOrt){
			                if(bStrasse || bHausnr){
			                    query += " AND ";
			                }
			                query += " LOWER(adresse.ort) like '" + ort.toLowerCase() + "%' ";
			            }
			            query += " AND adresse.deleted = false";
			        }
			        query += " ORDER BY adresse.strasse ASC, adresse.hausnr ASC, adresse.hausnrzus ASC, adresse.betrname ASC";
			        return HibernateSessionFactory.currentSession().createQuery(query).list();
			}
	
	/**
     * Returns a List of BasisAdresse objects matching the given parameters
     * and having a connection to a BasisMapAdresseLage object
     * 
     * Output format is List<[BasisAdresse]>
 	 * 
	 * @param search
	 *            String Betreibername
	 * @param property
	 *            String
	 * @return <code>List&lt;BasisAdresse[]&gt;</code>
	 */     
   
	public static List<BasisAdresse> findStandorte(String search,
			String property) {

		String query = "SELECT DISTINCT adresse "
				+ "FROM BasisObjekt as obj JOIN obj.basisAdresse adresse";

		query += " WHERE ";

		query += "LOWER(adresse.betrname) like '" + search.toLowerCase()
				+ "%' ";

		query += " ORDER BY adresse.strasse ASC, adresse.hausnr ASC, adresse.hausnrzus ASC, adresse.betrname ASC";
		return HibernateSessionFactory.currentSession().createQuery(query)
				.list();
	}
	
	/**
     * Returns a List of all BasisAdresse objects matching the given parameters
     * 
     * Output format is List<[BasisAdresse]>
 	 * 
	 * @param search
	 *            String Betreibername
	 * @param property
	 *            String
	 * @return <code>List&lt;BasisAdresse[]&gt;</code>
	 */     
   
	public static List<BasisAdresse> findAdressen(String search,
			String property) {

		String query = "SELECT DISTINCT adresse "
				+ "FROM BasisAdresse adresse";

		query += " WHERE ";

		query += "LOWER(adresse.betrname) like '" + search.toLowerCase()
				+ "%' AND adresse.deleted = false";

		query += " ORDER BY adresse.strasse ASC, adresse.hausnr ASC, adresse.hausnrzus ASC, adresse.betrname ASC";
		return HibernateSessionFactory.currentSession().createQuery(query)
				.list();
	}
	
	/**
     * Returns a List of all BasisAdresse objects matching the given parameters
     * 
     * Output format is List<[BasisAdresse]>
 	 * 
	 * @param search
	 *            String Betreibername
	 * @param property
	 *            String
	 * @return <code>List&lt;BasisAdresse[]&gt;</code>
	 */     
   
	public static List<BasisAdresse> findAdressen(String name, String strasse, Integer hausnr, String ort,
			String property) {


	    boolean bName = (name != null && name.length() > 0);
	    boolean bStrasse = (strasse != null && strasse.length() > 0);
	    boolean bHausnr = (hausnr != null && hausnr != -1);
	    boolean bOrt = (ort != null && ort.length() > 0);
	    
		String query = "SELECT adresse "
				+ "FROM BasisAdresse adresse";
        if(bName || bStrasse || bHausnr || bOrt){
            query += " WHERE ";
            if (bName && property == null)
    		{
                query += "(LOWER(adresse.betrname) like '" + name.toLowerCase() + "%' OR LOWER(betrvorname) like '" + name.toLowerCase() + "%' OR LOWER(betranrede) like '" + name.toLowerCase() + "%' OR LOWER(betrnamezus) like '" + name.toLowerCase() + "') AND ";
    		}else if (bName && property.equals("anrede"))
    		{
                query += "LOWER(adresse.betranrede) like '" + name.toLowerCase() + "%' AND ";
    		}else if (bName && property.equals("vorname"))
    		{
                query += "LOWER(adresse.betrvorname) like '" + name.toLowerCase() + "%' AND ";
    		}
    		else if (bName && property.equals("name"))
    		{
                query += "LOWER(adresse.betrname) like '" + name.toLowerCase() + "%' AND ";
    		}
    		
    		else if (bName && property.equals("zusatz"))
    		{
                query += "LOWER(adresse.betrnamezus) like '" + name.toLowerCase() + "%' AND ";
    		}
            if(bStrasse){
                query += "LOWER(adresse.strasse) like '" + strasse.toLowerCase() + "%' AND ";
            }
            if(bHausnr){
                query += "adresse.hausnr = " + hausnr + " AND ";
            }
            if(bOrt){
                query += "LOWER(adresse.ort) like '" + ort.toLowerCase() + "%' AND ";
            }

		query += "adresse.deleted = false ";

		query += "ORDER BY adresse.strasse ASC, adresse.hausnr ASC, adresse.hausnrzus ASC, adresse.betrname ASC";
        }
		return HibernateSessionFactory.currentSession().createQuery(query)
				.list();
	}
	
	private static String[] entwaesserungsgebiete = null;

	/**
	 * Get a list of all Entwässerungsgebiet Ids.
	 * 
	 * @return <code>String[]</code>
	 */
	public static String[] getEntwaesserungsgebiete()
	{
		if (DatabaseBasisQuery.entwaesserungsgebiete == null)
		{
			DatabaseBasisQuery.entwaesserungsgebiete = new DatabaseAccess()
					.executeCriteriaToArray(
											DetachedCriteria.forClass(BasisLage.class)
													.setProjection(
																	Projections.distinct(Projections
																			.property("entgebid")))
													.addOrder(Order.asc("entgebid")),
											new String[0]);
		}
		return DatabaseBasisQuery.entwaesserungsgebiete;
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class BasisTabStreets */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	public static List<BasisTabStreets> getTabStreetslist(MatchMode mm)
	{

		DetachedCriteria dc = DetachedCriteria.forClass(BasisTabStreets.class)
				.addOrder(Order.asc("name"));

		List<BasisTabStreets> tabstreetslist = new DatabaseAccess()
				.executeCriteriaToList(dc, new BasisTabStreets());

		return tabstreetslist;

	}

	/**
	 * Get BasisTabStreets
	 * 
	 * @return <code>Eine Liste aller Strassennamen</code>
	 */
	public static String[] getTabStreets()
	{


    	List<String> basisAllTabStreets = getAllTabStreetslist();
    	
    	String[] tabStreets = new String[basisAllTabStreets.size()];
    	return tabStreets = basisAllTabStreets.toArray(tabStreets);
    	
	}

	/**
	 * Get all BasisTabStreets and sort them by their name
	 * @return <code>Eine Liste aller Stassen</code>
	 */
	public static List<String> getAllTabStreetslist() {

        String query =  "SELECT DISTINCT name " + 
                "FROM BasisTabStreets ORDER BY name";
        
        return HibernateSessionFactory.currentSession().createQuery(query).list();
    	
	}
	
	public static List<BasisTabStreets> findStandorte(String strasse)
	{
		return new DatabaseAccess().executeCriteriaToList(
																	DetachedCriteria.forClass(BasisTabStreets.class)
																			.add(Restrictions.eq("name",
																									strasse))
																			.addOrder(Order.asc("hausnr"))
																			.addOrder(Order.asc("hausnrZusatz").nulls(NullPrecedence.FIRST)),
																	new BasisTabStreets());
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class BasisStrassen */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /**
     * Get all BasisStrassen sorted by strasse
     * @return <code>BasisStrassen[]</code>
     */
    public static BasisStrassen[] getAllStrassen() {

    	List<BasisStrassen> basisAllStrassen = getAllStrassenlist();
    	
        return basisAllStrassen.toArray(new BasisStrassen[0]);
    }
	/**
	 * Get all BasisStrassen and sort them by their name
	 * @return <code>Eine Liste aller Stassen</code>
	 */
	public static List<BasisStrassen> getAllStrassenlist() {
	    List<BasisStrassen> strassenlist = new DatabaseAccess().executeCriteriaToList(
	            DetachedCriteria.forClass(BasisStrassen.class)
	                .addOrder(Order.asc("strasse")),
	            new BasisStrassen());
		return strassenlist;
	
	}
	/**
	 * Get BasisStrassen sorted by strasse
	 * 
	 * @return <code>BasisStrassen[]</code>
	 */
	public static BasisStrassen[] getStrassen(String ort, MatchMode mm)
	{

		List<BasisStrassen> basisStrassen = getStrassenlist(ort, mm);

		return basisStrassen.toArray(new BasisStrassen[0]);
	}
	/**
	 * Get BasisStrassen sorted by strasse
	 * 
	 * @return <code>BasisStrassen[]</code>
	 */
	public static List<BasisTabStreets> getTabStreets(MatchMode mm)
	{

		List<BasisTabStreets> basisStrassenlist = new DatabaseAccess()
		.executeCriteriaToList(
								DetachedCriteria.forClass(BasisTabStreets.class)
										.addOrder(Order.asc("name")),
								new BasisTabStreets());
		return basisStrassenlist;
	}

	/**
	 * Get BasisStrassen filtered by plzort and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Stassen</code>
	 */
	public static List<BasisStrassen> getStrassenlist(String ort, MatchMode mm)
	{

		DetachedCriteria dc = DetachedCriteria.forClass(BasisStrassen.class)
				.addOrder(Order.asc("strasse"));

//		if (!StringUtils.isNullOrEmpty(plz))
//		{
//			dc = dc.add(Restrictions.like("plz", plz, mm));
//		}

		if (!StringUtils.isNullOrEmpty(ort))
		{
			dc = dc.add(Restrictions.like("ort", ort, mm));
		}

		List<BasisStrassen> strassenlist = new DatabaseAccess()
				.executeCriteriaToList(dc, new BasisStrassen());

		return strassenlist;

	}

	/**
	 * Get the first matching BasisStrasse for the search String
	 * 
	 * @param search
	 *            String
	 * @return <code>BasisStrassen</code>
	 */
	public static BasisStrassen findStrasse(String search)
	{
		List<BasisStrassen> list = new DatabaseAccess()
				.executeCriteriaToList(
										DetachedCriteria
												.forClass(BasisStrassen.class)
												.add(Restrictions.ilike("strasse", search,
																		MatchMode.START))
												.addOrder(Order.asc("strasse")), new BasisStrassen());
		// If we got something, just return the first result
		return (list.isEmpty() ? null : list.get(0));
	}

	/**
	 * Get next id for new BasisStrassen
	 * 
	 * @return <code>BasisStrassenID</code>
	 */
	public static Integer newStrassenID()
	{
		Integer id = new DatabaseAccess().executeCriteriaToUniqueResult(
																		DetachedCriteria.forClass(BasisStrassen.class)
																				.setProjection(
																								Property.forName("id")
																										.max()),
																		new Integer(0));
		return id + 1;
	}

	private static List<BasisOrte> orte = null;

	/**
	 * Get cities sorted by zip code
	 * 
	 * @return <code>BasisStrassen[]</code>
	 */
	public static BasisOrte[] getOrte()
	{

		if (orte == null)
		{
			orte = getOrtelist();
		}

		return orte.toArray(new BasisOrte[0]);
	}

	/**
	 * Get cities sorted by zip code
	 * 
	 * @return <code>Liste aller Orte</code>
	 */
	public static List<BasisOrte> getOrtelist()
	{

		if (orte == null)
		{
			DetachedCriteria dc = DetachedCriteria
					.forClass(BasisStrassen.class)
					.setProjection(Projections.distinct(Projections.projectionList()
							.add(Projections.property("ort"), "ort")
//							.add(Projections.property("plz"), "plz")
							))
					.setResultTransformer(Transformers.aliasToBean(BasisOrte.class))
					.addOrder(Order.asc("ort"))
//					.addOrder(Order.asc("plz"))
					;

			orte = new DatabaseAccess().executeCriteriaToList(dc, new BasisOrte());
		}

		return orte;

	}
	
	private static BasisOrte ort = null;

	/**
	 * Get city for a given street
	 * 
	 * @return <code>Einen Ort</code>
	 */
	public static BasisOrte getOrt(String street)
	{

//		if (ort == null)
		{
			DetachedCriteria dc = DetachedCriteria
					.forClass(BasisStrassen.class)
					.setProjection(Projections.distinct(Projections.projectionList()
							.add(Projections.property("ort"), "ort")
//							.add(Projections.property("plz"), "plz")
							))
					.setResultTransformer(Transformers.aliasToBean(BasisOrte.class))
					.add(Restrictions.ilike("strasse", street,
							MatchMode.START))
					.addOrder(Order.asc("ort"))
//					.addOrder(Order.asc("plz"))
					;

			ort = new DatabaseAccess().executeCriteriaToUniqueResult(dc, new BasisOrte());
		}

		return ort;

	}

	/* ********************************************************************** */
	/* Queries for package ATL */
	/* ********************************************************************** */

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package ATL : class AtlEinheiten */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	

	/**
	 * Get all AtlEinheiten and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Einheiten</code>
	 */
	public static List<AtlEinheiten> getEinheitenlist()
	{
		List<AtlEinheiten> strassenlist = new DatabaseAccess()
				.executeCriteriaToList(
										DetachedCriteria.forClass(AtlEinheiten.class)
												.addOrder(
															Order.asc("id")),
										new AtlEinheiten());
		return strassenlist;

	}
	
	/**
	 * Get next id for new AtlEinheiten
	 * 
	 * @return <code>AtlEinheitenID</code>
	 */
	public static Integer newEinheitenID()
	{
		Integer id = new DatabaseAccess().executeCriteriaToUniqueResult(
																		DetachedCriteria.forClass(AtlEinheiten.class)
																				.setProjection(
																								Property.forName("id")
																										.max()),
																		new Integer(0));
		return id + 1;
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package ATL : class AtlParameter */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Get all AtlParameter and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Parameter</code>
	 */
	public static List<AtlParameter> getParameterlist()
	{
		List<AtlParameter> parameterlist = new DatabaseAccess()
				.executeCriteriaToList(
										DetachedCriteria.forClass(AtlParameter.class)
												.addOrder(
															Order.asc("id")),
										new AtlParameter());
		return parameterlist;
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package ATL : class AtlKlaeranlage */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Get all AtlKlaeranlagen and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Parameter</code>
	 */
	public static List<AtlKlaeranlagen> getKlaeranlagenlist()
	{
		List<AtlKlaeranlagen> klaeranlagenlist = new DatabaseAccess()
				.executeCriteriaToList(
										DetachedCriteria.forClass(AtlKlaeranlagen.class)
												.addOrder(Order.asc("id")),
										new AtlKlaeranlagen());
		return klaeranlagenlist;
	}

	/**
	 * Get next id for new AtlKlaeranlagen
	 * 
	 * @return <code>AtlKlaeranlagenID</code>
	 */
	public static Integer newKlaeranlagenID()
	{
		Integer id = new DatabaseAccess().executeCriteriaToUniqueResult(
																		DetachedCriteria.forClass(AtlKlaeranlagen.class)
																				.setProjection(
																								Property.forName("id")
																										.max()),
																		new Integer(0));
		return id + 1;
	}

	/* ********************************************************************** */
	/* Queries for package VAWS */
	/* ********************************************************************** */

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package VAWS : class VawsWasserschutzgebiete */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Get all VawsWasserschutzgebiete and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Wasserschutzgebiete</code>
	 */
	public static List<VawsWassereinzugsgebiete> getWasserschutzgebietelist()
	{
		List<VawsWassereinzugsgebiete> wsglist = new DatabaseAccess()
				.executeCriteriaToList(
										DetachedCriteria.forClass(
																	VawsWassereinzugsgebiete.class)
												.addOrder(
															Order.asc("id")),
										new VawsWassereinzugsgebiete());
		return wsglist;

	}

	/**
	 * Get next id for new VawsWassereinzugsgebiete
	 * 
	 * @return <code>VawsWassereinzugsgebieteID</code>
	 */
	public static Integer newWSGID()
	{
		Integer id = new DatabaseAccess().executeCriteriaToUniqueResult(
																		DetachedCriteria.forClass(VawsWassereinzugsgebiete.class)
																				.setProjection(
																								Property.forName("id")
																										.max()),
																		new Integer(0));
		return id + 1;
	}

}
