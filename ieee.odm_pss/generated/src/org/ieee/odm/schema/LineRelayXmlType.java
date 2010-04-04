//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.04 at 10:04:25 AM PDT 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LineRelayXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LineRelayXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lineRelayType">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="TIOCR1"/>
 *               &lt;enumeration value="distanceRelay"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="lineRelayModel" type="{http://www.ieee.org/odm/Schema}LineRelayModelListXmlType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineRelayXmlType", propOrder = {
    "lineRelayType",
    "lineRelayModel"
})
public class LineRelayXmlType {

    @XmlElement(required = true)
    protected String lineRelayType;
    @XmlElement(required = true)
    protected LineRelayModelListXmlType lineRelayModel;

    /**
     * Gets the value of the lineRelayType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineRelayType() {
        return lineRelayType;
    }

    /**
     * Sets the value of the lineRelayType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineRelayType(String value) {
        this.lineRelayType = value;
    }

    /**
     * Gets the value of the lineRelayModel property.
     * 
     * @return
     *     possible object is
     *     {@link LineRelayModelListXmlType }
     *     
     */
    public LineRelayModelListXmlType getLineRelayModel() {
        return lineRelayModel;
    }

    /**
     * Sets the value of the lineRelayModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineRelayModelListXmlType }
     *     
     */
    public void setLineRelayModel(LineRelayModelListXmlType value) {
        this.lineRelayModel = value;
    }

}
