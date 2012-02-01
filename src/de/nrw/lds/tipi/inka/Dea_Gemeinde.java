/**
 * Dea_Gemeinde.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.nrw.lds.tipi.inka;

public class Dea_Gemeinde  extends de.nrw.lds.tipi.general.HistoryObject  implements java.io.Serializable {
    private java.lang.Integer gemeinde_ver;

    private java.lang.String gemeindekennzahl;

    private java.lang.String gemeindename;

    private java.lang.Integer gkz_max_hoch_2;

    private java.lang.Integer gkz_max_hoch_3;

    private java.lang.Integer gkz_max_rechts_2;

    private java.lang.Integer gkz_max_rechts_3;

    private java.lang.Integer gkz_min_hoch_2;

    private java.lang.Integer gkz_min_hoch_3;

    private java.lang.Integer gkz_min_rechts_2;

    private java.lang.Integer gkz_min_rechts_3;

    private java.lang.Integer stua_bezirk;

    private java.lang.Integer stua_ver;

    public Dea_Gemeinde() {
    }

    public Dea_Gemeinde(
           java.util.Calendar aenderungs_datum,
           java.util.Calendar erfassungs_datum,
           java.util.Calendar gueltig_bis,
           java.util.Calendar gueltig_von,
           java.lang.Boolean ist_aktuell_jn,
           java.lang.Integer gemeinde_ver,
           java.lang.String gemeindekennzahl,
           java.lang.String gemeindename,
           java.lang.Integer gkz_max_hoch_2,
           java.lang.Integer gkz_max_hoch_3,
           java.lang.Integer gkz_max_rechts_2,
           java.lang.Integer gkz_max_rechts_3,
           java.lang.Integer gkz_min_hoch_2,
           java.lang.Integer gkz_min_hoch_3,
           java.lang.Integer gkz_min_rechts_2,
           java.lang.Integer gkz_min_rechts_3,
           java.lang.Integer stua_bezirk,
           java.lang.Integer stua_ver) {
        super(
            aenderungs_datum,
            erfassungs_datum,
            gueltig_bis,
            gueltig_von,
            ist_aktuell_jn);
        this.gemeinde_ver = gemeinde_ver;
        this.gemeindekennzahl = gemeindekennzahl;
        this.gemeindename = gemeindename;
        this.gkz_max_hoch_2 = gkz_max_hoch_2;
        this.gkz_max_hoch_3 = gkz_max_hoch_3;
        this.gkz_max_rechts_2 = gkz_max_rechts_2;
        this.gkz_max_rechts_3 = gkz_max_rechts_3;
        this.gkz_min_hoch_2 = gkz_min_hoch_2;
        this.gkz_min_hoch_3 = gkz_min_hoch_3;
        this.gkz_min_rechts_2 = gkz_min_rechts_2;
        this.gkz_min_rechts_3 = gkz_min_rechts_3;
        this.stua_bezirk = stua_bezirk;
        this.stua_ver = stua_ver;
    }


    /**
     * Gets the gemeinde_ver value for this Dea_Gemeinde.
     * 
     * @return gemeinde_ver
     */
    public java.lang.Integer getGemeinde_ver() {
        return gemeinde_ver;
    }


    /**
     * Sets the gemeinde_ver value for this Dea_Gemeinde.
     * 
     * @param gemeinde_ver
     */
    public void setGemeinde_ver(java.lang.Integer gemeinde_ver) {
        this.gemeinde_ver = gemeinde_ver;
    }


    /**
     * Gets the gemeindekennzahl value for this Dea_Gemeinde.
     * 
     * @return gemeindekennzahl
     */
    public java.lang.String getGemeindekennzahl() {
        return gemeindekennzahl;
    }


    /**
     * Sets the gemeindekennzahl value for this Dea_Gemeinde.
     * 
     * @param gemeindekennzahl
     */
    public void setGemeindekennzahl(java.lang.String gemeindekennzahl) {
        this.gemeindekennzahl = gemeindekennzahl;
    }


    /**
     * Gets the gemeindename value for this Dea_Gemeinde.
     * 
     * @return gemeindename
     */
    public java.lang.String getGemeindename() {
        return gemeindename;
    }


    /**
     * Sets the gemeindename value for this Dea_Gemeinde.
     * 
     * @param gemeindename
     */
    public void setGemeindename(java.lang.String gemeindename) {
        this.gemeindename = gemeindename;
    }


    /**
     * Gets the gkz_max_hoch_2 value for this Dea_Gemeinde.
     * 
     * @return gkz_max_hoch_2
     */
    public java.lang.Integer getGkz_max_hoch_2() {
        return gkz_max_hoch_2;
    }


    /**
     * Sets the gkz_max_hoch_2 value for this Dea_Gemeinde.
     * 
     * @param gkz_max_hoch_2
     */
    public void setGkz_max_hoch_2(java.lang.Integer gkz_max_hoch_2) {
        this.gkz_max_hoch_2 = gkz_max_hoch_2;
    }


    /**
     * Gets the gkz_max_hoch_3 value for this Dea_Gemeinde.
     * 
     * @return gkz_max_hoch_3
     */
    public java.lang.Integer getGkz_max_hoch_3() {
        return gkz_max_hoch_3;
    }


    /**
     * Sets the gkz_max_hoch_3 value for this Dea_Gemeinde.
     * 
     * @param gkz_max_hoch_3
     */
    public void setGkz_max_hoch_3(java.lang.Integer gkz_max_hoch_3) {
        this.gkz_max_hoch_3 = gkz_max_hoch_3;
    }


    /**
     * Gets the gkz_max_rechts_2 value for this Dea_Gemeinde.
     * 
     * @return gkz_max_rechts_2
     */
    public java.lang.Integer getGkz_max_rechts_2() {
        return gkz_max_rechts_2;
    }


    /**
     * Sets the gkz_max_rechts_2 value for this Dea_Gemeinde.
     * 
     * @param gkz_max_rechts_2
     */
    public void setGkz_max_rechts_2(java.lang.Integer gkz_max_rechts_2) {
        this.gkz_max_rechts_2 = gkz_max_rechts_2;
    }


    /**
     * Gets the gkz_max_rechts_3 value for this Dea_Gemeinde.
     * 
     * @return gkz_max_rechts_3
     */
    public java.lang.Integer getGkz_max_rechts_3() {
        return gkz_max_rechts_3;
    }


    /**
     * Sets the gkz_max_rechts_3 value for this Dea_Gemeinde.
     * 
     * @param gkz_max_rechts_3
     */
    public void setGkz_max_rechts_3(java.lang.Integer gkz_max_rechts_3) {
        this.gkz_max_rechts_3 = gkz_max_rechts_3;
    }


    /**
     * Gets the gkz_min_hoch_2 value for this Dea_Gemeinde.
     * 
     * @return gkz_min_hoch_2
     */
    public java.lang.Integer getGkz_min_hoch_2() {
        return gkz_min_hoch_2;
    }


    /**
     * Sets the gkz_min_hoch_2 value for this Dea_Gemeinde.
     * 
     * @param gkz_min_hoch_2
     */
    public void setGkz_min_hoch_2(java.lang.Integer gkz_min_hoch_2) {
        this.gkz_min_hoch_2 = gkz_min_hoch_2;
    }


    /**
     * Gets the gkz_min_hoch_3 value for this Dea_Gemeinde.
     * 
     * @return gkz_min_hoch_3
     */
    public java.lang.Integer getGkz_min_hoch_3() {
        return gkz_min_hoch_3;
    }


    /**
     * Sets the gkz_min_hoch_3 value for this Dea_Gemeinde.
     * 
     * @param gkz_min_hoch_3
     */
    public void setGkz_min_hoch_3(java.lang.Integer gkz_min_hoch_3) {
        this.gkz_min_hoch_3 = gkz_min_hoch_3;
    }


    /**
     * Gets the gkz_min_rechts_2 value for this Dea_Gemeinde.
     * 
     * @return gkz_min_rechts_2
     */
    public java.lang.Integer getGkz_min_rechts_2() {
        return gkz_min_rechts_2;
    }


    /**
     * Sets the gkz_min_rechts_2 value for this Dea_Gemeinde.
     * 
     * @param gkz_min_rechts_2
     */
    public void setGkz_min_rechts_2(java.lang.Integer gkz_min_rechts_2) {
        this.gkz_min_rechts_2 = gkz_min_rechts_2;
    }


    /**
     * Gets the gkz_min_rechts_3 value for this Dea_Gemeinde.
     * 
     * @return gkz_min_rechts_3
     */
    public java.lang.Integer getGkz_min_rechts_3() {
        return gkz_min_rechts_3;
    }


    /**
     * Sets the gkz_min_rechts_3 value for this Dea_Gemeinde.
     * 
     * @param gkz_min_rechts_3
     */
    public void setGkz_min_rechts_3(java.lang.Integer gkz_min_rechts_3) {
        this.gkz_min_rechts_3 = gkz_min_rechts_3;
    }


    /**
     * Gets the stua_bezirk value for this Dea_Gemeinde.
     * 
     * @return stua_bezirk
     */
    public java.lang.Integer getStua_bezirk() {
        return stua_bezirk;
    }


    /**
     * Sets the stua_bezirk value for this Dea_Gemeinde.
     * 
     * @param stua_bezirk
     */
    public void setStua_bezirk(java.lang.Integer stua_bezirk) {
        this.stua_bezirk = stua_bezirk;
    }


    /**
     * Gets the stua_ver value for this Dea_Gemeinde.
     * 
     * @return stua_ver
     */
    public java.lang.Integer getStua_ver() {
        return stua_ver;
    }


    /**
     * Sets the stua_ver value for this Dea_Gemeinde.
     * 
     * @param stua_ver
     */
    public void setStua_ver(java.lang.Integer stua_ver) {
        this.stua_ver = stua_ver;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Dea_Gemeinde)) return false;
        Dea_Gemeinde other = (Dea_Gemeinde) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.gemeinde_ver==null && other.getGemeinde_ver()==null) || 
             (this.gemeinde_ver!=null &&
              this.gemeinde_ver.equals(other.getGemeinde_ver()))) &&
            ((this.gemeindekennzahl==null && other.getGemeindekennzahl()==null) || 
             (this.gemeindekennzahl!=null &&
              this.gemeindekennzahl.equals(other.getGemeindekennzahl()))) &&
            ((this.gemeindename==null && other.getGemeindename()==null) || 
             (this.gemeindename!=null &&
              this.gemeindename.equals(other.getGemeindename()))) &&
            ((this.gkz_max_hoch_2==null && other.getGkz_max_hoch_2()==null) || 
             (this.gkz_max_hoch_2!=null &&
              this.gkz_max_hoch_2.equals(other.getGkz_max_hoch_2()))) &&
            ((this.gkz_max_hoch_3==null && other.getGkz_max_hoch_3()==null) || 
             (this.gkz_max_hoch_3!=null &&
              this.gkz_max_hoch_3.equals(other.getGkz_max_hoch_3()))) &&
            ((this.gkz_max_rechts_2==null && other.getGkz_max_rechts_2()==null) || 
             (this.gkz_max_rechts_2!=null &&
              this.gkz_max_rechts_2.equals(other.getGkz_max_rechts_2()))) &&
            ((this.gkz_max_rechts_3==null && other.getGkz_max_rechts_3()==null) || 
             (this.gkz_max_rechts_3!=null &&
              this.gkz_max_rechts_3.equals(other.getGkz_max_rechts_3()))) &&
            ((this.gkz_min_hoch_2==null && other.getGkz_min_hoch_2()==null) || 
             (this.gkz_min_hoch_2!=null &&
              this.gkz_min_hoch_2.equals(other.getGkz_min_hoch_2()))) &&
            ((this.gkz_min_hoch_3==null && other.getGkz_min_hoch_3()==null) || 
             (this.gkz_min_hoch_3!=null &&
              this.gkz_min_hoch_3.equals(other.getGkz_min_hoch_3()))) &&
            ((this.gkz_min_rechts_2==null && other.getGkz_min_rechts_2()==null) || 
             (this.gkz_min_rechts_2!=null &&
              this.gkz_min_rechts_2.equals(other.getGkz_min_rechts_2()))) &&
            ((this.gkz_min_rechts_3==null && other.getGkz_min_rechts_3()==null) || 
             (this.gkz_min_rechts_3!=null &&
              this.gkz_min_rechts_3.equals(other.getGkz_min_rechts_3()))) &&
            ((this.stua_bezirk==null && other.getStua_bezirk()==null) || 
             (this.stua_bezirk!=null &&
              this.stua_bezirk.equals(other.getStua_bezirk()))) &&
            ((this.stua_ver==null && other.getStua_ver()==null) || 
             (this.stua_ver!=null &&
              this.stua_ver.equals(other.getStua_ver())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getGemeinde_ver() != null) {
            _hashCode += getGemeinde_ver().hashCode();
        }
        if (getGemeindekennzahl() != null) {
            _hashCode += getGemeindekennzahl().hashCode();
        }
        if (getGemeindename() != null) {
            _hashCode += getGemeindename().hashCode();
        }
        if (getGkz_max_hoch_2() != null) {
            _hashCode += getGkz_max_hoch_2().hashCode();
        }
        if (getGkz_max_hoch_3() != null) {
            _hashCode += getGkz_max_hoch_3().hashCode();
        }
        if (getGkz_max_rechts_2() != null) {
            _hashCode += getGkz_max_rechts_2().hashCode();
        }
        if (getGkz_max_rechts_3() != null) {
            _hashCode += getGkz_max_rechts_3().hashCode();
        }
        if (getGkz_min_hoch_2() != null) {
            _hashCode += getGkz_min_hoch_2().hashCode();
        }
        if (getGkz_min_hoch_3() != null) {
            _hashCode += getGkz_min_hoch_3().hashCode();
        }
        if (getGkz_min_rechts_2() != null) {
            _hashCode += getGkz_min_rechts_2().hashCode();
        }
        if (getGkz_min_rechts_3() != null) {
            _hashCode += getGkz_min_rechts_3().hashCode();
        }
        if (getStua_bezirk() != null) {
            _hashCode += getStua_bezirk().hashCode();
        }
        if (getStua_ver() != null) {
            _hashCode += getStua_ver().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Dea_Gemeinde.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://inka.tipi.lds.nrw.de", "Dea_Gemeinde"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gemeinde_ver");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gemeinde_ver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gemeindekennzahl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gemeindekennzahl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gemeindename");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gemeindename"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gkz_max_hoch_2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gkz_max_hoch_2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gkz_max_hoch_3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gkz_max_hoch_3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gkz_max_rechts_2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gkz_max_rechts_2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gkz_max_rechts_3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gkz_max_rechts_3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gkz_min_hoch_2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gkz_min_hoch_2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gkz_min_hoch_3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gkz_min_hoch_3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gkz_min_rechts_2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gkz_min_rechts_2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gkz_min_rechts_3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gkz_min_rechts_3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stua_bezirk");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stua_bezirk"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stua_ver");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stua_ver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}