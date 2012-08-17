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
 * A class that represents a row in the Anh49Kontrollen database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class Anh49Kontrollen  implements java.io.Serializable {

    /* Primary key, foreign keys (relations) and table columns */
    private Integer id;
    private Anh49Fachdaten anh49Fachdaten;
    private Calendar pruefdatum;
    private Calendar naechstepruefung;
    private String pruefergebnis;
    private boolean enabled;
    private boolean deleted;

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public Anh49Kontrollen() {
        // This place is intentionally left blank.
    }

    /** Minimal constructor */
    public Anh49Kontrollen(
        boolean enabled, boolean deleted) {
        this.enabled = enabled;
        this.deleted = deleted;
    }

    /** Full constructor */
    public Anh49Kontrollen(
        Anh49Fachdaten anh49Fachdaten, Calendar pruefdatum, Calendar naechstepruefung, String pruefergebnis, boolean enabled, boolean deleted) {
        this.anh49Fachdaten = anh49Fachdaten;
        this.pruefdatum = pruefdatum;
        this.naechstepruefung = naechstepruefung;
        this.pruefergebnis = pruefergebnis;
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

    public Calendar getPruefdatum() {
        return this.pruefdatum;
    }

    public void setPruefdatum(Calendar pruefdatum) {
        this.pruefdatum = pruefdatum;
    }

    public Calendar getNaechstepruefung() {
        return this.naechstepruefung;
    }

    public void setNaechstepruefung(Calendar naechstepruefung) {
        this.naechstepruefung = naechstepruefung;
    }

    public String getPruefergebnis() {
        return this.pruefergebnis;
    }

    public void setPruefergebnis(String pruefergebnis) {
        this.pruefergebnis = pruefergebnis;
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
     * @return <code>Anh49Kontrollen</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static Anh49Kontrollen merge(Anh49Kontrollen detachedInstance) {
        log.debug("Merging Anh49Kontrollen instance " + detachedInstance);
        return (Anh49Kontrollen) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        return Anh49Kontrollen.merge(this).equals(this);
    }

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(Anh49Kontrollen detachedInstance) {
        log.debug("Deleting Anh49Kontrollen instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return Anh49Kontrollen.delete(this);
    }

    /**
     * Find an <code>Anh49Kontrollen</code> instance by its primary key
     * @param id the primary key value
     * @return <code>Anh49Kontrollen</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static Anh49Kontrollen findById(java.lang.Integer id) {
        log.debug("Getting Anh49Kontrollen instance with id: " + id);
        return (Anh49Kontrollen)
            new DatabaseAccess().get(Anh49Kontrollen.class, id);
    }

    /**
     * Get a list of all <code>Anh49Kontrollen</code>
     * @return <code>List&lt;Anh49Kontrollen&gt;</code>
     *         all <code>Anh49Kontrollen</code>
     */
    public static List<Anh49Kontrollen> getAll() {
        log.debug("Getting all Anh49Kontrollen instances");
        String query = "FROM Anh49Kontrollen";
        List<?> objectList = new DatabaseAccess().createQuery(query).list(); 
        List<Anh49Kontrollen> resultList = new ArrayList<Anh49Kontrollen>();
        Anh49Kontrollen result = null;
        for (Object object : objectList) {
            result = (Anh49Kontrollen) object;
            resultList.add(result); 
        }
        return resultList;
    }

    /* Custom code goes below here! */

}
