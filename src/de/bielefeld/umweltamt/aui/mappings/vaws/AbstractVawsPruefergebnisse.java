/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Tue Sep 06 14:47:49 CEST 2005 by MyEclipse Hibernate Tool.
 */
package de.bielefeld.umweltamt.aui.mappings.vaws;

import java.io.Serializable;

/**
 * A class that represents a row in the VAWS_PRUEFERGEBNISSE table.
 * You can customize the behavior of this class by editing the class, {@link VawsPruefergebnisse()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractVawsPruefergebnisse
    implements Serializable
{

    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.Integer id;

    /** The value of the simple pruefergebnis property. */
    private java.lang.String pruefergebnis;

    /**
     * Simple constructor of AbstractVawsPruefergebnisse instances.
     */
    public AbstractVawsPruefergebnisse()
    {
    }

    /**
     * Return the simple primary key value that identifies this object.
     * @return java.lang.Integer
     */
    public java.lang.Integer getId()
    {
        return id;
    }

    /**
     * Set the simple primary key value that identifies this object.
     * @param kontrollid
     */
    public void setId(java.lang.Integer id)
    {
        this.hashValue = 0;
        this.id = id;
    }

    /**
     * Return the value of the PRUEFERGEBNIS column.
     * @return java.lang.String
     */
    public java.lang.String getPruefergebnis()
    {
        return this.pruefergebnis;
    }

    /**
     * Set the value of the PRUEFERGEBNIS column.
     * @param pruefergebnis
     */
    public void setPruefergebnis(java.lang.String pruefergebnis)
    {
        this.pruefergebnis = pruefergebnis;
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
        if (! (rhs instanceof VawsKontrollen))
            return false;
        VawsKontrollen that = (VawsKontrollen) rhs;
        if (this.getId() != null && that.getId() != null)
        {
            if (! this.getId().equals(that.getId()))
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
            int kontrollidValue = this.getId() == null ? 0 : this.getId().hashCode();
            result = result * 37 + kontrollidValue;
            this.hashValue = result;
        }
        return this.hashValue;
    }
}
