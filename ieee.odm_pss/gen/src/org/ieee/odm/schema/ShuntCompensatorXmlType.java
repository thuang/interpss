//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.05.01 at 08:34:39 PM PDT 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ShuntCompensatorXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShuntCompensatorXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cimRdfRec" type="{http://www.ieee.org/odm/Schema}CimRdfXmlType" minOccurs="0"/>
 *         &lt;element name="cimSwitches" type="{http://www.ieee.org/odm/Schema}CimSwitchListXmlType" minOccurs="0"/>
 *         &lt;element name="desiredVoltageRange" type="{http://www.ieee.org/odm/Schema}VoltageLimitXmlType"/>
 *         &lt;element name="varPercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bInit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="remoteControlledBus" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType" minOccurs="0"/>
 *         &lt;element name="block" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="incrementB" type="{http://www.ieee.org/odm/Schema}ReactivePowerXmlType"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="steps" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="vscDcLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="mode" use="required" type="{http://www.ieee.org/odm/Schema}ShuntCompensatorModeEnumType" />
 *       &lt;attribute name="offLine" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShuntCompensatorXmlType", propOrder = {
    "cimRdfRec",
    "cimSwitches",
    "desiredVoltageRange",
    "varPercent",
    "bInit",
    "remoteControlledBus",
    "block",
    "vscDcLine"
})
public class ShuntCompensatorXmlType {

    protected CimRdfXmlType cimRdfRec;
    protected CimSwitchListXmlType cimSwitches;
    @XmlElement(required = true)
    protected VoltageLimitXmlType desiredVoltageRange;
    protected Double varPercent;
    protected double bInit;
    protected IDRefRecordXmlType remoteControlledBus;
    @XmlElement(required = true)
    protected List<ShuntCompensatorXmlType.Block> block;
    protected String vscDcLine;
    @XmlAttribute(required = true)
    protected ShuntCompensatorModeEnumType mode;
    @XmlAttribute(required = true)
    protected boolean offLine;

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
     * Gets the value of the desiredVoltageRange property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageLimitXmlType }
     *     
     */
    public VoltageLimitXmlType getDesiredVoltageRange() {
        return desiredVoltageRange;
    }

    /**
     * Sets the value of the desiredVoltageRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageLimitXmlType }
     *     
     */
    public void setDesiredVoltageRange(VoltageLimitXmlType value) {
        this.desiredVoltageRange = value;
    }

    /**
     * Gets the value of the varPercent property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVarPercent() {
        return varPercent;
    }

    /**
     * Sets the value of the varPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVarPercent(Double value) {
        this.varPercent = value;
    }

    /**
     * Gets the value of the bInit property.
     * 
     */
    public double getBInit() {
        return bInit;
    }

    /**
     * Sets the value of the bInit property.
     * 
     */
    public void setBInit(double value) {
        this.bInit = value;
    }

    /**
     * Gets the value of the remoteControlledBus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getRemoteControlledBus() {
        return remoteControlledBus;
    }

    /**
     * Sets the value of the remoteControlledBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setRemoteControlledBus(IDRefRecordXmlType value) {
        this.remoteControlledBus = value;
    }

    /**
     * Gets the value of the block property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the block property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlock().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShuntCompensatorXmlType.Block }
     * 
     * 
     */
    public List<ShuntCompensatorXmlType.Block> getBlock() {
        if (block == null) {
            block = new ArrayList<ShuntCompensatorXmlType.Block>();
        }
        return this.block;
    }

    /**
     * Gets the value of the vscDcLine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVscDcLine() {
        return vscDcLine;
    }

    /**
     * Sets the value of the vscDcLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVscDcLine(String value) {
        this.vscDcLine = value;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link ShuntCompensatorModeEnumType }
     *     
     */
    public ShuntCompensatorModeEnumType getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShuntCompensatorModeEnumType }
     *     
     */
    public void setMode(ShuntCompensatorModeEnumType value) {
        this.mode = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="incrementB" type="{http://www.ieee.org/odm/Schema}ReactivePowerXmlType"/>
     *       &lt;/sequence>
     *       &lt;attribute name="steps" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "incrementB"
    })
    public static class Block {

        @XmlElement(required = true)
        protected ReactivePowerXmlType incrementB;
        @XmlAttribute(required = true)
        protected int steps;

        /**
         * Gets the value of the incrementB property.
         * 
         * @return
         *     possible object is
         *     {@link ReactivePowerXmlType }
         *     
         */
        public ReactivePowerXmlType getIncrementB() {
            return incrementB;
        }

        /**
         * Sets the value of the incrementB property.
         * 
         * @param value
         *     allowed object is
         *     {@link ReactivePowerXmlType }
         *     
         */
        public void setIncrementB(ReactivePowerXmlType value) {
            this.incrementB = value;
        }

        /**
         * Gets the value of the steps property.
         * 
         */
        public int getSteps() {
            return steps;
        }

        /**
         * Sets the value of the steps property.
         * 
         */
        public void setSteps(int value) {
            this.steps = value;
        }

    }

}
