/**
 * ReqInka_Betrieb.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.nrw.lds.tipi.inka.request;

public class ReqInka_Betrieb  extends de.nrw.lds.tipi.inka.general.ReqStandard  implements java.io.Serializable {
    private de.nrw.lds.tipi.inka.Inka_Betrieb objInka_Betrieb;

    public ReqInka_Betrieb() {
    }

    public ReqInka_Betrieb(
           java.util.Calendar clientTimestamp,
           java.lang.String clientVendor,
           java.lang.String clientVersion,
           java.lang.String kennung,
           java.lang.Integer numberOfObjects,
           java.lang.String password,
           java.lang.Integer startsFromObject,
           de.nrw.lds.tipi.inka.Inka_Betrieb objInka_Betrieb) {
        super(
            clientTimestamp,
            clientVendor,
            clientVersion,
            kennung,
            numberOfObjects,
            password,
            startsFromObject);
        this.objInka_Betrieb = objInka_Betrieb;
    }


    /**
     * Gets the objInka_Betrieb value for this ReqInka_Betrieb.
     * 
     * @return objInka_Betrieb
     */
    public de.nrw.lds.tipi.inka.Inka_Betrieb getObjInka_Betrieb() {
        return objInka_Betrieb;
    }


    /**
     * Sets the objInka_Betrieb value for this ReqInka_Betrieb.
     * 
     * @param objInka_Betrieb
     */
    public void setObjInka_Betrieb(de.nrw.lds.tipi.inka.Inka_Betrieb objInka_Betrieb) {
        this.objInka_Betrieb = objInka_Betrieb;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReqInka_Betrieb)) return false;
        ReqInka_Betrieb other = (ReqInka_Betrieb) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.objInka_Betrieb==null && other.getObjInka_Betrieb()==null) || 
             (this.objInka_Betrieb!=null &&
              this.objInka_Betrieb.equals(other.getObjInka_Betrieb())));
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
        if (getObjInka_Betrieb() != null) {
            _hashCode += getObjInka_Betrieb().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReqInka_Betrieb.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://request.inka.tipi.lds.nrw.de", "ReqInka_Betrieb"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objInka_Betrieb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objInka_Betrieb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://inka.tipi.lds.nrw.de", "Inka_Betrieb"));
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