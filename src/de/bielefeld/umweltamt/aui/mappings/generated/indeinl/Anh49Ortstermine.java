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

// Generated by Hibernate Tools 3.3.0.GA

package de.bielefeld.umweltamt.aui.mappings.generated.indeinl;

import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import de.bielefeld.umweltamt.aui.utils.DatabaseAccess;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A class that represents a row in the Anh49Ortstermine database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class Anh49Ortstermine  implements java.io.Serializable {

    /* Primary key, foreign keys (relations) and table columns */
    private Integer id;
    private Anh49Fachdaten anh49Fachdaten;
    private Calendar datum;
    private String sachbearbeiterIn;
    private String bemerkungen;
    private boolean enabled;
    private boolean deleted;

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public Anh49Ortstermine() {
        // This place is intentionally left blank.
    }

    /** Minimal constructor */
    public Anh49Ortstermine(
        boolean enabled, boolean deleted) {
        this.enabled = enabled;
        this.deleted = deleted;
    }

    /** Full constructor */
    public Anh49Ortstermine(
        Anh49Fachdaten anh49Fachdaten, Calendar datum, String sachbearbeiterIn, String bemerkungen, boolean enabled, boolean deleted) {
        this.anh49Fachdaten = anh49Fachdaten;
        this.datum = datum;
        this.sachbearbeiterIn = sachbearbeiterIn;
        this.bemerkungen = bemerkungen;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    /* Setter and getter methods */
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Anh49Fachdaten getAnh49Fachdaten() {
        return this.anh49Fachdaten;
    }

    public void setAnh49Fachdaten(Anh49Fachdaten anh49Fachdaten) {
        this.anh49Fachdaten = anh49Fachdaten;
    }

    public Calendar getDatum() {
        return this.datum;
    }

    public void setDatum(Calendar datum) {
        this.datum = datum;
    }

    public String getSachbearbeiterIn() {
        return this.sachbearbeiterIn;
    }

    public void setSachbearbeiterIn(String sachbearbeiterIn) {
        this.sachbearbeiterIn = sachbearbeiterIn;
    }

    public String getBemerkungen() {
        return this.bemerkungen;
    }

    public void setBemerkungen(String bemerkungen) {
        this.bemerkungen = bemerkungen;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * Merge (save or update) a detached instance
     * @param detachedInstance the instance to merge
     * @return <code>Anh49Ortstermine</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static Anh49Ortstermine merge(Anh49Ortstermine detachedInstance) {
        log.debug("Merging Anh49Ortstermine instance " + detachedInstance);
        return (Anh49Ortstermine) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        return Anh49Ortstermine.merge(this).equals(this);
    }

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(Anh49Ortstermine detachedInstance) {
        log.debug("Deleting Anh49Ortstermine instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return Anh49Ortstermine.delete(this);
    }

    /**
     * Find an <code>Anh49Ortstermine</code> instance by its primary key
     * @param id the primary key value
     * @return <code>Anh49Ortstermine</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static Anh49Ortstermine findById(java.lang.Integer id) {
        log.debug("Getting Anh49Ortstermine instance with id: " + id);
        return (Anh49Ortstermine)
            new DatabaseAccess().get(Anh49Ortstermine.class, id);
    }

    /**
     * Get a list of all <code>Anh49Ortstermine</code>
     * @return <code>List&lt;Anh49Ortstermine&gt;</code>
     *         all <code>Anh49Ortstermine</code>
     */
    public static List<Anh49Ortstermine> getAll() {
        log.debug("Getting all Anh49Ortstermine instances");
        String query = "FROM Anh49Ortstermine";
        List<?> objectList = new DatabaseAccess().createQuery(query).list(); 
        List<Anh49Ortstermine> resultList = new ArrayList<Anh49Ortstermine>();
        Anh49Ortstermine result = null;
        for (Object object : objectList) {
            result = (Anh49Ortstermine) object;
            resultList.add(result); 
        }
        return resultList;
    }

    /* Custom code goes below here! */

}
