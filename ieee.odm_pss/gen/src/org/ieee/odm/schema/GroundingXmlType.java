//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.26 at 02:44:35 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GroundingXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroundingXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="groundZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="connection" use="required" type="{http://www.ieee.org/odm/Schema/2008}GroundingEnumType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroundingXmlType", propOrder = {
    "groundZ"
})
public class GroundingXmlType {

    protected ZXmlType groundZ;
    @XmlAttribute(required = true)
    protected GroundingEnumType connection;

    /**
     * Gets the value of the groundZ property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getGroundZ() {
        return groundZ;
    }

    /**
     * Sets the value of the groundZ property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setGroundZ(ZXmlType value) {
        this.groundZ = value;
    }

    /**
     * Gets the value of the connection property.
     * 
     * @return
     *     possible object is
     *     {@link GroundingEnumType }
     *     
     */
    public GroundingEnumType getConnection() {
        return connection;
    }

    /**
     * Sets the value of the connection property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroundingEnumType }
     *     
     */
    public void setConnection(GroundingEnumType value) {
        this.connection = value;
    }

}
