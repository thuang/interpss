//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.29 at 06:10:04 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Eq1Ed1MachineXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Eq1Ed1MachineXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}Eq1MachineXmlType">
 *       &lt;sequence>
 *         &lt;element name="xq1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Tq01" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Eq1Ed1MachineXmlType", propOrder = {
    "xq1",
    "tq01"
})
@XmlSeeAlso({
    Eq11Ed11MachineXmlType.class
})
public class Eq1Ed1MachineXmlType
    extends Eq1MachineXmlType
{

    protected double xq1;
    @XmlElement(name = "Tq01", required = true)
    protected TimePeriodXmlType tq01;

    /**
     * Gets the value of the xq1 property.
     * 
     */
    public double getXq1() {
        return xq1;
    }

    /**
     * Sets the value of the xq1 property.
     * 
     */
    public void setXq1(double value) {
        this.xq1 = value;
    }

    /**
     * Gets the value of the tq01 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTq01() {
        return tq01;
    }

    /**
     * Sets the value of the tq01 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTq01(TimePeriodXmlType value) {
        this.tq01 = value;
    }

}
