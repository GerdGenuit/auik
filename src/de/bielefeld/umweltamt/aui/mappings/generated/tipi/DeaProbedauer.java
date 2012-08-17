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
 * A class that represents a row in the DeaProbedauer database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class DeaProbedauer  implements java.io.Serializable {

    /* Primary key, foreign keys (relations) and table columns */
    private DeaProbedauerId id;
    private Calendar inkaGueltigVon;
    private Calendar inkaGueltigBis;
    private short istAktuellTog;
    private Calendar erfassungsDatum;
    private Calendar aenderungsDatum;
    private String name;
    private int zustandsNr;
    private Calendar gueltigVon;
    private Calendar igStichtag;
    private Calendar gueltigBis;
    private Calendar erstellDat;
    private Calendar aktualDat;
    private int verisonsnr;
    private Calendar zeitstempel;

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public DeaProbedauer() {
        // This place is intentionally left blank.
    }

    /** Minimal constructor */
    public DeaProbedauer(
        DeaProbedauerId id, Calendar inkaGueltigVon, short istAktuellTog, Calendar erfassungsDatum, String name, int zustandsNr, Calendar gueltigVon, Calendar erstellDat, Calendar aktualDat, int verisonsnr) {
        this.id = id;
        this.inkaGueltigVon = inkaGueltigVon;
        this.istAktuellTog = istAktuellTog;
        this.erfassungsDatum = erfassungsDatum;
        this.name = name;
        this.zustandsNr = zustandsNr;
        this.gueltigVon = gueltigVon;
        this.erstellDat = erstellDat;
        this.aktualDat = aktualDat;
        this.verisonsnr = verisonsnr;
    }

    /** Full constructor */
    public DeaProbedauer(
        DeaProbedauerId id, Calendar inkaGueltigVon, Calendar inkaGueltigBis, short istAktuellTog, Calendar erfassungsDatum, Calendar aenderungsDatum, String name, int zustandsNr, Calendar gueltigVon, Calendar igStichtag, Calendar gueltigBis, Calendar erstellDat, Calendar aktualDat, int verisonsnr, Calendar zeitstempel) {
        this.id = id;
        this.inkaGueltigVon = inkaGueltigVon;
        this.inkaGueltigBis = inkaGueltigBis;
        this.istAktuellTog = istAktuellTog;
        this.erfassungsDatum = erfassungsDatum;
        this.aenderungsDatum = aenderungsDatum;
        this.name = name;
        this.zustandsNr = zustandsNr;
        this.gueltigVon = gueltigVon;
        this.igStichtag = igStichtag;
        this.gueltigBis = gueltigBis;
        this.erstellDat = erstellDat;
        this.aktualDat = aktualDat;
        this.verisonsnr = verisonsnr;
        this.zeitstempel = zeitstempel;
    }

    /* Setter and getter methods */
    public DeaProbedauerId getId() {
        return this.id;
    }

    public void setId(DeaProbedauerId id) {
        this.id = id;
    }

    public Calendar getInkaGueltigVon() {
        return this.inkaGueltigVon;
    }

    public void setInkaGueltigVon(Calendar inkaGueltigVon) {
        this.inkaGueltigVon = inkaGueltigVon;
    }

    public Calendar getInkaGueltigBis() {
        return this.inkaGueltigBis;
    }

    public void setInkaGueltigBis(Calendar inkaGueltigBis) {
        this.inkaGueltigBis = inkaGueltigBis;
    }

    public short getIstAktuellTog() {
        return this.istAktuellTog;
    }

    public void setIstAktuellTog(short istAktuellTog) {
        this.istAktuellTog = istAktuellTog;
    }

    public Calendar getErfassungsDatum() {
        return this.erfassungsDatum;
    }

    public void setErfassungsDatum(Calendar erfassungsDatum) {
        this.erfassungsDatum = erfassungsDatum;
    }

    public Calendar getAenderungsDatum() {
        return this.aenderungsDatum;
    }

    public void setAenderungsDatum(Calendar aenderungsDatum) {
        this.aenderungsDatum = aenderungsDatum;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZustandsNr() {
        return this.zustandsNr;
    }

    public void setZustandsNr(int zustandsNr) {
        this.zustandsNr = zustandsNr;
    }

    public Calendar getGueltigVon() {
        return this.gueltigVon;
    }

    public void setGueltigVon(Calendar gueltigVon) {
        this.gueltigVon = gueltigVon;
    }

    public Calendar getIgStichtag() {
        return this.igStichtag;
    }

    public void setIgStichtag(Calendar igStichtag) {
        this.igStichtag = igStichtag;
    }

    public Calendar getGueltigBis() {
        return this.gueltigBis;
    }

    public void setGueltigBis(Calendar gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    public Calendar getErstellDat() {
        return this.erstellDat;
    }

    public void setErstellDat(Calendar erstellDat) {
        this.erstellDat = erstellDat;
    }

    public Calendar getAktualDat() {
        return this.aktualDat;
    }

    public void setAktualDat(Calendar aktualDat) {
        this.aktualDat = aktualDat;
    }

    public int getVerisonsnr() {
        return this.verisonsnr;
    }

    public void setVerisonsnr(int verisonsnr) {
        this.verisonsnr = verisonsnr;
    }

    public Calendar getZeitstempel() {
        return this.zeitstempel;
    }

    public void setZeitstempel(Calendar zeitstempel) {
        this.zeitstempel = zeitstempel;
    }

    /**
     * Merge (save or update) a detached instance
     * @param detachedInstance the instance to merge
     * @return <code>DeaProbedauer</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static DeaProbedauer merge(DeaProbedauer detachedInstance) {
        log.debug("Merging DeaProbedauer instance " + detachedInstance);
        return (DeaProbedauer) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        return DeaProbedauer.merge(this).equals(this);
    }

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(DeaProbedauer detachedInstance) {
        log.debug("Deleting DeaProbedauer instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return DeaProbedauer.delete(this);
    }

    /**
     * Find an <code>DeaProbedauer</code> instance by its primary key
     * @param id the primary key value
     * @return <code>DeaProbedauer</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static DeaProbedauer findById(de.bielefeld.umweltamt.aui.mappings.generated.tipi.DeaProbedauerId id) {
        log.debug("Getting DeaProbedauer instance with id: " + id);
        return (DeaProbedauer)
            new DatabaseAccess().get(DeaProbedauer.class, id);
    }

    /**
     * Get a list of all <code>DeaProbedauer</code>
     * @return <code>List&lt;DeaProbedauer&gt;</code>
     *         all <code>DeaProbedauer</code>
     */
    public static List<DeaProbedauer> getAll() {
        log.debug("Getting all DeaProbedauer instances");
        String query = "FROM DeaProbedauer";
        List<?> objectList = new DatabaseAccess().createQuery(query).list(); 
        List<DeaProbedauer> resultList = new ArrayList<DeaProbedauer>();
        DeaProbedauer result = null;
        for (Object object : objectList) {
            result = (DeaProbedauer) object;
            resultList.add(result); 
        }
        return resultList;
    }

    /* Custom code goes below here! */

}
