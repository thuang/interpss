//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.19 at 10:22:07 AM GMT-08:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StaticVarCompensatorXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StaticVarCompensatorXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cimRdfRec" type="{http://www.ieee.org/odm/Schema}CimRdfXmlType" minOccurs="0"/>
 *         &lt;element name="cimSwitches" type="{http://www.ieee.org/odm/Schema}CimSwitchListXmlType" minOccurs="0"/>
 *         &lt;element name="offLine" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ratedVoltage" type="{http://www.ieee.org/odm/Schema}VoltageXmlType"/>
 *         &lt;element name="voltageSetPoint" type="{http://www.ieee.org/odm/Schema}VoltageXmlType"/>
 *         &lt;element name="capacitiveRating" type="{http://www.ieee.org/odm/Schema}ReactivePowerXmlType"/>
 *         &lt;element name="inductiveRating" type="{http://www.ieee.org/odm/Schema}ReactivePowerXmlType"/>
 *         &lt;element name="controlMode" type="{http://www.ieee.org/odm/Schema}SVCControlModeEnumType"/>
 *         &lt;element name="slope" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StaticVarCompensatorXmlType", propOrder = {
    "cimRdfRec",
    "cimSwitches",
    "offLine",
    "ratedVoltage",
    "voltageSetPoint",
    "capacitiveRating",
    "inductiveRating",
    "controlMode",
    "slope"
})
public class StaticVarCompensatorXmlType {

    protected CimRdfXmlType cimRdfRec;
    protected CimSwitchListXmlType cimSwitches;
    protected boolean offLine;
    @XmlElement(required = true)
    protected VoltageXmlType ratedVoltage;
    @XmlElement(required = true)
    protected VoltageXmlType voltageSetPoint;
    @XmlElement(required = true)
    protected ReactivePowerXmlType capacitiveRating;
    @XmlElement(required = true)
    protected ReactivePowerXmlType inductiveRating;
    @XmlElement(required = true)
    protected SVCControlModeEnumType controlMode;
    protected float slope;

    /**
     * Gets the value of the cimRdfRec property.
     * 
     * @return
     *     possible object is
     *     {@link CimRdfXmlType }
     *     
     */
    public CimRdfXmlType getCimRdfRec() {
        return cimRdfRec;
    }

    /**
     * Sets the value of the cimRdfRec property.
     * 
     * @param value
     *     allowed object is
     *     {@link CimRdfXmlType }
     *     
     */
    public void setCimRdfRec(CimRdfXmlType value) {
        this.cimRdfRec = value;
    }

    /**
     * Gets the value of the cimSwitches property.
     * 
     * @return
     *     possible object is
     *     {@link CimSwitchListXmlType }
     *     
     */
    public CimSwitchListXmlType getCimSwitches() {
        return cimSwitches;
    }

    /**
     * Sets the value of the cimSwitches property.
     * 
     * @param value
     *     allowed object is
     *     {@link CimSwitchListXmlType }
     *     
     */
    public void setCimSwitches(CimSwitchListXmlType value) {
        this.cimSwitches = value;
    }

    /**
     * Gets the value of the offLine property.
     * 
     */
    public boolean isOffLine() {
        return offLine;
    }

    /**
     * Sets the value of the offLine property.
     * 
     */
    public void setOffLine(boolean value) {
        this.offLine = value;
    }

    /**
     * Gets the value of the ratedVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getRatedVoltage() {
        return ratedVoltage;
    }

    /**
     * Sets the value of the ratedVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setRatedVoltage(VoltageXmlType value) {
        this.ratedVoltage = value;
    }

    /**
     * Gets the value of the voltageSetPoint property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getVoltageSetPoint() {
        return voltageSetPoint;
    }

    /**
     * Sets the value of the voltageSetPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setVoltageSetPoint(VoltageXmlType value) {
        this.voltageSetPoint = value;
    }

    /**
     * Gets the value of the capacitiveRating property.
     * 
     * @return
     *     possible object is
     *     {@link ReactivePowerXmlType }
     *     
     */
    public ReactivePowerXmlType getCapacitiveRating() {
        return capacitiveRating;
    }

    /**
     * Sets the value of the capacitiveRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReactivePowerXmlType }
     *     
     */
    public void setCapacitiveRating(ReactivePowerXmlType value) {
        this.capacitiveRating = value;
    }

    /**
     * Gets the value of the inductiveRating property.
     * 
     * @return
     *     possible object is
     *     {@link ReactivePowerXmlType }
     *     
     */
    public ReactivePowerXmlType getInductiveRating() {
        return inductiveRating;
    }

    /**
     * Sets the value of the inductiveRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReactivePowerXmlType }
     *     
     */
    public void setInductiveRating(ReactivePowerXmlType value) {
        this.inductiveRating = value;
    }

    /**
     * Gets the value of the controlMode property.
     * 
     * @return
     *     possible object is
     *     {@link SVCControlModeEnumType }
     *     
     */
    public SVCControlModeEnumType getControlMode() {
        return controlMode;
    }

    /**
     * Sets the value of the controlMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link SVCControlModeEnumType }
     *     
     */
    public void setControlMode(SVCControlModeEnumType value) {
        this.controlMode = value;
    }

    /**
     * Gets the value of the slope property.
     * 
     */
    public float getSlope() {
        return slope;
    }

    /**
     * Sets the value of the slope property.
     * 
     */
    public void setSlope(float value) {
        this.slope = value;
    }

}
