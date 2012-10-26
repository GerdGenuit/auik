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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.bielefeld.umweltamt.aui.mappings.DatabaseQuery;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import de.bielefeld.umweltamt.aui.utils.DatabaseAccess;

/**
 * A class that represents a row in the DeaWzCode database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class DeaWzCode  implements java.io.Serializable {

    /** Generated serialVersionUID for Serializable interface */
    private static final long serialVersionUID = DatabaseTipi.serialVersionUIDForDeaWzCode;

    /* Primary key, foreign keys (relations) and table columns */
    private DeaWzCodeId id;
    private Calendar inkaGueltigVon;
    private Calendar inkaGueltigBis;
    private short istAktuellTog;
    private Calendar erfassungsDatum;
    private Calendar aenderungsDatum;
    private int ebene;
    private Character abschnittId;
    private Character UAbschnittId;
    private String abteilungId;
    private Character grpId;
    private Character klaId;
    private Character UKlaId;
    private String bezeichnung;
    private int zustandsNr;
    private Calendar gueltigVon;
    private Calendar igStichtag;
    private Calendar gueltigBis;
    private Calendar erstellDat;
    private Calendar aktualDat;
    private int versionsnr;
    private Calendar zeitstempel;
    private Set<AuikWzCode> auikWzCodes = new HashSet<AuikWzCode>(0);

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public DeaWzCode() {
        // This place is intentionally left blank.
    }

    /** Minimal constructor */
    public DeaWzCode(
        DeaWzCodeId id, Calendar inkaGueltigVon, short istAktuellTog, Calendar erfassungsDatum, int ebene, String bezeichnung, int zustandsNr, Calendar gueltigVon, Calendar erstellDat, Calendar aktualDat, int versionsnr) {
        this.id = id;
        this.inkaGueltigVon = inkaGueltigVon;
        this.istAktuellTog = istAktuellTog;
        this.erfassungsDatum = erfassungsDatum;
        this.ebene = ebene;
        this.bezeichnung = bezeichnung;
        this.zustandsNr = zustandsNr;
        this.gueltigVon = gueltigVon;
        this.erstellDat = erstellDat;
        this.aktualDat = aktualDat;
        this.versionsnr = versionsnr;
    }

    /** Full constructor */
    public DeaWzCode(
        DeaWzCodeId id, Calendar inkaGueltigVon, Calendar inkaGueltigBis, short istAktuellTog, Calendar erfassungsDatum, Calendar aenderungsDatum, int ebene, Character abschnittId, Character UAbschnittId, String abteilungId, Character grpId, Character klaId, Character UKlaId, String bezeichnung, int zustandsNr, Calendar gueltigVon, Calendar igStichtag, Calendar gueltigBis, Calendar erstellDat, Calendar aktualDat, int versionsnr, Calendar zeitstempel, Set<AuikWzCode> auikWzCodes) {
        this.id = id;
        this.inkaGueltigVon = inkaGueltigVon;
        this.inkaGueltigBis = inkaGueltigBis;
        this.istAktuellTog = istAktuellTog;
        this.erfassungsDatum = erfassungsDatum;
        this.aenderungsDatum = aenderungsDatum;
        this.ebene = ebene;
        this.abschnittId = abschnittId;
        this.UAbschnittId = UAbschnittId;
        this.abteilungId = abteilungId;
        this.grpId = grpId;
        this.klaId = klaId;
        this.UKlaId = UKlaId;
        this.bezeichnung = bezeichnung;
        this.zustandsNr = zustandsNr;
        this.gueltigVon = gueltigVon;
        this.igStichtag = igStichtag;
        this.gueltigBis = gueltigBis;
        this.erstellDat = erstellDat;
        this.aktualDat = aktualDat;
        this.versionsnr = versionsnr;
        this.zeitstempel = zeitstempel;
        this.auikWzCodes = auikWzCodes;
    }

    /* Setter and getter methods */
    public DeaWzCodeId getId() {
        return this.id;
    }

    public void setId(DeaWzCodeId id) {
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

    public int getEbene() {
        return this.ebene;
    }

    public void setEbene(int ebene) {
        this.ebene = ebene;
    }

    public Character getAbschnittId() {
        return this.abschnittId;
    }

    public void setAbschnittId(Character abschnittId) {
        this.abschnittId = abschnittId;
    }

    public Character getUAbschnittId() {
        return this.UAbschnittId;
    }

    public void setUAbschnittId(Character UAbschnittId) {
        this.UAbschnittId = UAbschnittId;
    }

    public String getAbteilungId() {
        return this.abteilungId;
    }

    public void setAbteilungId(String abteilungId) {
        this.abteilungId = abteilungId;
    }

    public Character getGrpId() {
        return this.grpId;
    }

    public void setGrpId(Character grpId) {
        this.grpId = grpId;
    }

    public Character getKlaId() {
        return this.klaId;
    }

    public void setKlaId(Character klaId) {
        this.klaId = klaId;
    }

    public Character getUKlaId() {
        return this.UKlaId;
    }

    public void setUKlaId(Character UKlaId) {
        this.UKlaId = UKlaId;
    }

    public String getBezeichnung() {
        return this.bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
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

    public int getVersionsnr() {
        return this.versionsnr;
    }

    public void setVersionsnr(int versionsnr) {
        this.versionsnr = versionsnr;
    }

    public Calendar getZeitstempel() {
        return this.zeitstempel;
    }

    public void setZeitstempel(Calendar zeitstempel) {
        this.zeitstempel = zeitstempel;
    }

    public Set<AuikWzCode> getAuikWzCodes() {
        return this.auikWzCodes;
    }

    public void setAuikWzCodes(Set<AuikWzCode> auikWzCodes) {
        this.auikWzCodes = auikWzCodes;
    }

    /**
     * Get a string representation for debugging
     * @return String
     */
    public String toDebugString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append(getClass().getSimpleName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        buffer.append("id").append("='").append(getId()).append("' ");
        buffer.append("inkaGueltigVon").append("='").append(getInkaGueltigVon()).append("' ");
        buffer.append("inkaGueltigBis").append("='").append(getInkaGueltigBis()).append("' ");
        buffer.append("istAktuellTog").append("='").append(getIstAktuellTog()).append("' ");
        buffer.append("erfassungsDatum").append("='").append(getErfassungsDatum()).append("' ");
        buffer.append("aenderungsDatum").append("='").append(getAenderungsDatum()).append("' ");
        buffer.append("ebene").append("='").append(getEbene()).append("' ");
        buffer.append("abschnittId").append("='").append(getAbschnittId()).append("' ");
        buffer.append("UAbschnittId").append("='").append(getUAbschnittId()).append("' ");
        buffer.append("abteilungId").append("='").append(getAbteilungId()).append("' ");
        buffer.append("grpId").append("='").append(getGrpId()).append("' ");
        buffer.append("klaId").append("='").append(getKlaId()).append("' ");
        buffer.append("UKlaId").append("='").append(getUKlaId()).append("' ");
        buffer.append("bezeichnung").append("='").append(getBezeichnung()).append("' ");
        buffer.append("zustandsNr").append("='").append(getZustandsNr()).append("' ");
        buffer.append("gueltigVon").append("='").append(getGueltigVon()).append("' ");
        buffer.append("igStichtag").append("='").append(getIgStichtag()).append("' ");
        buffer.append("gueltigBis").append("='").append(getGueltigBis()).append("' ");
        buffer.append("erstellDat").append("='").append(getErstellDat()).append("' ");
        buffer.append("aktualDat").append("='").append(getAktualDat()).append("' ");
        buffer.append("versionsnr").append("='").append(getVersionsnr()).append("' ");
        buffer.append("zeitstempel").append("='").append(getZeitstempel()).append("' ");
        buffer.append("auikWzCodes").append("='").append(getAuikWzCodes()).append("' ");
        buffer.append("]");

        return buffer.toString();
    }

    /**
     * Merge (save or update) a detached instance
     * @param detachedInstance the instance to merge
     * @return <code>DeaWzCode</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static DeaWzCode merge(DeaWzCode detachedInstance) {
        log.debug("Merging DeaWzCode instance " + detachedInstance);
        return (DeaWzCode) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        return DeaWzCode.merge(this).equals(this);
    }

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(DeaWzCode detachedInstance) {
        log.debug("Deleting DeaWzCode instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return DeaWzCode.delete(this);
    }

    /**
     * Find an <code>DeaWzCode</code> instance by its primary key
     * @param id the primary key value
     * @return <code>DeaWzCode</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static DeaWzCode findById(DeaWzCodeId id) {
        log.debug("Getting DeaWzCode instance with id: " + id);
        return (DeaWzCode)
            new DatabaseAccess().get(DeaWzCode.class, id);
    }

    /**
     * Get a list of all <code>DeaWzCode</code>
     * @return <code>List&lt;DeaWzCode&gt;</code>
     *         all <code>DeaWzCode</code>
     */
    public static List<DeaWzCode> getAll() {
        return DatabaseQuery.getAll(new DeaWzCode());
    }

    /* Custom code goes below here! */

}
