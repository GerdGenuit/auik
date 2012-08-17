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

package de.bielefeld.umweltamt.aui.mappings.generated.tipi;

import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import de.bielefeld.umweltamt.aui.utils.DatabaseAccess;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A class that represents a row in the InkaGenehmigung database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class InkaGenehmigung  implements java.io.Serializable {

    /* Primary key, foreign keys (relations) and table columns */
    private Integer genehmigungNr;
    private Integer genehmigungVer;
    private Calendar gueltigVon;
    private Calendar gueltigBis;
    private Calendar aenderungsDatum;
    private Calendar erfassungsDatum;
    private Integer historienNr;
    private Boolean istAktuellJn;
    private Integer betriebNr;
    private Integer betriebVer;
    private String behoerdenId;
    private Integer behoerdenVer;
    private Calendar genehmigungDatum;
    private Boolean befristetJn;
    private Calendar befristetBis;

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public InkaGenehmigung() {
        // This place is intentionally left blank.
    }

    /** Minimal constructor */
    public InkaGenehmigung(
        Integer genehmigungNr) {
        this.genehmigungNr = genehmigungNr;
    }

    /** Full constructor */
    public InkaGenehmigung(
        Integer genehmigungNr, Integer genehmigungVer, Calendar gueltigVon, Calendar gueltigBis, Calendar aenderungsDatum, Calendar erfassungsDatum, Integer historienNr, Boolean istAktuellJn, Integer betriebNr, Integer betriebVer, String behoerdenId, Integer behoerdenVer, Calendar genehmigungDatum, Boolean befristetJn, Calendar befristetBis) {
        this.genehmigungNr = genehmigungNr;
        this.genehmigungVer = genehmigungVer;
        this.gueltigVon = gueltigVon;
        this.gueltigBis = gueltigBis;
        this.aenderungsDatum = aenderungsDatum;
        this.erfassungsDatum = erfassungsDatum;
        this.historienNr = historienNr;
        this.istAktuellJn = istAktuellJn;
        this.betriebNr = betriebNr;
        this.betriebVer = betriebVer;
        this.behoerdenId = behoerdenId;
        this.behoerdenVer = behoerdenVer;
        this.genehmigungDatum = genehmigungDatum;
        this.befristetJn = befristetJn;
        this.befristetBis = befristetBis;
    }

    /* Setter and getter methods */
    public Integer getGenehmigungNr() {
        return this.genehmigungNr;
    }

    public void setGenehmigungNr(Integer genehmigungNr) {
        this.genehmigungNr = genehmigungNr;
    }

    public Integer getGenehmigungVer() {
        return this.genehmigungVer;
    }

    public void setGenehmigungVer(Integer genehmigungVer) {
        this.genehmigungVer = genehmigungVer;
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

    public Integer getBetriebNr() {
        return this.betriebNr;
    }

    public void setBetriebNr(Integer betriebNr) {
        this.betriebNr = betriebNr;
    }

    public Integer getBetriebVer() {
        return this.betriebVer;
    }

    public void setBetriebVer(Integer betriebVer) {
        this.betriebVer = betriebVer;
    }

    public String getBehoerdenId() {
        return this.behoerdenId;
    }

    public void setBehoerdenId(String behoerdenId) {
        this.behoerdenId = behoerdenId;
    }

    public Integer getBehoerdenVer() {
        return this.behoerdenVer;
    }

    public void setBehoerdenVer(Integer behoerdenVer) {
        this.behoerdenVer = behoerdenVer;
    }

    public Calendar getGenehmigungDatum() {
        return this.genehmigungDatum;
    }

    public void setGenehmigungDatum(Calendar genehmigungDatum) {
        this.genehmigungDatum = genehmigungDatum;
    }

    public Boolean getBefristetJn() {
        return this.befristetJn;
    }

    public void setBefristetJn(Boolean befristetJn) {
        this.befristetJn = befristetJn;
    }

    public Calendar getBefristetBis() {
        return this.befristetBis;
    }

    public void setBefristetBis(Calendar befristetBis) {
        this.befristetBis = befristetBis;
    }

    /**
     * Merge (save or update) a detached instance
     * @param detachedInstance the instance to merge
     * @return <code>InkaGenehmigung</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static InkaGenehmigung merge(InkaGenehmigung detachedInstance) {
        log.debug("Merging InkaGenehmigung instance " + detachedInstance);
        return (InkaGenehmigung) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        return InkaGenehmigung.merge(this).equals(this);
    }

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(InkaGenehmigung detachedInstance) {
        log.debug("Deleting InkaGenehmigung instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return InkaGenehmigung.delete(this);
    }

    /**
     * Find an <code>InkaGenehmigung</code> instance by its primary key
     * @param id the primary key value
     * @return <code>InkaGenehmigung</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static InkaGenehmigung findById(java.lang.Integer id) {
        log.debug("Getting InkaGenehmigung instance with id: " + id);
        return (InkaGenehmigung)
            new DatabaseAccess().get(InkaGenehmigung.class, id);
    }

    /**
     * Get a list of all <code>InkaGenehmigung</code>
     * @return <code>List&lt;InkaGenehmigung&gt;</code>
     *         all <code>InkaGenehmigung</code>
     */
    public static List<InkaGenehmigung> getAll() {
        log.debug("Getting all InkaGenehmigung instances");
        String query = "FROM InkaGenehmigung";
        List<?> objectList = new DatabaseAccess().createQuery(query).list(); 
        List<InkaGenehmigung> resultList = new ArrayList<InkaGenehmigung>();
        InkaGenehmigung result = null;
        for (Object object : objectList) {
            result = (InkaGenehmigung) object;
            resultList.add(result); 
        }
        return resultList;
    }

    /* Custom code goes below here! */

}
