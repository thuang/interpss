//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.20 at 07:45:56 AM GMT-08:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoadCharacteristicModelListXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoadCharacteristicModelListXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IEEEStaticLoad" type="{http://www.ieee.org/odm/Schema/2008}DLoad_IEEEStaticLoadXmlType" minOccurs="0"/>
 *         &lt;element name="ComplexLoad" type="{http://www.ieee.org/odm/Schema/2008}DLoad_ComplexLoadXmlType" minOccurs="0"/>
 *         &lt;element name="InductionMotor" type="{http://www.ieee.org/odm/Schema/2008}DLoad_InductionMotorXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadCharacteristicModelListXmlType", propOrder = {
    "ieeeStaticLoad",
    "complexLoad",
    "inductionMotor"
})
public class LoadCharacteristicModelListXmlType {

    @XmlElement(name = "IEEEStaticLoad")
    protected DLoadIEEEStaticLoadXmlType ieeeStaticLoad;
    @XmlElement(name = "ComplexLoad")
    protected DLoadComplexLoadXmlType complexLoad;
    @XmlElement(name = "InductionMotor")
    protected DLoadInductionMotorXmlType inductionMotor;

    /**
     * Gets the value of the ieeeStaticLoad property.
     * 
     * @return
     *     possible object is
     *     {@link DLoadIEEEStaticLoadXmlType }
     *     
     */
    public DLoadIEEEStaticLoadXmlType getIEEEStaticLoad() {
        return ieeeStaticLoad;
    }

    /**
     * Sets the value of the ieeeStaticLoad property.
     * 
     * @param value
     *     allowed object is
     *     {@link DLoadIEEEStaticLoadXmlType }
     *     
     */
    public void setIEEEStaticLoad(DLoadIEEEStaticLoadXmlType value) {
        this.ieeeStaticLoad = value;
    }

    /**
     * Gets the value of the complexLoad property.
     * 
     * @return
     *     possible object is
     *     {@link DLoadComplexLoadXmlType }
     *     
     */
    public DLoadComplexLoadXmlType getComplexLoad() {
        return complexLoad;
    }

    /**
     * Sets the value of the complexLoad property.
     * 
     * @param value
     *     allowed object is
     *     {@link DLoadComplexLoadXmlType }
     *     
     */
    public void setComplexLoad(DLoadComplexLoadXmlType value) {
        this.complexLoad = value;
    }

    /**
     * Gets the value of the inductionMotor property.
     * 
     * @return
     *     possible object is
     *     {@link DLoadInductionMotorXmlType }
     *     
     */
    public DLoadInductionMotorXmlType getInductionMotor() {
        return inductionMotor;
    }

    /**
     * Sets the value of the inductionMotor property.
     * 
     * @param value
     *     allowed object is
     *     {@link DLoadInductionMotorXmlType }
     *     
     */
    public void setInductionMotor(DLoadInductionMotorXmlType value) {
        this.inductionMotor = value;
    }

}
