//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.21 at 03:20:14 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for InverterLossParamXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InverterLossParamXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="vdc" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="a" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="b" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="c" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InverterLossParamXmlType")
public class InverterLossParamXmlType {

    @XmlAttribute
    protected Double vdc;
    @XmlAttribute
    protected Double a;
    @XmlAttribute
    protected Double b;
    @XmlAttribute
    protected Double c;

    /**
     * Gets the value of the vdc property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVdc() {
        return vdc;
    }

    /**
     * Sets the value of the vdc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVdc(Double value) {
        this.vdc = value;
    }

    /**
     * Gets the value of the a property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getA() {
        return a;
    }

    /**
     * Sets the value of the a property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setA(Double value) {
        this.a = value;
    }

    /**
     * Gets the value of the b property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getB() {
        return b;
    }

    /**
     * Sets the value of the b property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setB(Double value) {
        this.b = value;
    }

    /**
     * Gets the value of the c property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getC() {
        return c;
    }

    /**
     * Sets the value of the c property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setC(Double value) {
        this.c = value;
    }

}