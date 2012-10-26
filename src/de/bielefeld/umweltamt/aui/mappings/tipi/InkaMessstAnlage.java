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

package de.bielefeld.umweltamt.aui.mappings.tipi;

import java.util.Calendar;
import java.util.List;

import de.bielefeld.umweltamt.aui.mappings.DatabaseQuery;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import de.bielefeld.umweltamt.aui.utils.DatabaseAccess;
import de.nrw.lds.tipi.general.HistoryObject;

/**
 * A class that represents a row in the InkaMessstAnlage database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class InkaMessstAnlage  implements java.io.Serializable {

    /** Generated serialVersionUID for Serializable interface */
    private static final long serialVersionUID = DatabaseTipi.serialVersionUIDForInkaMessstAnlage;

    /* Primary key, foreign keys (relations) and table columns */
    private InkaMessstAnlageId id;
    private String gemeindekennzahl;
    private Integer gemeindeVer;
    private Integer uebergabestelleLfdNr;
    private Integer uebergabestelleVer;
    private Integer messstelleVer;
    private Integer anlageVer;
    private Integer messstAnlageVer;
    private Calendar gueltigVon;
    private Calendar gueltigBis;
    private Calendar aenderungsDatum;
    private Calendar erfassungsDatum;
    private Integer historienNr;
    private Boolean istAktuellJn;

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public InkaMessstAnlage() {
        // This place is intentionally left blank.
    }

    /** Minimal constructor */
    public InkaMessstAnlage(
        InkaMessstAnlageId id) {
        this.id = id;
    }

    /** Full constructor */
    public InkaMessstAnlage(
        InkaMessstAnlageId id, String gemeindekennzahl, Integer gemeindeVer, Integer uebergabestelleLfdNr, Integer uebergabestelleVer, Integer messstelleVer, Integer anlageVer, Integer messstAnlageVer, Calendar gueltigVon, Calendar gueltigBis, Calendar aenderungsDatum, Calendar erfassungsDatum, Integer historienNr, Boolean istAktuellJn) {
        this.id = id;
        this.gemeindekennzahl = gemeindekennzahl;
        this.gemeindeVer = gemeindeVer;
        this.uebergabestelleLfdNr = uebergabestelleLfdNr;
        this.uebergabestelleVer = uebergabestelleVer;
        this.messstelleVer = messstelleVer;
        this.anlageVer = anlageVer;
        this.messstAnlageVer = messstAnlageVer;
        this.gueltigVon = gueltigVon;
        this.gueltigBis = gueltigBis;
        this.aenderungsDatum = aenderungsDatum;
        this.erfassungsDatum = erfassungsDatum;
        this.historienNr = historienNr;
        this.istAktuellJn = istAktuellJn;
    }

    /* Setter and getter methods */
    public InkaMessstAnlageId getId() {
        return this.id;
    }

    public void setId(InkaMessstAnlageId id) {
        this.id = id;
    }

    public String getGemeindekennzahl() {
        return this.gemeindekennzahl;
    }

    public void setGemeindekennzahl(String gemeindekennzahl) {
        this.gemeindekennzahl = gemeindekennzahl;
    }

    public Integer getGemeindeVer() {
        return this.gemeindeVer;
    }

    public void setGemeindeVer(Integer gemeindeVer) {
        this.gemeindeVer = gemeindeVer;
    }

    public Integer getUebergabestelleLfdNr() {
        return this.uebergabestelleLfdNr;
    }

    public void setUebergabestelleLfdNr(Integer uebergabestelleLfdNr) {
        this.uebergabestelleLfdNr = uebergabestelleLfdNr;
    }

    public Integer getUebergabestelleVer() {
        return this.uebergabestelleVer;
    }

    public void setUebergabestelleVer(Integer uebergabestelleVer) {
        this.uebergabestelleVer = uebergabestelleVer;
    }

    public Integer getMessstelleVer() {
        return this.messstelleVer;
    }

    public void setMessstelleVer(Integer messstelleVer) {
        this.messstelleVer = messstelleVer;
    }

    public Integer getAnlageVer() {
        return this.anlageVer;
    }

    public void setAnlageVer(Integer anlageVer) {
        this.anlageVer = anlageVer;
    }

    public Integer getMessstAnlageVer() {
        return this.messstAnlageVer;
    }

    public void setMessstAnlageVer(Integer messstAnlageVer) {
        this.messstAnlageVer = messstAnlageVer;
    }

    public Calendar getGueltigVon() {
        return this.gueltigVon;
    }

    public void setGueltigVon(Calendar gueltigVon) {
        this.gueltigVon = gueltigVon;
    }

    public Calendar getGueltigBis() {
        return this.gueltigBis;
    }

    public void setGueltigBis(Calendar gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    public Calendar getAenderungsDatum() {
        return this.aenderungsDatum;
    }

    public void setAenderungsDatum(Calendar aenderungsDatum) {
        this.aenderungsDatum = aenderungsDatum;
    }

    public Calendar getErfassungsDatum() {
        return this.erfassungsDatum;
    }

    public void setErfassungsDatum(Calendar erfassungsDatum) {
        this.erfassungsDatum = erfassungsDatum;
    }

    public Integer getHistorienNr() {
        return this.historienNr;
    }

    public void setHistorienNr(Integer historienNr) {
        this.historienNr = historienNr;
    }

    public Boolean getIstAktuellJn() {
        return this.istAktuellJn;
    }

    public void setIstAktuellJn(Boolean istAktuellJn) {
        this.istAktuellJn = istAktuellJn;
    }

    /**
     * Get a string representation for debugging
     * @return String
     */
    public String toDebugString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append(getClass().getSimpleName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        buffer.append("id").append("='").append(getId()).append("' ");
        buffer.append("gemeindekennzahl").append("='").append(getGemeindekennzahl()).append("' ");
        buffer.append("gemeindeVer").append("='").append(getGemeindeVer()).append("' ");
        buffer.append("uebergabestelleLfdNr").append("='").append(getUebergabestelleLfdNr()).append("' ");
        buffer.append("uebergabestelleVer").append("='").append(getUebergabestelleVer()).append("' ");
        buffer.append("messstelleVer").append("='").append(getMessstelleVer()).append("' ");
        buffer.append("anlageVer").append("='").append(getAnlageVer()).append("' ");
        buffer.append("messstAnlageVer").append("='").append(getMessstAnlageVer()).append("' ");
        buffer.append("gueltigVon").append("='").append(getGueltigVon()).append("' ");
        buffer.append("gueltigBis").append("='").append(getGueltigBis()).append("' ");
        buffer.append("aenderungsDatum").append("='").append(getAenderungsDatum()).append("' ");
        buffer.append("erfassungsDatum").append("='").append(getErfassungsDatum()).append("' ");
        buffer.append("historienNr").append("='").append(getHistorienNr()).append("' ");
        buffer.append("istAktuellJn").append("='").append(getIstAktuellJn()).append("' ");
        buffer.append("]");

        return buffer.toString();
    }

    /**
     * Merge (save or update) a detached instance
     * @param detachedInstance the instance to merge
     * @return <code>InkaMessstAnlage</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static InkaMessstAnlage merge(InkaMessstAnlage detachedInstance) {
        log.debug("Merging InkaMessstAnlage instance " + detachedInstance);
        return (InkaMessstAnlage) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        return InkaMessstAnlage.merge(this).equals(this);
    }

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(InkaMessstAnlage detachedInstance) {
        log.debug("Deleting InkaMessstAnlage instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return InkaMessstAnlage.delete(this);
    }

    /**
     * Find an <code>InkaMessstAnlage</code> instance by its primary key
     * @param id the primary key value
     * @return <code>InkaMessstAnlage</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static InkaMessstAnlage findById(InkaMessstAnlageId id) {
        log.debug("Getting InkaMessstAnlage instance with id: " + id);
        return (InkaMessstAnlage)
            new DatabaseAccess().get(InkaMessstAnlage.class, id);
    }

    /**
     * Get a list of all <code>InkaMessstAnlage</code>
     * @return <code>List&lt;InkaMessstAnlage&gt;</code>
     *         all <code>InkaMessstAnlage</code>
     */
    public static List<InkaMessstAnlage> getAll() {
        return DatabaseQuery.getAll(new InkaMessstAnlage());
    }

    /**
     * As we can not generate this bit of code completely
     * (ordering of the parameters is the main problem),
     * we jump to not generated code.
     * @return HistoryObject (the corresponding service type to InkaMessstAnlage)
     */
    public HistoryObject toServiceType() {
        return DatabaseTipi.toServiceTypeForClass(this);
    }

    /* Custom code goes below here! */

}
