/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Thu Mar 31 16:02:08 CEST 2005 by MyEclipse Hibernate Tool.
 */
package de.bielefeld.umweltamt.aui.mappings.basis;

import java.io.Serializable;

/**
 * A class that represents a row in the BASIS_OBJEKT table.
 * You can customize the behavior of this class by editing the class, {@link BasisObjekt}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractBasisObjekt
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.Integer objektid;

    /** The value of the basisBetreiber association. */
    private BasisBetreiber basisBetreiber;

    /** The value of the basisObjektarten association. */
    private BasisObjektarten basisObjektarten;

    /** The value of the basisStandort association. */
    private BasisStandort basisStandort;

    /** The value of the simple uschistdid property. */
    private java.lang.Integer uschistdid;

    /** The value of the simple beschreibung property. */
    private java.lang.String beschreibung;

    /** The value of the simple beschreibung property. */
    private java.lang.String sachbearbeiter;

    /** The value of the simple revidatum property. */
    private java.util.Date wiedervorlage;

    /** The value of the simple revidatum property. */
    private java.util.Date erfassungsdatum;

    /** The value of the simple revidatum property. */
    private java.util.Date gueltig_von;

    /** The value of the simple revidatum property. */
    private java.util.Date aenderungsdatum;

    /** The value of the simple revidatum property. */
    private java.util.Date gueltig_bis;

    /** The value of the simple inaktiv property. */
    private java.lang.Boolean inaktiv;

    /**
     * Simple constructor of AbstractBasisObjekt instances.
     */
    public AbstractBasisObjekt()
    {
    }

    /**
     * Constructor of AbstractBasisObjekt instances given a simple primary key.
     * @param objektid
     */
    public AbstractBasisObjekt(java.lang.Integer objektid)
    {
        this.setObjektid(objektid);
    }

    /**
     * Return the simple primary key value that identifies this object.
     * @return java.lang.Integer
     */
    public java.lang.Integer getObjektid()
    {
        return objektid;
    }

    /**
     * Set the simple primary key value that identifies this object.
     * @param objektid
     */
    public void setObjektid(java.lang.Integer objektid)
    {
        this.hashValue = 0;
        this.objektid = objektid;
    }

    /**
     * Return the value of the STANDORTID column.
     * @return BasisStandort
     */
    public BasisStandort getBasisStandort()
    {
        return this.basisStandort;
    }

    /**
     * Set the value of the STANDORTID column.
     * @param basisStandort
     */
    public void setBasisStandort(BasisStandort basisStandort)
    {
        this.basisStandort = basisStandort;
    }

    /**
     * Return the value of the BETREIBERID column.
     * @return BasisBetreiber
     */
    public BasisBetreiber getBasisBetreiber()
    {
        return this.basisBetreiber;
    }

    /**
     * Set the value of the BETREIBERID column.
     * @param basisBetreiber
     */
    public void setBasisBetreiber(BasisBetreiber basisBetreiber)
    {
        this.basisBetreiber = basisBetreiber;
    }

    /**
     * Return the value of the OBJEKTARTID column.
     * @return BasisObjektarten
     */
    public BasisObjektarten getBasisObjektarten()
    {
        return this.basisObjektarten;
    }

    /**
     * Set the value of the OBJEKTARTID column.
     * @param basisObjektarten
     */
    public void setBasisObjektarten(BasisObjektarten basisObjektarten)
    {
        this.basisObjektarten = basisObjektarten;
    }

    /**
     * Return the value of the USCHISTDID column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getUschistdid()
    {
        return this.uschistdid;
    }

    /**
     * Set the value of the USCHISTDID column.
     * @param uschistdid
     */
    public void setUschistdid(java.lang.Integer uschistdid)
    {
        this.uschistdid = uschistdid;
    }
    /**
     * Return the value of the BESCHREIBUNG column.
     * @return java.lang.String
     */
    public java.lang.String getSachbearbeiter()
    {
        return this.sachbearbeiter;
    }

    /**
     * Set the value of the BESCHREIBUNG column.
     * @param beschreibung
     */
    public void setSachbearbeiter(java.lang.String sachbearbeiter)
    {
        this.sachbearbeiter = sachbearbeiter;
    }
    /**
     * Return the value of the BESCHREIBUNG column.
     * @return java.lang.String
     */
    public java.lang.String getBeschreibung()
    {
        return this.beschreibung;
    }

    /**
     * Set the value of the BESCHREIBUNG column.
     * @param beschreibung
     */
    public void setBeschreibung(java.lang.String beschreibung)
    {
        this.beschreibung = beschreibung;
    }

    /**
     * Return the value of the wiedervorlage column.
     * @return java.util.Date
     */
    public java.util.Date getWiedervorlage()
    {
        return this.wiedervorlage;
    }

    /**
     * Set the value of the wiedervorlage column.
     * @param revidatum
     */
    public void setWiedervorlage(java.util.Date wiedervorlage)
    {
        this.wiedervorlage = wiedervorlage;
    }

    /**
     * Return the value of the erfassungsdatum column.
     * @return java.util.Date
     */
    public java.util.Date getErfassungsdatum()
    {
        return this.erfassungsdatum;
    }

    /**
     * Set the value of the erfassungsdatum column.
     * @param revidatum
     */
    public void setErfassungsdatum(java.util.Date erfassungsdatum)
    {
        this.erfassungsdatum = erfassungsdatum;
    }

    /**
     * Return the value of the gueltig_von column.
     * @return java.util.Date
     */
    public java.util.Date getGueltigVon()
    {
        return this.gueltig_von;
    }

    /**
     * Set the value of the gueltig_von column.
     * @param revidatum
     */
    public void setGueltigVon(java.util.Date gueltig_von)
    {
        this.gueltig_von = gueltig_von;
    }

    /**
     * Return the value of the aenderungsdatum column.
     * @return java.util.Date
     */
    public java.util.Date getAenderungsdatum()
    {
        return this.aenderungsdatum;
    }

    /**
     * Set the value of the aenderungsdatum column.
     * @param revidatum
     */
    public void setAenderungsdatum(java.util.Date aenderungsdatum)
    {
        this.aenderungsdatum = aenderungsdatum;
    }

    /**
     * Return the value of the aenderungsdatum column.
     * @return java.util.Date
     */
    public java.lang.Boolean getInaktiv()
    {
        return this.inaktiv;
    }

    /**
     * Set the value of the aenderungsdatum column.
     * @param revidatum
     */
    public void setInaktiv(java.lang.Boolean inaktiv)
    {
        this.inaktiv = inaktiv;
    }

    /**
     * Return the value of the gueltig_bis column.
     * @return java.util.Date
     */
    public java.util.Date getGueltigBis()
    {
        return this.gueltig_bis;
    }

    /**
     * Set the value of the gueltig_bis column.
     * @param revidatum
     */
    public void setGueltigBis(java.util.Date gueltig_bis)
    {
        this.gueltig_bis = gueltig_bis;
    }
    /**
     * Implementation of the equals comparison on the basis of equality of the primary key values.
     * @param rhs
     * @return boolean
     */
    public boolean equals(Object rhs)
    {
        if (rhs == null)
            return false;
        if (! (rhs instanceof BasisObjekt))
            return false;
        BasisObjekt that = (BasisObjekt) rhs;
        if (this.getObjektid() != null && that.getObjektid() != null)
        {
            if (! this.getObjektid().equals(that.getObjektid()))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Implementation of the hashCode method conforming to the Bloch pattern with
     * the exception of array properties (these are very unlikely primary key types).
     * @return int
     */
    public int hashCode()
    {
        if (this.hashValue == 0)
        {
            int result = 17;
            int objektidValue = this.getObjektid() == null ? 0 : this.getObjektid().hashCode();
            result = result * 37 + objektidValue;
            this.hashValue = result;
        }
        return this.hashValue;
    }
}
