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

package de.bielefeld.umweltamt.aui.mappings.vaws;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.bielefeld.umweltamt.aui.mappings.DatabaseAccess;
import de.bielefeld.umweltamt.aui.mappings.DatabaseClassToString;
import de.bielefeld.umweltamt.aui.mappings.DatabaseQuery;
import de.bielefeld.umweltamt.aui.mappings.DatabaseSerialVersionUID;
import de.bielefeld.umweltamt.aui.mappings.basis.BasisObjekt;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;

/**
 * A class that represents a row in the VawsFachdaten database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class VawsFachdaten  implements java.io.Serializable {

    /** Generated serialVersionUID for Serializable interface */
    private static final long serialVersionUID =
        DatabaseSerialVersionUID.forVawsFachdaten;

    /* Primary key, foreign keys (relations) and table columns */
    private Integer behaelterid;
    private BasisObjekt basisObjekt;
    private String herstellnr;
    private String hersteller;
    private Date datuminbetriebnahme;
    private Date datumerfassung;
    private Date datumaenderung;
    private Date datumgenehmigung;
    private String anlagenart;
    private String behaelterart;
    private String material;
    private String fluessigkeit;
    private String vbfeinstufung;
    private Double menge;
    private Integer wgk;
    private String gefaehrdungsstufe;
    private Integer baujahr;
    private Boolean doppelwandig;
    private Boolean leckanzeige;
    private Boolean auffangraum;
    private Boolean grenzwertgeber;
    private Boolean leckschutzauskleidung;
    private Boolean kellerlagerung;
    private Boolean innenbeschichtung;
    private String beschreibungA;
    private String beschreibungS;
    private Boolean oberirdisch;
    private Boolean unterirdisch;
    private Boolean saugleitung;
    private Boolean rohrKathodenschutz;
    private Boolean ausKupfer;
    private Boolean ausStahl;
    private Boolean mitSchutzrohr;
    private String beschreibungR;
    private Double pruefturnus;
    private Boolean angemahntkz;
    private Date mahnfrist;
    private Date wiedervorlage;
    private Date stillegungsdatum;
    private String bemerkungen;
    private String ausfuehrung;
    private String pruefumfang;
    private String verwendung;
    private boolean enabled;
    private boolean deleted;
    private Boolean ausHdpe;
    private Boolean druckleitung;
    private Boolean schutzSensor;
    private Boolean schutzFolie;
    private Boolean schutzAntiheber;
    private String aktenzeichen;
    private Set<VawsVerwaltungsverf> vawsVerwaltungsverfs = new HashSet<VawsVerwaltungsverf>(0);
    private Set<VawsKontrollen> vawsKontrollens = new HashSet<VawsKontrollen>(0);
    private Set<VawsAnlagenchrono> vawsAnlagenchronos = new HashSet<VawsAnlagenchrono>(0);
    private Set<VawsVerwaltungsgebuehren> vawsVerwaltungsgebuehrens = new HashSet<VawsVerwaltungsgebuehren>(0);
    private Set<VawsAbscheider> vawsAbscheiders = new HashSet<VawsAbscheider>(0);
    private Set<VawsAbfuellflaeche> vawsAbfuellflaeches = new HashSet<VawsAbfuellflaeche>(0);
    private Set<VawsJgs> vawsJgss = new HashSet<VawsJgs>(0);

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public VawsFachdaten() {
        // This place is intentionally left blank.
    }

    /** Minimal constructor */
    public VawsFachdaten(
        BasisObjekt basisObjekt, boolean enabled, boolean deleted) {
        this.basisObjekt = basisObjekt;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    /** Full constructor */
    public VawsFachdaten(
        BasisObjekt basisObjekt, String herstellnr, String hersteller, Date datuminbetriebnahme, Date datumerfassung, Date datumaenderung, Date datumgenehmigung, String anlagenart, String behaelterart, String material, String fluessigkeit, String vbfeinstufung, Double menge, Integer wgk, String gefaehrdungsstufe, Integer baujahr, Boolean doppelwandig, Boolean leckanzeige, Boolean auffangraum, Boolean grenzwertgeber, Boolean leckschutzauskleidung, Boolean kellerlagerung, Boolean innenbeschichtung, String beschreibungA, String beschreibungS, Boolean oberirdisch, Boolean unterirdisch, Boolean saugleitung, Boolean rohrKathodenschutz, Boolean ausKupfer, Boolean ausStahl, Boolean mitSchutzrohr, String beschreibungR, Double pruefturnus, Boolean angemahntkz, Date mahnfrist, Date wiedervorlage, Date stillegungsdatum, String bemerkungen, String ausfuehrung, String pruefumfang, String verwendung, boolean enabled, boolean deleted, Boolean ausHdpe, Boolean druckleitung, Boolean schutzSensor, Boolean schutzFolie, Boolean schutzAntiheber, String aktenzeichen, Set<VawsVerwaltungsverf> vawsVerwaltungsverfs, Set<VawsKontrollen> vawsKontrollens, Set<VawsAbscheider> vawsAbscheiders, Set<VawsAnlagenchrono> vawsAnlagenchronos, Set<VawsVerwaltungsgebuehren> vawsVerwaltungsgebuehrens, Set<VawsAbfuellflaeche> vawsAbfuellflaeches, Set<VawsJgs> vawsJgss) {
        this.basisObjekt = basisObjekt;
        this.herstellnr = herstellnr;
        this.hersteller = hersteller;
        this.datuminbetriebnahme = datuminbetriebnahme;
        this.datumerfassung = datumerfassung;
        this.datumaenderung = datumaenderung;
        this.datumgenehmigung = datumgenehmigung;
        this.anlagenart = anlagenart;
        this.behaelterart = behaelterart;
        this.material = material;
        this.fluessigkeit = fluessigkeit;
        this.vbfeinstufung = vbfeinstufung;
        this.menge = menge;
        this.wgk = wgk;
        this.gefaehrdungsstufe = gefaehrdungsstufe;
        this.baujahr = baujahr;
        this.doppelwandig = doppelwandig;
        this.leckanzeige = leckanzeige;
        this.auffangraum = auffangraum;
        this.grenzwertgeber = grenzwertgeber;
        this.leckschutzauskleidung = leckschutzauskleidung;
        this.kellerlagerung = kellerlagerung;
        this.innenbeschichtung = innenbeschichtung;
        this.beschreibungA = beschreibungA;
        this.beschreibungS = beschreibungS;
        this.oberirdisch = oberirdisch;
        this.unterirdisch = unterirdisch;
        this.saugleitung = saugleitung;
        this.rohrKathodenschutz = rohrKathodenschutz;
        this.ausKupfer = ausKupfer;
        this.ausStahl = ausStahl;
        this.mitSchutzrohr = mitSchutzrohr;
        this.beschreibungR = beschreibungR;
        this.pruefturnus = pruefturnus;
        this.angemahntkz = angemahntkz;
        this.mahnfrist = mahnfrist;
        this.wiedervorlage = wiedervorlage;
        this.stillegungsdatum = stillegungsdatum;
        this.bemerkungen = bemerkungen;
        this.ausfuehrung = ausfuehrung;
        this.pruefumfang = pruefumfang;
        this.verwendung = verwendung;
        this.enabled = enabled;
        this.deleted = deleted;
        this.ausHdpe = ausHdpe;
        this.druckleitung = druckleitung;
        this.schutzSensor = schutzSensor;
        this.schutzFolie = schutzFolie;
        this.schutzAntiheber = schutzAntiheber;
        this.aktenzeichen = aktenzeichen;
        this.vawsVerwaltungsverfs = vawsVerwaltungsverfs;
        this.vawsKontrollens = vawsKontrollens;
        this.vawsAnlagenchronos = vawsAnlagenchronos;
        this.vawsVerwaltungsgebuehrens = vawsVerwaltungsgebuehrens;
        this.vawsAbscheiders = vawsAbscheiders;
        this.vawsAbfuellflaeches = vawsAbfuellflaeches;
        this.vawsJgss = vawsJgss;
    }

    /* Setter and getter methods */
    public Integer getBehaelterid() {
        return this.behaelterid;
    }

    public void setBehaelterid(Integer behaelterid) {
        this.behaelterid = behaelterid;
    }

    public BasisObjekt getBasisObjekt() {
        return this.basisObjekt;
    }

    public void setBasisObjekt(BasisObjekt basisObjekt) {
        this.basisObjekt = basisObjekt;
    }

    public String getHerstellnr() {
        return this.herstellnr;
    }

    public void setHerstellnr(String herstellnr) {
        this.herstellnr = herstellnr;
    }

    public String getHersteller() {
        return this.hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public Date getDatuminbetriebnahme() {
        return this.datuminbetriebnahme;
    }

    public void setDatuminbetriebnahme(Date datuminbetriebnahme) {
        this.datuminbetriebnahme = datuminbetriebnahme;
    }

    public Date getDatumerfassung() {
        return this.datumerfassung;
    }

    public void setDatumerfassung(Date datumerfassung) {
        this.datumerfassung = datumerfassung;
    }

    public Date getDatumaenderung() {
        return this.datumaenderung;
    }

    public void setDatumaenderung(Date datumaenderung) {
        this.datumaenderung = datumaenderung;
    }

    public Date getDatumgenehmigung() {
        return this.datumgenehmigung;
    }

    public void setDatumgenehmigung(Date datumgenehmigung) {
        this.datumgenehmigung = datumgenehmigung;
    }

    public String getAnlagenart() {
        return this.anlagenart;
    }

    public void setAnlagenart(String anlagenart) {
        this.anlagenart = anlagenart;
    }

    public String getBehaelterart() {
        return this.behaelterart;
    }

    public void setBehaelterart(String behaelterart) {
        this.behaelterart = behaelterart;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getFluessigkeit() {
        return this.fluessigkeit;
    }

    public void setFluessigkeit(String fluessigkeit) {
        this.fluessigkeit = fluessigkeit;
    }

    public String getVbfeinstufung() {
        return this.vbfeinstufung;
    }

    public void setVbfeinstufung(String vbfeinstufung) {
        this.vbfeinstufung = vbfeinstufung;
    }

    public Double getMenge() {
        return this.menge;
    }

    public void setMenge(Double menge) {
        this.menge = menge;
    }

    public Integer getWgk() {
        return this.wgk;
    }

    public void setWgk(Integer wgk) {
        this.wgk = wgk;
    }

    public String getGefaehrdungsstufe() {
        return this.gefaehrdungsstufe;
    }

    public void setGefaehrdungsstufe(String gefaehrdungsstufe) {
        this.gefaehrdungsstufe = gefaehrdungsstufe;
    }

    public Integer getBaujahr() {
        return this.baujahr;
    }

    public void setBaujahr(Integer baujahr) {
        this.baujahr = baujahr;
    }

    public Boolean getDoppelwandig() {
        return this.doppelwandig;
    }

    public void setDoppelwandig(Boolean doppelwandig) {
        this.doppelwandig = doppelwandig;
    }

    public Boolean getLeckanzeige() {
        return this.leckanzeige;
    }

    public void setLeckanzeige(Boolean leckanzeige) {
        this.leckanzeige = leckanzeige;
    }

    public Boolean getAuffangraum() {
        return this.auffangraum;
    }

    public void setAuffangraum(Boolean auffangraum) {
        this.auffangraum = auffangraum;
    }

    public Boolean getGrenzwertgeber() {
        return this.grenzwertgeber;
    }

    public void setGrenzwertgeber(Boolean grenzwertgeber) {
        this.grenzwertgeber = grenzwertgeber;
    }

    public Boolean getLeckschutzauskleidung() {
        return this.leckschutzauskleidung;
    }

    public void setLeckschutzauskleidung(Boolean leckschutzauskleidung) {
        this.leckschutzauskleidung = leckschutzauskleidung;
    }

    public Boolean getKellerlagerung() {
        return this.kellerlagerung;
    }

    public void setKellerlagerung(Boolean kellerlagerung) {
        this.kellerlagerung = kellerlagerung;
    }

    public Boolean getInnenbeschichtung() {
        return this.innenbeschichtung;
    }

    public void setInnenbeschichtung(Boolean innenbeschichtung) {
        this.innenbeschichtung = innenbeschichtung;
    }

    public String getBeschreibungA() {
        return this.beschreibungA;
    }

    public void setBeschreibungA(String beschreibungA) {
        this.beschreibungA = beschreibungA;
    }

    public String getBeschreibungS() {
        return this.beschreibungS;
    }

    public void setBeschreibungS(String beschreibungS) {
        this.beschreibungS = beschreibungS;
    }

    public Boolean getOberirdisch() {
        return this.oberirdisch;
    }

    public void setOberirdisch(Boolean oberirdisch) {
        this.oberirdisch = oberirdisch;
    }

    public Boolean getUnterirdisch() {
        return this.unterirdisch;
    }

    public void setUnterirdisch(Boolean unterirdisch) {
        this.unterirdisch = unterirdisch;
    }

    public Boolean getSaugleitung() {
        return this.saugleitung;
    }

    public void setSaugleitung(Boolean saugleitung) {
        this.saugleitung = saugleitung;
    }

    public Boolean getRohrKathodenschutz() {
        return this.rohrKathodenschutz;
    }

    public void setRohrKathodenschutz(Boolean rohrKathodenschutz) {
        this.rohrKathodenschutz = rohrKathodenschutz;
    }

    public Boolean getAusKupfer() {
        return this.ausKupfer;
    }

    public void setAusKupfer(Boolean ausKupfer) {
        this.ausKupfer = ausKupfer;
    }

    public Boolean getAusStahl() {
        return this.ausStahl;
    }

    public void setAusStahl(Boolean ausStahl) {
        this.ausStahl = ausStahl;
    }

    public Boolean getMitSchutzrohr() {
        return this.mitSchutzrohr;
    }

    public void setMitSchutzrohr(Boolean mitSchutzrohr) {
        this.mitSchutzrohr = mitSchutzrohr;
    }

    public String getBeschreibungR() {
        return this.beschreibungR;
    }

    public void setBeschreibungR(String beschreibungR) {
        this.beschreibungR = beschreibungR;
    }

    public Double getPruefturnus() {
        return this.pruefturnus;
    }

    public void setPruefturnus(Double pruefturnus) {
        this.pruefturnus = pruefturnus;
    }

    public Boolean getAngemahntkz() {
        return this.angemahntkz;
    }

    public void setAngemahntkz(Boolean angemahntkz) {
        this.angemahntkz = angemahntkz;
    }

    public Date getMahnfrist() {
        return this.mahnfrist;
    }

    public void setMahnfrist(Date mahnfrist) {
        this.mahnfrist = mahnfrist;
    }

    public Date getWiedervorlage() {
        return this.wiedervorlage;
    }

    public void setWiedervorlage(Date wiedervorlage) {
        this.wiedervorlage = wiedervorlage;
    }

    public Date getStillegungsdatum() {
        return this.stillegungsdatum;
    }

    public void setStillegungsdatum(Date stillegungsdatum) {
        this.stillegungsdatum = stillegungsdatum;
    }

    public String getBemerkungen() {
        return this.bemerkungen;
    }

    public void setBemerkungen(String bemerkungen) {
        this.bemerkungen = bemerkungen;
    }

    public String getAusfuehrung() {
        return this.ausfuehrung;
    }

    public void setAusfuehrung(String ausfuehrung) {
        this.ausfuehrung = ausfuehrung;
    }

    public String getPruefumfang() {
        return this.pruefumfang;
    }

    public void setPruefumfang(String pruefumfang) {
        this.pruefumfang = pruefumfang;
    }

    public String getVerwendung() {
        return this.verwendung;
    }

    public void setVerwendung(String verwendung) {
        this.verwendung = verwendung;
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

    public Boolean getAusHdpe() {
        return this.ausHdpe;
    }

    public void setAusHdpe(Boolean ausHdpe) {
        this.ausHdpe = ausHdpe;
    }

    public Boolean getDruckleitung() {
        return this.druckleitung;
    }

    public void setDruckleitung(Boolean druckleitung) {
        this.druckleitung = druckleitung;
    }

    public Boolean getSchutzSensor() {
        return this.schutzSensor;
    }

    public void setSchutzSensor(Boolean schutzSensor) {
        this.schutzSensor = schutzSensor;
    }

    public Boolean getSchutzFolie() {
        return this.schutzFolie;
    }

    public void setSchutzFolie(Boolean schutzFolie) {
        this.schutzFolie = schutzFolie;
    }

    public Boolean getSchutzAntiheber() {
        return this.schutzAntiheber;
    }

    public void setSchutzAntiheber(Boolean schutzAntiheber) {
        this.schutzAntiheber = schutzAntiheber;
    }

    public String getAktenzeichen() {
        return this.aktenzeichen;
    }

    public void setAktenzeichen(String aktenzeichen) {
        this.aktenzeichen = aktenzeichen;
    }

    public Set<VawsVerwaltungsverf> getVawsVerwaltungsverfs() {
        return this.vawsVerwaltungsverfs;
    }

    public void setVawsVerwaltungsverfs(Set<VawsVerwaltungsverf> vawsVerwaltungsverfs) {
        this.vawsVerwaltungsverfs = vawsVerwaltungsverfs;
    }

    public Set<VawsKontrollen> getVawsKontrollens() {
        return this.vawsKontrollens;
    }

    public void setVawsKontrollens(Set<VawsKontrollen> vawsKontrollens) {
        this.vawsKontrollens = vawsKontrollens;
    }

    public Set<VawsAbscheider> getVawsAbscheiders() {
        return this.vawsAbscheiders;
    }

    public void setVawsAbscheiders(Set<VawsAbscheider> vawsAbscheiders) {
        this.vawsAbscheiders = vawsAbscheiders;
    }

    public Set<VawsAnlagenchrono> getVawsAnlagenchronos() {
        return this.vawsAnlagenchronos;
    }

    public void setVawsAnlagenchronos(Set<VawsAnlagenchrono> vawsAnlagenchronos) {
        this.vawsAnlagenchronos = vawsAnlagenchronos;
    }

    public Set<VawsVerwaltungsgebuehren> getVawsVerwaltungsgebuehrens() {
        return this.vawsVerwaltungsgebuehrens;
    }

    public void setVawsVerwaltungsgebuehrens(Set<VawsVerwaltungsgebuehren> vawsVerwaltungsgebuehrens) {
        this.vawsVerwaltungsgebuehrens = vawsVerwaltungsgebuehrens;
    }

    public Set<VawsAbfuellflaeche> getVawsAbfuellflaeches() {
        return this.vawsAbfuellflaeches;
    }

    public void setVawsAbfuellflaeches(Set<VawsAbfuellflaeche> vawsAbfuellflaeches) {
        this.vawsAbfuellflaeches = vawsAbfuellflaeches;
    }

    public Set<VawsJgs> getVawsJgss() {
        return this.vawsJgss;
    }

    public void setVawsJgss(Set<VawsJgs> vawsJgss) {
        this.vawsJgss = vawsJgss;
    }

    /**
     * To implement custom toString methods, jump to not generated code.<br>
     * Basically we either call on <code>toDebugString</code> for a debug
     * string, call on <code>toGuiString</code> for a gui representation or do
     * something completely different.
     * @return String
     */
    @Override
    public String toString() {
        return DatabaseClassToString.toStringForClass(this);
    }

    /**
     * Get a string representation for debugging
     * @return String
     */
    public String toDebugString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append(getClass().getSimpleName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        buffer.append("basisObjekt").append("='").append(getBasisObjekt()).append("' ");
        buffer.append("herstellnr").append("='").append(getHerstellnr()).append("' ");
        buffer.append("hersteller").append("='").append(getHersteller()).append("' ");
        buffer.append("datuminbetriebnahme").append("='").append(getDatuminbetriebnahme()).append("' ");
        buffer.append("datumerfassung").append("='").append(getDatumerfassung()).append("' ");
        buffer.append("datumaenderung").append("='").append(getDatumaenderung()).append("' ");
        buffer.append("datumgenehmigung").append("='").append(getDatumgenehmigung()).append("' ");
        buffer.append("anlagenart").append("='").append(getAnlagenart()).append("' ");
        buffer.append("behaelterart").append("='").append(getBehaelterart()).append("' ");
        buffer.append("material").append("='").append(getMaterial()).append("' ");
        buffer.append("fluessigkeit").append("='").append(getFluessigkeit()).append("' ");
        buffer.append("vbfeinstufung").append("='").append(getVbfeinstufung()).append("' ");
        buffer.append("menge").append("='").append(getMenge()).append("' ");
        buffer.append("wgk").append("='").append(getWgk()).append("' ");
        buffer.append("gefaehrdungsstufe").append("='").append(getGefaehrdungsstufe()).append("' ");
        buffer.append("baujahr").append("='").append(getBaujahr()).append("' ");
        buffer.append("doppelwandig").append("='").append(getDoppelwandig()).append("' ");
        buffer.append("leckanzeige").append("='").append(getLeckanzeige()).append("' ");
        buffer.append("auffangraum").append("='").append(getAuffangraum()).append("' ");
        buffer.append("grenzwertgeber").append("='").append(getGrenzwertgeber()).append("' ");
        buffer.append("leckschutzauskleidung").append("='").append(getLeckschutzauskleidung()).append("' ");
        buffer.append("kellerlagerung").append("='").append(getKellerlagerung()).append("' ");
        buffer.append("innenbeschichtung").append("='").append(getInnenbeschichtung()).append("' ");
        buffer.append("beschreibungA").append("='").append(getBeschreibungA()).append("' ");
        buffer.append("beschreibungS").append("='").append(getBeschreibungS()).append("' ");
        buffer.append("oberirdisch").append("='").append(getOberirdisch()).append("' ");
        buffer.append("unterirdisch").append("='").append(getUnterirdisch()).append("' ");
        buffer.append("saugleitung").append("='").append(getSaugleitung()).append("' ");
        buffer.append("rohrKathodenschutz").append("='").append(getRohrKathodenschutz()).append("' ");
        buffer.append("ausKupfer").append("='").append(getAusKupfer()).append("' ");
        buffer.append("ausStahl").append("='").append(getAusStahl()).append("' ");
        buffer.append("mitSchutzrohr").append("='").append(getMitSchutzrohr()).append("' ");
        buffer.append("beschreibungR").append("='").append(getBeschreibungR()).append("' ");
        buffer.append("pruefturnus").append("='").append(getPruefturnus()).append("' ");
        buffer.append("angemahntkz").append("='").append(getAngemahntkz()).append("' ");
        buffer.append("mahnfrist").append("='").append(getMahnfrist()).append("' ");
        buffer.append("wiedervorlage").append("='").append(getWiedervorlage()).append("' ");
        buffer.append("stillegungsdatum").append("='").append(getStillegungsdatum()).append("' ");
        buffer.append("bemerkungen").append("='").append(getBemerkungen()).append("' ");
        buffer.append("ausfuehrung").append("='").append(getAusfuehrung()).append("' ");
        buffer.append("pruefumfang").append("='").append(getPruefumfang()).append("' ");
        buffer.append("verwendung").append("='").append(getVerwendung()).append("' ");
        buffer.append("enabled").append("='").append(isEnabled()).append("' ");
        buffer.append("deleted").append("='").append(isDeleted()).append("' ");
        buffer.append("ausHdpe").append("='").append(getAusHdpe()).append("' ");
        buffer.append("druckleitung").append("='").append(getDruckleitung()).append("' ");
        buffer.append("schutzSensor").append("='").append(getSchutzSensor()).append("' ");
        buffer.append("schutzFolie").append("='").append(getSchutzFolie()).append("' ");
        buffer.append("schutzAntiheber").append("='").append(getSchutzAntiheber()).append("' ");
        buffer.append("aktenzeichen").append("='").append(getAktenzeichen()).append("' ");
        buffer.append("vawsVerwaltungsverfs").append("='").append(getVawsVerwaltungsverfs()).append("' ");
        buffer.append("vawsKontrollens").append("='").append(getVawsKontrollens()).append("' ");
        buffer.append("vawsAbscheider").append("='").append(getVawsAbscheiders()).append("' ");
        buffer.append("vawsAnlagenchronos").append("='").append(getVawsAnlagenchronos()).append("' ");
        buffer.append("vawsVerwaltungsgebuehrens").append("='").append(getVawsVerwaltungsgebuehrens()).append("' ");
        buffer.append("vawsAbfuellflaeche").append("='").append(getVawsAbfuellflaeches()).append("' ");
        buffer.append("]");

        return buffer.toString();
    }

    /**
     * @param other
     * @return <code>true</code>, if this and other are equal,
     *         <code>false</code> otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof VawsFachdaten)) return false;
        return (this.getBehaelterid().equals(
            ((VawsFachdaten) other).getBehaelterid()));
    }

    /**
     * Calculate a unique hashCode
     * @return <code>int</code>
     */
    @Override
    public int hashCode() {
        int result = 17;
        int idValue = this.getBehaelterid() == null ?
            0 : this.getBehaelterid().hashCode();
        result = result * 37 + idValue;
        return result;
    }

    /**
     * Merge (save or update) a detached instance
     * @param detachedInstance the instance to merge
     * @return <code>VawsFachdaten</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static VawsFachdaten merge(VawsFachdaten detachedInstance) {
        log.debug("Merging VawsFachdaten instance " + detachedInstance);
        return (VawsFachdaten) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        VawsFachdaten saved = VawsFachdaten.merge(this);
        if (saved == null) {
            return false;
        } else {
            this.copy(saved);
            return true;
        }
    }

    /**
     * Update this VawsFachdaten with its new values.<br>
     * This is meant to be used after merging!
     * @param copy VawsFachdaten
     */
    private void copy(VawsFachdaten copy) {
        this.basisObjekt = copy.getBasisObjekt();
        this.herstellnr = copy.getHerstellnr();
        this.hersteller = copy.getHersteller();
        this.datuminbetriebnahme = copy.getDatuminbetriebnahme();
        this.datumerfassung = copy.getDatumerfassung();
        this.datumaenderung = copy.getDatumaenderung();
        this.datumgenehmigung = copy.getDatumgenehmigung();
        this.anlagenart = copy.getAnlagenart();
        this.behaelterart = copy.getBehaelterart();
        this.material = copy.getMaterial();
        this.fluessigkeit = copy.getFluessigkeit();
        this.vbfeinstufung = copy.getVbfeinstufung();
        this.menge = copy.getMenge();
        this.wgk = copy.getWgk();
        this.gefaehrdungsstufe = copy.getGefaehrdungsstufe();
        this.baujahr = copy.getBaujahr();
        this.doppelwandig = copy.getDoppelwandig();
        this.leckanzeige = copy.getLeckanzeige();
        this.auffangraum = copy.getAuffangraum();
        this.grenzwertgeber = copy.getGrenzwertgeber();
        this.leckschutzauskleidung = copy.getLeckschutzauskleidung();
        this.kellerlagerung = copy.getKellerlagerung();
        this.innenbeschichtung = copy.getInnenbeschichtung();
        this.beschreibungA = copy.getBeschreibungA();
        this.beschreibungS = copy.getBeschreibungS();
        this.oberirdisch = copy.getOberirdisch();
        this.unterirdisch = copy.getUnterirdisch();
        this.saugleitung = copy.getSaugleitung();
        this.rohrKathodenschutz = copy.getRohrKathodenschutz();
        this.ausKupfer = copy.getAusKupfer();
        this.ausStahl = copy.getAusStahl();
        this.mitSchutzrohr = copy.getMitSchutzrohr();
        this.beschreibungR = copy.getBeschreibungR();
        this.pruefturnus = copy.getPruefturnus();
        this.angemahntkz = copy.getAngemahntkz();
        this.mahnfrist = copy.getMahnfrist();
        this.wiedervorlage = copy.getWiedervorlage();
        this.stillegungsdatum = copy.getStillegungsdatum();
        this.bemerkungen = copy.getBemerkungen();
        this.ausfuehrung = copy.getAusfuehrung();
        this.pruefumfang = copy.getPruefumfang();
        this.verwendung = copy.getVerwendung();
        this.enabled = copy.isEnabled();
        this.deleted = copy.isDeleted();
        this.ausHdpe = copy.getAusHdpe();
        this.druckleitung = copy.getDruckleitung();
        this.schutzSensor = copy.getSchutzSensor();
        this.schutzFolie = copy.getSchutzFolie();
        this.schutzAntiheber = copy.getSchutzAntiheber();
        this.aktenzeichen = copy.getAktenzeichen();
        this.vawsVerwaltungsverfs = copy.getVawsVerwaltungsverfs();
        this.vawsKontrollens = copy.getVawsKontrollens();
        this.vawsAbscheiders = copy.getVawsAbscheiders();
        this.vawsAnlagenchronos = copy.getVawsAnlagenchronos();
        this.vawsVerwaltungsgebuehrens = copy.getVawsVerwaltungsgebuehrens();
        this.vawsAbfuellflaeches = copy.getVawsAbfuellflaeches();
    }

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(VawsFachdaten detachedInstance) {
        log.debug("Deleting VawsFachdaten instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return VawsFachdaten.delete(this);
    }

    /**
     * Find an <code>VawsFachdaten</code> instance by its primary key
     * @param id the primary key value
     * @return <code>VawsFachdaten</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static VawsFachdaten findById(java.lang.Integer id) {
        log.debug("Getting VawsFachdaten instance with id: " + id);
        return (VawsFachdaten)
            new DatabaseAccess().get(VawsFachdaten.class, id);
    }

    /**
     * Get a list of all <code>VawsFachdaten</code>
     * @return <code>List&lt;VawsFachdaten&gt;</code>
     *         all <code>VawsFachdaten</code>
     */
    public static List<VawsFachdaten> getAll() {
        return DatabaseQuery.getAll(new VawsFachdaten());
    }

    /* Custom code goes below here! */

}
