//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.13 at 02:57:53 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DCLineData2TXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DCLineData2TXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BaseBranchXmlType">
 *       &lt;sequence>
 *         &lt;element name="controlMode" type="{http://www.ieee.org/odm/Schema/2008}DcLineControlModeEnumType"/>
 *         &lt;element name="lineR" type="{http://www.ieee.org/odm/Schema/2008}RXmlType"/>
 *         &lt;element name="lineG" type="{http://www.ieee.org/odm/Schema/2008}GXmlType" minOccurs="0"/>
 *         &lt;element name="currentDemand" type="{http://www.ieee.org/odm/Schema/2008}CurrentXmlType" minOccurs="0"/>
 *         &lt;element name="powerDemand" type="{http://www.ieee.org/odm/Schema/2008}ActivePowerXmlType" minOccurs="0"/>
 *         &lt;element name="controlOnRectifierSide" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="scheduledDCVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="meteredEnd" type="{http://www.ieee.org/odm/Schema/2008}DcLineMeteredEndEnumType" minOccurs="0"/>
 *         &lt;element name="modeSwitchDCVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="compoundingR" type="{http://www.ieee.org/odm/Schema/2008}RXmlType" minOccurs="0"/>
 *         &lt;element name="powerOrCurrentMarginPU" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="minDCVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="maxDCCurrent" type="{http://www.ieee.org/odm/Schema/2008}CurrentXmlType" minOccurs="0"/>
 *         &lt;element name="length" type="{http://www.ieee.org/odm/Schema/2008}LengthXmlType" minOccurs="0"/>
 *         &lt;element name="rectifier" type="{http://www.ieee.org/odm/Schema/2008}ConverterXmlType"/>
 *         &lt;element name="inverter" type="{http://www.ieee.org/odm/Schema/2008}ConverterXmlType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DCLineData2TXmlType", propOrder = {
    "controlMode",
    "lineR",
    "lineG",
    "currentDemand",
    "powerDemand",
    "controlOnRectifierSide",
    "scheduledDCVoltage",
    "meteredEnd",
    "modeSwitchDCVoltage",
    "compoundingR",
    "powerOrCurrentMarginPU",
    "minDCVoltage",
    "maxDCCurrent",
    "length",
    "rectifier",
    "inverter"
})
public class DCLineData2TXmlType
    extends BaseBranchXmlType
{

    @XmlElement(required = true, defaultValue = "blocked")
    protected DcLineControlModeEnumType controlMode;
    @XmlElement(required = true)
    protected RXmlType lineR;
    protected GXmlType lineG;
    protected CurrentXmlType currentDemand;
    protected ActivePowerXmlType powerDemand;
    protected Boolean controlOnRectifierSide;
    protected VoltageXmlType scheduledDCVoltage;
    protected DcLineMeteredEndEnumType meteredEnd;
    protected VoltageXmlType modeSwitchDCVoltage;
    protected RXmlType compoundingR;
    protected Double powerOrCurrentMarginPU;
    protected VoltageXmlType minDCVoltage;
    protected CurrentXmlType maxDCCurrent;
    protected LengthXmlType length;
    @XmlElement(required = true)
    protected ConverterXmlType rectifier;
    @XmlElement(required = true)
    protected ConverterXmlType inverter;

    /**
     * Gets the value of the controlMode property.
     * 
     * @return
     *     possible object is
     *     {@link DcLineControlModeEnumType }
     *     
     */
    public DcLineControlModeEnumType getControlMode() {
        return controlMode;
    }

    /**
     * Sets the value of the controlMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link DcLineControlModeEnumType }
     *     
     */
    public void setControlMode(DcLineControlModeEnumType value) {
        this.controlMode = value;
    }

    /**
     * Gets the value of the lineR property.
     * 
     * @return
     *     possible object is
     *     {@link RXmlType }
     *     
     */
    public RXmlType getLineR() {
        return lineR;
    }

    /**
     * Sets the value of the lineR property.
     * 
     * @param value
     *     allowed object is
     *     {@link RXmlType }
     *     
     */
    public void setLineR(RXmlType value) {
        this.lineR = value;
    }

    /**
     * Gets the value of the lineG property.
     * 
     * @return
     *     possible object is
     *     {@link GXmlType }
     *     
     */
    public GXmlType getLineG() {
        return lineG;
    }

    /**
     * Sets the value of the lineG property.
     * 
     * @param value
     *     allowed object is
     *     {@link GXmlType }
     *     
     */
    public void setLineG(GXmlType value) {
        this.lineG = value;
    }

    /**
     * Gets the value of the currentDemand property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentXmlType }
     *     
     */
    public CurrentXmlType getCurrentDemand() {
        return currentDemand;
    }

    /**
     * Sets the value of the currentDemand property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentXmlType }
     *     
     */
    public void setCurrentDemand(CurrentXmlType value) {
        this.currentDemand = value;
    }

    /**
     * Gets the value of the powerDemand property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePowerXmlType }
     *     
     */
    public ActivePowerXmlType getPowerDemand() {
        return powerDemand;
    }

    /**
     * Sets the value of the powerDemand property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePowerXmlType }
     *     
     */
    public void setPowerDemand(ActivePowerXmlType value) {
        this.powerDemand = value;
    }

    /**
     * Gets the value of the controlOnRectifierSide property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isControlOnRectifierSide() {
        return controlOnRectifierSide;
    }

    /**
     * Sets the value of the controlOnRectifierSide property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setControlOnRectifierSide(Boolean value) {
        this.controlOnRectifierSide = value;
    }

    /**
     * Gets the value of the scheduledDCVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getScheduledDCVoltage() {
        return scheduledDCVoltage;
    }

    /**
     * Sets the value of the scheduledDCVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setScheduledDCVoltage(VoltageXmlType value) {
        this.scheduledDCVoltage = value;
    }

    /**
     * Gets the value of the meteredEnd property.
     * 
     * @return
     *     possible object is
     *     {@link DcLineMeteredEndEnumType }
     *     
     */
    public DcLineMeteredEndEnumType getMeteredEnd() {
        return meteredEnd;
    }

    /**
     * Sets the value of the meteredEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link DcLineMeteredEndEnumType }
     *     
     */
    public void setMeteredEnd(DcLineMeteredEndEnumType value) {
        this.meteredEnd = value;
    }

    /**
     * Gets the value of the modeSwitchDCVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getModeSwitchDCVoltage() {
        return modeSwitchDCVoltage;
    }

    /**
     * Sets the value of the modeSwitchDCVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setModeSwitchDCVoltage(VoltageXmlType value) {
        this.modeSwitchDCVoltage = value;
    }

    /**
     * Gets the value of the compoundingR property.
     * 
     * @return
     *     possible object is
     *     {@link RXmlType }
     *     
     */
    public RXmlType getCompoundingR() {
        return compoundingR;
    }

    /**
     * Sets the value of the compoundingR property.
     * 
     * @param value
     *     allowed object is
     *     {@link RXmlType }
     *     
     */
    public void setCompoundingR(RXmlType value) {
        this.compoundingR = value;
    }

    /**
     * Gets the value of the powerOrCurrentMarginPU property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPowerOrCurrentMarginPU() {
        return powerOrCurrentMarginPU;
    }

    /**
     * Sets the value of the powerOrCurrentMarginPU property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPowerOrCurrentMarginPU(Double value) {
        this.powerOrCurrentMarginPU = value;
    }

    /**
     * Gets the value of the minDCVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getMinDCVoltage() {
        return minDCVoltage;
    }

    /**
     * Sets the value of the minDCVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setMinDCVoltage(VoltageXmlType value) {
        this.minDCVoltage = value;
    }

    /**
     * Gets the value of the maxDCCurrent property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentXmlType }
     *     
     */
    public CurrentXmlType getMaxDCCurrent() {
        return maxDCCurrent;
    }

    /**
     * Sets the value of the maxDCCurrent property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentXmlType }
     *     
     */
    public void setMaxDCCurrent(CurrentXmlType value) {
        this.maxDCCurrent = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link LengthXmlType }
     *     
     */
    public LengthXmlType getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthXmlType }
     *     
     */
    public void setLength(LengthXmlType value) {
        this.length = value;
    }

    /**
     * Gets the value of the rectifier property.
     * 
     * @return
     *     possible object is
     *     {@link ConverterXmlType }
     *     
     */
    public ConverterXmlType getRectifier() {
        return rectifier;
    }

    /**
     * Sets the value of the rectifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConverterXmlType }
     *     
     */
    public void setRectifier(ConverterXmlType value) {
        this.rectifier = value;
    }

    /**
     * Gets the value of the inverter property.
     * 
     * @return
     *     possible object is
     *     {@link ConverterXmlType }
     *     
     */
    public ConverterXmlType getInverter() {
        return inverter;
    }

    /**
     * Sets the value of the inverter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConverterXmlType }
     *     
     */
    public void setInverter(ConverterXmlType value) {
        this.inverter = value;
    }

}
