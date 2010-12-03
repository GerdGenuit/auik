package de.bielefeld.umweltamt.aui.mappings.indeinl;

// Generated 01.09.2008 14:20:13 by Hibernate Tools 3.2.0.beta8

import java.util.Date;

import de.bielefeld.umweltamt.aui.mappings.basis.BasisObjekt;

/**
 * IndeinlGenehmigung generated by hbm2java
 */
public class AbstractIndeinlGenehmigung implements java.io.Serializable {

    // Fields

    private int objektid;

    private BasisObjekt basisObjekt;

    private java.lang.String bemerkungen;

    private Date erstellungsDatum;

    private Date aenderungsDatum;

    private Date antragDatum;

    private Boolean befristet;

    private Date befristetBis;

    private Integer anhang;

    private Integer genMenge;

    private Boolean gen58;

    private Boolean gen59;

    private Boolean selbstueberw;

    private Boolean esatzung;

    // Constructors

    /** default constructor */
    public AbstractIndeinlGenehmigung() {
    }

    /** minimal constructor */
    public AbstractIndeinlGenehmigung(int objektid) {
        this.objektid = objektid;
    }

    /** full constructor */
    public AbstractIndeinlGenehmigung(int objektid, Date erstellungsDatum,
            Date aenderungsDatum) {
        this.objektid = objektid;
        this.erstellungsDatum = erstellungsDatum;
        this.aenderungsDatum = aenderungsDatum;
    }

    // Property accessors
    public int getObjektid() {
        return this.objektid;
    }

    public void setObjektid(int objektid) {
        this.objektid = objektid;
    }

    /**
     * Return the value of the OBJEKTID column.
     * @return BasisObjekt
     */
    public BasisObjekt getBasisObjekt()
    {
        return this.basisObjekt;
    }

    /**
     * Set the value of the OBJEKTID column.
     * @param basisObjekt
     */
    public void setBasisObjekt(BasisObjekt basisObjekt)
    {
        this.basisObjekt = basisObjekt;
    }

    /**
     * Return the value of the BEMERKUNGEN column.
     * @return java.lang.String
     */
    public java.lang.String getBemerkungen()
    {
        return this.bemerkungen;
    }

    /**
     * Set the value of the BEMERKUNGEN column.
     * @param bemerkungen
     */
    public void setBemerkungen(java.lang.String bemerkungen)
    {
        this.bemerkungen = bemerkungen;
    }

    public Date getErstellungsDatum() {
        return this.erstellungsDatum;
    }

    public void setErstellungsDatum(Date erstellungsDatum) {
        this.erstellungsDatum = erstellungsDatum;
    }

    public Date getAenderungsDatum() {
        return this.aenderungsDatum;
    }

    public void setAenderungsDatum(Date aenderungsDatum) {
        this.aenderungsDatum = aenderungsDatum;
    }

    public Date getAntragDatum() {
        return this.antragDatum;
    }

    public void setAntragDatum(Date antragDatum) {
        this.antragDatum = antragDatum;
    }

    public Boolean getBefristet() {
        return this.befristet;
    }

    public void setBefristet(Boolean befristet) {
        this.befristet = befristet;
    }

    public Date getBefristetBis() {
        return this.befristetBis;
    }

    public void setBefristetBis(Date befristetBis) {
        this.befristetBis = befristetBis;
    }

    public Integer getAnhang() {
        return this.anhang;
    }

    public void setAnhang(Integer anhang) {
        this.anhang = anhang;
    }

    public Integer getGenMenge() {
        return this.genMenge;
    }

    public void setGenMenge(Integer genMenge) {
        this.genMenge = genMenge;
    }

    public Boolean getGen58() {
        return this.gen58;
    }

    public void setGen58(Boolean gen58) {
        this.gen58 = gen58;
    }

    public Boolean getGen59() {
        return this.gen59;
    }

    public void setGen59(Boolean gen59) {
        this.gen59 = gen59;
    }

    public Boolean getSelbstueberw() {
        return this.selbstueberw;
    }

    public void setSelbstueberw(Boolean selbstueberw) {
        this.selbstueberw = selbstueberw;
    }

    public Boolean getEsatzung() {
        return this.esatzung;
    }

    public void setEsatzung(Boolean esatzung) {
        this.esatzung = esatzung;
    }

}
