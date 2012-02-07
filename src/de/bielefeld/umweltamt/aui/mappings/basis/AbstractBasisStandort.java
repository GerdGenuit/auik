/**
 * Copyright 2005-2011, Stadt Bielefeld
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

package de.bielefeld.umweltamt.aui.mappings.basis;

import java.io.Serializable;

import de.bielefeld.umweltamt.aui.mappings.vaws.VawsStandortgghwsg;
import de.bielefeld.umweltamt.aui.mappings.vaws.VawsWassereinzugsgebiete;

/**
 * A class that represents a row in the BASIS_STANDORT table. You can customize
 * the behavior of this class by editing the class, {@link BasisStandort}.
 */
public abstract class AbstractBasisStandort implements Serializable {
    private static final long serialVersionUID = -3432191385268283675L;

    /**
     * The cached hash code value for this instance. Setting to 0 triggers
     * re-calculation.
     */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.Integer standortid;

    /** The value of the basisGemarkung association. */
    private BasisGemarkung basisGemarkung;

    /** The value of the vawsStandortgghwsg association. */
    private VawsStandortgghwsg vawsStandortgghwsg;

    /** The value of the vawsWassereinzugsgebiete association. */
    private VawsWassereinzugsgebiete vawsWassereinzugsgebiete;

    /** The value of the simple strasse property. */
    private java.lang.String strasse;

    /** The value of the simple hausnr property. */
    private java.lang.Integer hausnr;

    /** The value of the simple hausnrzus property. */
    private java.lang.String hausnrzus;

    /** The value of the simple plz property. */
    private java.lang.String plz;

    /** The value of the simple rechtswert property. */
    private java.lang.Float rechtswert;

    /** The value of the simple hochwert property. */
    private java.lang.Float hochwert;

    /** The value of the simple flur property. */
    private java.lang.String flur;

    /** The value of the simple flurstueck property. */
    private java.lang.String flurstueck;

    /** The value of the simple entgebid property. */
    private java.lang.String entgebid;

    /** The value of the simple vornameeigent property. */
    private java.lang.String vornameeigent;

    /** The value of the simple nameeigent property. */
    private java.lang.String nameeigent;

    /** The value of the simple strasseeigent property. */
    private java.lang.String strasseeigent;

    /** The value of the simple hausnreigent property. */
    private java.lang.Integer hausnreigent;

    /** The value of the simple hausnrzuseigent property. */
    private java.lang.String hausnrzuseigent;

    /** The value of the simple revidatum property. */
    private java.util.Date revidatum;

    /** The value of the simple revihandz property. */
    private java.lang.String revihandz;

    /** The value of the simple wassermenge property. */
    private java.lang.Integer wassermenge;

    /** The value of the simple sachbe33rav property. */
    private java.lang.String sachbe33rav;

    /** The value of the simple sachbe33hee property. */
    private java.lang.String sachbe33hee;

    /**
     * Simple constructor of AbstractBasisStandort instances.
     */
    public AbstractBasisStandort() {
    }

    /**
     * Constructor of AbstractBasisStandort instances given a simple primary
     * key.
     * @param standortid
     */
    public AbstractBasisStandort(java.lang.Integer standortid) {
        this.setStandortid(standortid);
    }

    /**
     * Return the simple primary key value that identifies this object.
     * @return java.lang.Integer
     */
    public java.lang.Integer getStandortid() {
        return standortid;
    }

    /**
     * Set the simple primary key value that identifies this object.
     * @param standortid
     */
    public void setStandortid(java.lang.Integer standortid) {
        this.hashValue = 0;
        this.standortid = standortid;
    }

    /**
     * Return the value of the STRASSE column.
     * @return java.lang.String
     */
    public java.lang.String getStrasse() {
        return this.strasse;
    }

    /**
     * Set the value of the STRASSE column.
     * @param strasse
     */
    public void setStrasse(java.lang.String strasse) {
        this.strasse = strasse;
    }

    /**
     * Return the value of the HAUSNR column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getHausnr() {
        return this.hausnr;
    }

    /**
     * Set the value of the HAUSNR column.
     * @param hausnr
     */
    public void setHausnr(java.lang.Integer hausnr) {
        this.hausnr = hausnr;
    }

    /**
     * Return the value of the HAUSNRZUS column.
     * @return java.lang.String
     */
    public java.lang.String getHausnrzus() {
        return this.hausnrzus;
    }

    /**
     * Set the value of the HAUSNRZUS column.
     * @param hausnrzus
     */
    public void setHausnrzus(java.lang.String hausnrzus) {
        this.hausnrzus = hausnrzus;
    }

    /**
     * Return the value of the PLZ column.
     * @return java.lang.String
     */
    public java.lang.String getPlz() {
        return this.plz;
    }

    /**
     * Set the value of the PLZ column.
     * @param plz
     */
    public void setPlz(java.lang.String plz) {
        this.plz = plz;
    }

    /**
     * Return the value of the RECHTSWERT column.
     * @return java.lang.Float
     */
    public java.lang.Float getRechtswert() {
        return this.rechtswert;
    }

    /**
     * Set the value of the RECHTSWERT column.
     * @param rechtswert
     */
    public void setRechtswert(java.lang.Float rechtswert) {
        this.rechtswert = rechtswert;
    }

    /**
     * Return the value of the HOCHWERT column.
     * @return java.lang.Float
     */
    public java.lang.Float getHochwert() {
        return this.hochwert;
    }

    /**
     * Set the value of the HOCHWERT column.
     * @param hochwert
     */
    public void setHochwert(java.lang.Float hochwert) {
        this.hochwert = hochwert;
    }

    /**
     * Return the value of the GEMARKUNGID column.
     * @return BasisGemarkung
     */
    public BasisGemarkung getBasisGemarkung() {
        return this.basisGemarkung;
    }

    /**
     * Set the value of the GEMARKUNGID column.
     * @param basisGemarkung
     */
    public void setBasisGemarkung(BasisGemarkung basisGemarkung) {
        this.basisGemarkung = basisGemarkung;
    }

    /**
     * Return the value of the FLUR column.
     * @return java.lang.String
     */
    public java.lang.String getFlur() {
        return this.flur;
    }

    /**
     * Set the value of the FLUR column.
     * @param flur
     */
    public void setFlur(java.lang.String flur) {
        this.flur = flur;
    }

    /**
     * Return the value of the FLURSTUECK column.
     * @return java.lang.String
     */
    public java.lang.String getFlurstueck() {
        return this.flurstueck;
    }

    /**
     * Set the value of the FLURSTUECK column.
     * @param flurstueck
     */
    public void setFlurstueck(java.lang.String flurstueck) {
        this.flurstueck = flurstueck;
    }

    /**
     * Return the value of the ENTGEBID column.
     * @return java.lang.String
     */
    public java.lang.String getEntgebid() {
        return this.entgebid;
    }

    /**
     * Set the value of the ENTGEBID column.
     * @param entgebid
     */
    public void setEntgebid(java.lang.String entgebid) {
        this.entgebid = entgebid;
    }

    /**
     * Return the value of the STANDORTGEGEBID column.
     * @return VawsStandortgghwsg
     */
    public VawsStandortgghwsg getVawsStandortgghwsg() {
        return this.vawsStandortgghwsg;
    }

    /**
     * Set the value of the STANDORTGEGEBID column.
     * @param vawsStandortgghwsg
     */
    public void setVawsStandortgghwsg(VawsStandortgghwsg vawsStandortgghwsg) {
        this.vawsStandortgghwsg = vawsStandortgghwsg;
    }

    /**
     * Return the value of the WASSEREINZGEBID column.
     * @return VawsWassereinzugsgebiete
     */
    public VawsWassereinzugsgebiete getVawsWassereinzugsgebiete() {
        return this.vawsWassereinzugsgebiete;
    }

    /**
     * Set the value of the WASSEREINZGEBID column.
     * @param vawsWassereinzugsgebiete
     */
    public void setVawsWassereinzugsgebiete(
        VawsWassereinzugsgebiete vawsWassereinzugsgebiete) {
        this.vawsWassereinzugsgebiete = vawsWassereinzugsgebiete;
    }

    /**
     * Return the value of the VORNAMEEIGENT column.
     * @return java.lang.String
     */
    public java.lang.String getVornameeigent() {
        return this.vornameeigent;
    }

    /**
     * Set the value of the VORNAMEEIGENT column.
     * @param vornameeigent
     */
    public void setVornameeigent(java.lang.String vornameeigent) {
        this.vornameeigent = vornameeigent;
    }

    /**
     * Return the value of the NAMEEIGENT column.
     * @return java.lang.String
     */
    public java.lang.String getNameeigent() {
        return this.nameeigent;
    }

    /**
     * Set the value of the NAMEEIGENT column.
     * @param nameeigent
     */
    public void setNameeigent(java.lang.String nameeigent) {
        this.nameeigent = nameeigent;
    }

    /**
     * Return the value of the STRASSEEIGENT column.
     * @return java.lang.String
     */
    public java.lang.String getStrasseeigent() {
        return this.strasseeigent;
    }

    /**
     * Set the value of the STRASSEEIGENT column.
     * @param strasseeigent
     */
    public void setStrasseeigent(java.lang.String strasseeigent) {
        this.strasseeigent = strasseeigent;
    }

    /**
     * Return the value of the HAUSNREIGENT column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getHausnreigent() {
        return this.hausnreigent;
    }

    /**
     * Set the value of the HAUSNREIGENT column.
     * @param hausnreigent
     */
    public void setHausnreigent(java.lang.Integer hausnreigent) {
        this.hausnreigent = hausnreigent;
    }

    /**
     * Return the value of the HAUSNRZUSEIGENT column.
     * @return java.lang.String
     */
    public java.lang.String getHausnrzuseigent() {
        return this.hausnrzuseigent;
    }

    /**
     * Set the value of the HAUSNRZUSEIGENT column.
     * @param hausnrzuseigent
     */
    public void setHausnrzuseigent(java.lang.String hausnrzuseigent) {
        this.hausnrzuseigent = hausnrzuseigent;
    }

    /**
     * Return the value of the REVIDATUM column.
     * @return java.util.Date
     */
    public java.util.Date getRevidatum() {
        return this.revidatum;
    }

    /**
     * Set the value of the REVIDATUM column.
     * @param revidatum
     */
    public void setRevidatum(java.util.Date revidatum) {
        this.revidatum = revidatum;
    }

    /**
     * Return the value of the REVIHANDZ column.
     * @return java.lang.String
     */
    public java.lang.String getRevihandz() {
        return this.revihandz;
    }

    /**
     * Set the value of the REVIHANDZ column.
     * @param revihandz
     */
    public void setRevihandz(java.lang.String revihandz) {
        this.revihandz = revihandz;
    }

    /**
     * Return the value of the Wassermenge column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getWassermenge() {
        return this.wassermenge;
    }

    /**
     * Set the value of the Wassermenge column.
     * @param hausnr
     */
    public void setWassermenge(java.lang.Integer wassermenge) {
        this.wassermenge = wassermenge;
    }

    /**
     * Return the value of the Sachbearbeiter33 column.
     * @return java.lang.String
     */
    public java.lang.String getSachbe33rav() {
        return this.sachbe33rav;
    }

    /**
     * Set the value of the Sachbearbeiter33 column.
     * @param revihandz
     */
    public void setSachbe33rav(java.lang.String sachbe33rav) {
        this.sachbe33rav = sachbe33rav;
    }

    /**
     * Return the value of the Sachbearbeiter33 column.
     * @return java.lang.String
     */
    public java.lang.String getSachbe33hee() {
        return this.sachbe33hee;
    }

    /**
     * Set the value of the Sachbearbeiter33 column.
     * @param revihandz
     */
    public void setSachbe33hee(java.lang.String sachbe33hee) {
        this.sachbe33hee = sachbe33hee;
    }

    /**
     * Implementation of the equals comparison on the basis of equality of the
     * primary key values.
     * @param rhs
     * @return boolean
     */
    @Override
    public boolean equals(Object rhs) {
        if (rhs == null)
            return false;
        if (!(rhs instanceof BasisStandort))
            return false;
        BasisStandort that = (BasisStandort) rhs;
        if (this.getStandortid() != null && that.getStandortid() != null) {
            if (!this.getStandortid().equals(that.getStandortid())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Implementation of the hashCode method conforming to the Bloch pattern
     * with the exception of array properties (these are very unlikely primary
     * key types).
     * @return int
     */
    @Override
    public int hashCode() {
        if (this.hashValue == 0) {
            int result = 17;
            int standortidValue = this.getStandortid() == null ? 0 : this
                .getStandortid().hashCode();
            result = result * 37 + standortidValue;
            this.hashValue = result;
        }
        return this.hashValue;
    }
}
