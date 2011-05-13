//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.13 at 10:08:41 ���� CST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for XFormerDistBranchXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XFormerDistBranchXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}DistBranchXmlType">
 *       &lt;sequence>
 *         &lt;element name="rating" type="{http://www.ieee.org/odm/Schema/2008}ApparentPowerXmlType"/>
 *         &lt;element name="primaryRatedVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType"/>
 *         &lt;element name="secondaryRatedVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType"/>
 *         &lt;element name="z1" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType"/>
 *         &lt;element name="z0" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *         &lt;element name="primaryTurnRatio" type="{http://www.ieee.org/odm/Schema/2008}TurnRatioXmlType"/>
 *         &lt;element name="secondaryTurnRatio" type="{http://www.ieee.org/odm/Schema/2008}TurnRatioXmlType"/>
 *         &lt;element name="primaryConnection" type="{http://www.ieee.org/odm/Schema/2008}XformerConnectionXmlType" minOccurs="0"/>
 *         &lt;element name="secondaryConnection" type="{http://www.ieee.org/odm/Schema/2008}XformerConnectionXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XFormerDistBranchXmlType", propOrder = {
    "rating",
    "primaryRatedVoltage",
    "secondaryRatedVoltage",
    "z1",
    "z0",
    "primaryTurnRatio",
    "secondaryTurnRatio",
    "primaryConnection",
    "secondaryConnection"
})
public class XFormerDistBranchXmlType
    extends DistBranchXmlType
{

    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected ApparentPowerXmlType rating;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected VoltageXmlType primaryRatedVoltage;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected VoltageXmlType secondaryRatedVoltage;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected ZXmlType z1;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected ZXmlType z0;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TurnRatioXmlType primaryTurnRatio;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TurnRatioXmlType secondaryTurnRatio;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected XformerConnectionXmlType primaryConnection;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected XformerConnectionXmlType secondaryConnection;

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public ApparentPowerXmlType getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public void setRating(ApparentPowerXmlType value) {
        this.rating = value;
    }

    /**
     * Gets the value of the primaryRatedVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getPrimaryRatedVoltage() {
        return primaryRatedVoltage;
    }

    /**
     * Sets the value of the primaryRatedVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setPrimaryRatedVoltage(VoltageXmlType value) {
        this.primaryRatedVoltage = value;
    }

    /**
     * Gets the value of the secondaryRatedVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getSecondaryRatedVoltage() {
        return secondaryRatedVoltage;
    }

    /**
     * Sets the value of the secondaryRatedVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setSecondaryRatedVoltage(VoltageXmlType value) {
        this.secondaryRatedVoltage = value;
    }

    /**
     * Gets the value of the z1 property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZ1() {
        return z1;
    }

    /**
     * Sets the value of the z1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZ1(ZXmlType value) {
        this.z1 = value;
    }

    /**
     * Gets the value of the z0 property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZ0() {
        return z0;
    }

    /**
     * Sets the value of the z0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZ0(ZXmlType value) {
        this.z0 = value;
    }

    /**
     * Gets the value of the primaryTurnRatio property.
     * 
     * @return
     *     possible object is
     *     {@link TurnRatioXmlType }
     *     
     */
    public TurnRatioXmlType getPrimaryTurnRatio() {
        return primaryTurnRatio;
    }

    /**
     * Sets the value of the primaryTurnRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link TurnRatioXmlType }
     *     
     */
    public void setPrimaryTurnRatio(TurnRatioXmlType value) {
        this.primaryTurnRatio = value;
    }

    /**
     * Gets the value of the secondaryTurnRatio property.
     * 
     * @return
     *     possible object is
     *     {@link TurnRatioXmlType }
     *     
     */
    public TurnRatioXmlType getSecondaryTurnRatio() {
        return secondaryTurnRatio;
    }

    /**
     * Sets the value of the secondaryTurnRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link TurnRatioXmlType }
     *     
     */
    public void setSecondaryTurnRatio(TurnRatioXmlType value) {
        this.secondaryTurnRatio = value;
    }

    /**
     * Gets the value of the primaryConnection property.
     * 
     * @return
     *     possible object is
     *     {@link XformerConnectionXmlType }
     *     
     */
    public XformerConnectionXmlType getPrimaryConnection() {
        return primaryConnection;
    }

    /**
     * Sets the value of the primaryConnection property.
     * 
     * @param value
     *     allowed object is
     *     {@link XformerConnectionXmlType }
     *     
     */
    public void setPrimaryConnection(XformerConnectionXmlType value) {
        this.primaryConnection = value;
    }

    /**
     * Gets the value of the secondaryConnection property.
     * 
     * @return
     *     possible object is
     *     {@link XformerConnectionXmlType }
     *     
     */
    public XformerConnectionXmlType getSecondaryConnection() {
        return secondaryConnection;
    }

    /**
     * Sets the value of the secondaryConnection property.
     * 
     * @param value
     *     allowed object is
     *     {@link XformerConnectionXmlType }
     *     
     */
    public void setSecondaryConnection(XformerConnectionXmlType value) {
        this.secondaryConnection = value;
    }

}
