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

package de.bielefeld.umweltamt.aui.mappings.vaws;

import java.io.Serializable;

import de.bielefeld.umweltamt.aui.mappings.AbstractVirtuallyDeletableDatabaseTable;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisObjekt;

/**
 * A class that represents a row in the ANH_49_FACHDATEN table. You can
 * customize the behavior of this class by editing the class, {@link
 * Anh49Fachdaten()}.
 */
public abstract class AbstractVawsFachdaten extends
    AbstractVirtuallyDeletableDatabaseTable implements Serializable {
    private static final long serialVersionUID = -589821249124686675L;

    /**
     * The cached hash code value for this instance. Setting to 0 triggers
     * re-calculation.
     */
    private int hashValue = 0;

    /** The simple primary key value. */
    private java.lang.Integer behaelterId;

    /** The value of the simple basisObjekt assoc. */
    private BasisObjekt basisObjekt;

    private String herstellnr;
    private String hersteller;
    private java.util.Date datumInbetriebnahme;
    private java.util.Date datumErfassung;
    private java.util.Date datumAenderung;
    private java.util.Date datumGenehmigung;
    private java.lang.String anlagenart;
    private java.lang.String behaelterart;
    private java.lang.String material;
    private java.lang.String fluessigkeit;
    private java.lang.String vbfeinstufung;
    private java.lang.Double menge;
    private java.lang.Integer wgk;
    private java.lang.String gefaehrdungsstufe;
    private java.lang.Integer baujahr;
    private java.lang.Boolean doppelwandig;
    private java.lang.Boolean leckanzeige;
    private java.lang.Boolean auffangraum;
    private java.lang.Boolean grenzwertgeber;
    private java.lang.Boolean leckschutzauskleidung;
    private java.lang.Boolean kellerlagerung;
    private java.lang.Boolean innenbeschichtung;
    private java.lang.String beschreibung_a;
    private java.lang.String beschreibung_s;
    private java.lang.Boolean oberirdisch;
    private java.lang.Boolean unterirdisch;
    private java.lang.Boolean saugleitung;
    private java.lang.Boolean rohrKathodenschutz;
    private java.lang.Boolean ausKupfer;
    private java.lang.Boolean ausStahl;
    private java.lang.Boolean mitSchutzrohr;
    private java.lang.String beschreibung_r;
    private java.lang.Double pruefturnus;
    private java.lang.Boolean angemahntkz;
    private java.util.Date mahnfrist;
    private java.util.Date wiedervorlage;
    private java.util.Date stillegungsdatum;
    private java.lang.String bemerkungen;
    private java.lang.String ausfuehrung;
    private java.lang.String pruefumfang;
    private java.lang.String verwendung;
    private java.lang.Boolean ausHdpe;
    private java.lang.Boolean druckleitung;
    private java.lang.Boolean schutzSensor;
    private java.lang.Boolean schutzFolie;
    private java.lang.Boolean schutzAntiheber;

    /**
     * Simple constructor of AbstractVawsFachdaten instances.
     */
    public AbstractVawsFachdaten() {
    }

    /**
     * Constructor of AbstractVawsFachdaten instances given a simple primary
     * key.
     * @param basisObjekt
     */
    public AbstractVawsFachdaten(Integer behaelterId) {
        this.setBehaelterId(behaelterId);
    }

    /**
     * Return the simple primary key value that identifies this object.
     * @return java.lang.Integer
     */
    public java.lang.Integer getBehaelterId() {
        return this.behaelterId;
    }

    /**
     * Set the simple primary key value that identifies this object.
     * @param nr
     */
    public void setBehaelterId(java.lang.Integer behaelterId) {
        this.hashValue = 0;
        this.behaelterId = behaelterId;
    }

    /**
     * Return the value of the BASIS_OBJEKT column.
     * @return BasisObjekt
     */
    public BasisObjekt getBasisObjekt() {
        return basisObjekt;
    }

    /**
     * Set the value of the BASIS_OBJEKT column.
     * @param basisObjekt
     */
    public void setBasisObjekt(BasisObjekt basisObjekt) {
        this.basisObjekt = basisObjekt;
    }

    /**
     * @return Returns the angemahntkz.
     */
    public java.lang.Boolean getAngemahntkz() {
        return angemahntkz;
    }

    /**
     * @param angemahntkz The angemahntkz to set.
     */
    public void setAngemahntkz(java.lang.Boolean angemahntkz) {
        this.angemahntkz = angemahntkz;
    }

    /**
     * @return Returns the anlagenart.
     */
    public java.lang.String getAnlagenart() {
        return anlagenart;
    }

    /**
     * @param anlagenart The anlagenart to set.
     */
    public void setAnlagenart(java.lang.String anlagenart) {
        this.anlagenart = anlagenart;
    }

    /**
     * @return Returns the auffangraum.
     */
    public java.lang.Boolean getAuffangraum() {
        return auffangraum;
    }

    /**
     * @param auffangraum The auffangraum to set.
     */
    public void setAuffangraum(java.lang.Boolean auffangraum) {
        this.auffangraum = auffangraum;
    }

    /**
     * @return Returns the ausKupfer.
     */
    public java.lang.Boolean getAusKupfer() {
        return ausKupfer;
    }

    /**
     * @param ausKupfer The ausKupfer to set.
     */
    public void setAusKupfer(java.lang.Boolean ausKupfer) {
        this.ausKupfer = ausKupfer;
    }

    /**
     * @return Returns the ausStahl.
     */
    public java.lang.Boolean getAusStahl() {
        return ausStahl;
    }

    /**
     * @param ausStahl The ausStahl to set.
     */
    public void setAusStahl(java.lang.Boolean ausStahl) {
        this.ausStahl = ausStahl;
    }

    /**
     * @return Returns the ausfuehrung.
     */
    public java.lang.String getAusfuehrung() {
        return ausfuehrung;
    }

    /**
     * @param ausfuehrung The ausfuehrung to set.
     */
    public void setAusfuehrung(java.lang.String ausfuehrung) {
        this.ausfuehrung = ausfuehrung;
    }

    /**
     * @return Returns the baujahr.
     */
    public java.lang.Integer getBaujahr() {
        return baujahr;
    }

    /**
     * @param baujahr The baujahr to set.
     */
    public void setBaujahr(java.lang.Integer baujahr) {
        this.baujahr = baujahr;
    }

    /**
     * @return Returns the behaelterart.
     */
    public java.lang.String getBehaelterart() {
        return behaelterart;
    }

    /**
     * @param behaelterart The behaelterart to set.
     */
    public void setBehaelterart(java.lang.String behaelterart) {
        this.behaelterart = behaelterart;
    }

    /**
     * @return Returns the bemerkungen.
     */
    public java.lang.String getBemerkungen() {
        return bemerkungen;
    }

    /**
     * @param bemerkungen The bemerkungen to set.
     */
    public void setBemerkungen(java.lang.String bemerkungen) {
        this.bemerkungen = bemerkungen;
    }

    /**
     * @return Returns the beschreibung_a.
     */
    public java.lang.String getBeschreibung_a() {
        return beschreibung_a;
    }

    /**
     * @param beschreibung_a The beschreibung_a to set.
     */
    public void setBeschreibung_a(java.lang.String beschreibung_a) {
        this.beschreibung_a = beschreibung_a;
    }

    /**
     * @return Returns the beschreibung_r.
     */
    public java.lang.String getBeschreibung_r() {
        return beschreibung_r;
    }

    /**
     * @param beschreibung_r The beschreibung_r to set.
     */
    public void setBeschreibung_r(java.lang.String beschreibung_r) {
        this.beschreibung_r = beschreibung_r;
    }

    /**
     * @return Returns the beschreibung_s.
     */
    public java.lang.String getBeschreibung_s() {
        return beschreibung_s;
    }

    /**
     * @param beschreibung_s The beschreibung_s to set.
     */
    public void setBeschreibung_s(java.lang.String beschreibung_s) {
        this.beschreibung_s = beschreibung_s;
    }

    /**
     * @return Returns the datumAenderung.
     */
    public java.util.Date getDatumAenderung() {
        return datumAenderung;
    }

    /**
     * @param datumAenderung The datumAenderung to set.
     */
    public void setDatumAenderung(java.util.Date datumAenderung) {
        this.datumAenderung = datumAenderung;
    }

    /**
     * @return Returns the datumErfassung.
     */
    public java.util.Date getDatumErfassung() {
        return datumErfassung;
    }

    /**
     * @param datumErfassung The datumErfassung to set.
     */
    public void setDatumErfassung(java.util.Date datumErfassung) {
        this.datumErfassung = datumErfassung;
    }

    /**
     * @return Returns the datumGenehmigung.
     */
    public java.util.Date getDatumGenehmigung() {
        return datumGenehmigung;
    }

    /**
     * @param datumGenehmigung The datumGenehmigung to set.
     */
    public void setDatumGenehmigung(java.util.Date datumGenehmigung) {
        this.datumGenehmigung = datumGenehmigung;
    }

    /**
     * @return Returns the datumInbetriebnahme.
     */
    public java.util.Date getDatumInbetriebnahme() {
        return datumInbetriebnahme;
    }

    /**
     * @param datumInbetriebnahme The datumInbetriebnahme to set.
     */
    public void setDatumInbetriebnahme(java.util.Date datumInbetriebnahme) {
        this.datumInbetriebnahme = datumInbetriebnahme;
    }

    /**
     * @return Returns the doppelwandig.
     */
    public java.lang.Boolean getDoppelwandig() {
        return doppelwandig;
    }

    /**
     * @param doppelwandig The doppelwandig to set.
     */
    public void setDoppelwandig(java.lang.Boolean doppelwandig) {
        this.doppelwandig = doppelwandig;
    }

    /**
     * @return Returns the fluessigkeit.
     */
    public java.lang.String getFluessigkeit() {
        return fluessigkeit;
    }

    /**
     * @param fluessigkeit The fluessigkeit to set.
     */
    public void setFluessigkeit(java.lang.String fluessigkeit) {
        this.fluessigkeit = fluessigkeit;
    }

    /**
     * @return Returns the gefaehrdungsstufe.
     */
    public java.lang.String getGefaehrdungsstufe() {
        return gefaehrdungsstufe;
    }

    /**
     * @param gefaehrdungsstufe The gefaehrdungsstufe to set.
     */
    public void setGefaehrdungsstufe(java.lang.String gefaehrdungsstufe) {
        this.gefaehrdungsstufe = gefaehrdungsstufe;
    }

    /**
     * @return Returns the grenzwertgeber.
     */
    public java.lang.Boolean getGrenzwertgeber() {
        return grenzwertgeber;
    }

    /**
     * @param grenzwertgeber The grenzwertgeber to set.
     */
    public void setGrenzwertgeber(java.lang.Boolean grenzwertgeber) {
        this.grenzwertgeber = grenzwertgeber;
    }

    /**
     * @return Returns the hashValue.
     */
    public int getHashValue() {
        return hashValue;
    }

    /**
     * @param hashValue The hashValue to set.
     */
    public void setHashValue(int hashValue) {
        this.hashValue = hashValue;
    }

    /**
     * @return Returns the hersteller.
     */
    public String getHersteller() {
        return hersteller;
    }

    /**
     * @param hersteller The hersteller to set.
     */
    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    /**
     * @return Returns the herstellnr.
     */
    public String getHerstellnr() {
        return herstellnr;
    }

    /**
     * @param herstellnr The herstellnr to set.
     */
    public void setHerstellnr(String herstellnr) {
        this.herstellnr = herstellnr;
    }

    /**
     * @return Returns the innenbeschichtung.
     */
    public java.lang.Boolean getInnenbeschichtung() {
        return innenbeschichtung;
    }

    /**
     * @param innenbeschichtung The innenbeschichtung to set.
     */
    public void setInnenbeschichtung(java.lang.Boolean innenbeschichtung) {
        this.innenbeschichtung = innenbeschichtung;
    }

    /**
     * @return Returns the kellerlagerung.
     */
    public java.lang.Boolean getKellerlagerung() {
        return kellerlagerung;
    }

    /**
     * @param kellerlagerung The kellerlagerung to set.
     */
    public void setKellerlagerung(java.lang.Boolean kellerlagerung) {
        this.kellerlagerung = kellerlagerung;
    }

    /**
     * @return Returns the leckanzeige.
     */
    public java.lang.Boolean getLeckanzeige() {
        return leckanzeige;
    }

    /**
     * @param leckanzeige The leckanzeige to set.
     */
    public void setLeckanzeige(java.lang.Boolean leckanzeige) {
        this.leckanzeige = leckanzeige;
    }

    /**
     * @return Returns the leckschutzauskleidung.
     */
    public java.lang.Boolean getLeckschutzauskleidung() {
        return leckschutzauskleidung;
    }

    /**
     * @param leckschutzauskleidung The leckschutzauskleidung to set.
     */
    public void setLeckschutzauskleidung(java.lang.Boolean leckschutzauskleidung) {
        this.leckschutzauskleidung = leckschutzauskleidung;
    }

    /**
     * @return Returns the mahnfrist.
     */
    public java.util.Date getMahnfrist() {
        return mahnfrist;
    }

    /**
     * @param mahnfrist The mahnfrist to set.
     */
    public void setMahnfrist(java.util.Date mahnfrist) {
        this.mahnfrist = mahnfrist;
    }

    /**
     * @return Returns the material.
     */
    public java.lang.String getMaterial() {
        return material;
    }

    /**
     * @param material The material to set.
     */
    public void setMaterial(java.lang.String material) {
        this.material = material;
    }

    /**
     * @return Returns the menge.
     */
    public java.lang.Double getMenge() {
        return menge;
    }

    /**
     * @param menge The menge to set.
     */
    public void setMenge(java.lang.Double menge) {
        this.menge = menge;
    }

    /**
     * @return Returns the mitSchutzrohr.
     */
    public java.lang.Boolean getMitSchutzrohr() {
        return mitSchutzrohr;
    }

    /**
     * @param mitSchutzrohr The mitSchutzrohr to set.
     */
    public void setMitSchutzrohr(java.lang.Boolean mitSchutzrohr) {
        this.mitSchutzrohr = mitSchutzrohr;
    }

    /**
     * @return Returns the oberirdisch.
     */
    public java.lang.Boolean getOberirdisch() {
        return oberirdisch;
    }

    /**
     * @param oberirdisch The oberirdisch to set.
     */
    public void setOberirdisch(java.lang.Boolean oberirdisch) {
        this.oberirdisch = oberirdisch;
    }

    /**
     * @return Returns the pruefturnus.
     */
    public java.lang.Double getPruefturnus() {
        return pruefturnus;
    }

    /**
     * @param pruefturnus The pruefturnus to set.
     */
    public void setPruefturnus(java.lang.Double pruefturnus) {
        this.pruefturnus = pruefturnus;
    }

    /**
     * @return Returns the pruefumfang.
     */
    public java.lang.String getPruefumfang() {
        return pruefumfang;
    }

    /**
     * @param pruefumfang The pruefumfang to set.
     */
    public void setPruefumfang(java.lang.String pruefumfang) {
        this.pruefumfang = pruefumfang;
    }

    /**
     * @return Returns the rohrKathodenschutz.
     */
    public java.lang.Boolean getRohrKathodenschutz() {
        return rohrKathodenschutz;
    }

    /**
     * @param rohrKathodenschutz The rohrKathodenschutz to set.
     */
    public void setRohrKathodenschutz(java.lang.Boolean rohrKathodenschutz) {
        this.rohrKathodenschutz = rohrKathodenschutz;
    }

    /**
     * @return Returns the saugleitung.
     */
    public java.lang.Boolean getSaugleitung() {
        return saugleitung;
    }

    /**
     * @param saugleitung The saugleitung to set.
     */
    public void setSaugleitung(java.lang.Boolean saugleitung) {
        this.saugleitung = saugleitung;
    }

    /**
     * @return Returns the stillegungsdatum.
     */
    public java.util.Date getStillegungsdatum() {
        return stillegungsdatum;
    }

    /**
     * @param stillegungsdatum The stillegungsdatum to set.
     */
    public void setStillegungsdatum(java.util.Date stillegungsdatum) {
        this.stillegungsdatum = stillegungsdatum;
    }

    /**
     * @return Returns the unterirdisch.
     */
    public java.lang.Boolean getUnterirdisch() {
        return unterirdisch;
    }

    /**
     * @param unterirdisch The unterirdisch to set.
     */
    public void setUnterirdisch(java.lang.Boolean unterirdisch) {
        this.unterirdisch = unterirdisch;
    }

    /**
     * @return Returns the vbfeinstufung.
     */
    public java.lang.String getVbfeinstufung() {
        return vbfeinstufung;
    }

    /**
     * @param vbfeinstufung The vbfeinstufung to set.
     */
    public void setVbfeinstufung(java.lang.String vbfeinstufung) {
        this.vbfeinstufung = vbfeinstufung;
    }

    /**
     * @return Returns the verwendung.
     */
    public java.lang.String getVerwendung() {
        return verwendung;
    }

    /**
     * @param verwendung The verwendung to set.
     */
    public void setVerwendung(java.lang.String verwendung) {
        this.verwendung = verwendung;
    }

    /**
     * @return Returns the wgk.
     */
    public java.lang.Integer getWgk() {
        return wgk;
    }

    /**
     * @param wgk The wgk to set.
     */
    public void setWgk(java.lang.Integer wgk) {
        this.wgk = wgk;
    }

    /**
     * @return Returns the wiedervorlage.
     */
    public java.util.Date getWiedervorlage() {
        return wiedervorlage;
    }

    /**
     * @param wiedervorlage The wiedervorlage to set.
     */
    public void setWiedervorlage(java.util.Date wiedervorlage) {
        this.wiedervorlage = wiedervorlage;
    }

    /**
     * @return Returns the ausHdpe.
     */
    public java.lang.Boolean getAusHdpe() {
        return ausHdpe;
    }

    /**
     * @param ausHdpe The ausHdpe to set.
     */
    public void setAusHdpe(java.lang.Boolean ausHdpe) {
        this.ausHdpe = ausHdpe;
    }

    /**
     * @return Returns the druckleitung.
     */
    public java.lang.Boolean getDruckleitung() {
        return druckleitung;
    }

    /**
     * @param druckleitung The druckleitung to set.
     */
    public void setDruckleitung(java.lang.Boolean druckleitung) {
        this.druckleitung = druckleitung;
    }

    /**
     * @return Returns the schutzSensor.
     */
    public java.lang.Boolean getSchutzSensor() {
        return schutzSensor;
    }

    /**
     * @param schutzSensor The schutzSensor to set.
     */
    public void setSchutzSensor(java.lang.Boolean schutzSensor) {
        this.schutzSensor = schutzSensor;
    }

    /**
     * @return Returns the schutzFolie.
     */
    public java.lang.Boolean getSchutzFolie() {
        return schutzFolie;
    }

    /**
     * @param schutzFolie The schutzFolie to set.
     */
    public void setSchutzFolie(java.lang.Boolean schutzFolie) {
        this.schutzFolie = schutzFolie;
    }

    /**
     * @return Returns the schutzAntiheber.
     */
    public java.lang.Boolean getSchutzAntiheber() {
        return schutzAntiheber;
    }

    /**
     * @param schutzAntiheber The schutzAntiheber to set.
     */
    public void setSchutzAntiheber(java.lang.Boolean schutzAntiheber) {
        this.schutzAntiheber = schutzAntiheber;
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
        if (!(rhs instanceof VawsFachdaten))
            return false;
        VawsFachdaten that = (VawsFachdaten) rhs;
        if (this.getBasisObjekt() != null && that.getBasisObjekt() != null) {
            if (!this.getBasisObjekt().equals(that.getBasisObjekt())) {
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
            int basisObjektValue = this.getBasisObjekt() == null ? 0 : this
                .getBasisObjekt().hashCode();
            result = result * 37 + basisObjektValue;
            this.hashValue = result;
        }
        return this.hashValue;
    }
}
