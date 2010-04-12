//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.11 at 06:23:56 PM PDT 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransientSimulationXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransientSimulationXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="simulationSetting" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="simulationMethod" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="ModifiedEuler"/>
 *                         &lt;enumeration value="RungerKutta"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="simlationTime" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType" minOccurs="0"/>
 *                   &lt;element name="simulationSteps" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="powerFlowInitialization" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="powerFlowCase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="powerFlowMethod" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="NR"/>
 *                         &lt;enumeration value="PQ"/>
 *                         &lt;enumeration value="GS"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="errTolerance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;element name="maxInteration" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="dynamicDataList" type="{http://www.ieee.org/odm/Schema}DynamicDataListXmlType"/>
 *         &lt;element name="outPutSetting" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransientSimulationXmlType", propOrder = {
    "simulationSetting",
    "powerFlowInitialization",
    "dynamicDataList",
    "outPutSetting"
})
public class TransientSimulationXmlType {

    protected TransientSimulationXmlType.SimulationSetting simulationSetting;
    protected TransientSimulationXmlType.PowerFlowInitialization powerFlowInitialization;
    @XmlElement(required = true)
    protected DynamicDataListXmlType dynamicDataList;
    protected TransientSimulationXmlType.OutPutSetting outPutSetting;

    /**
     * Gets the value of the simulationSetting property.
     * 
     * @return
     *     possible object is
     *     {@link TransientSimulationXmlType.SimulationSetting }
     *     
     */
    public TransientSimulationXmlType.SimulationSetting getSimulationSetting() {
        return simulationSetting;
    }

    /**
     * Sets the value of the simulationSetting property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransientSimulationXmlType.SimulationSetting }
     *     
     */
    public void setSimulationSetting(TransientSimulationXmlType.SimulationSetting value) {
        this.simulationSetting = value;
    }

    /**
     * Gets the value of the powerFlowInitialization property.
     * 
     * @return
     *     possible object is
     *     {@link TransientSimulationXmlType.PowerFlowInitialization }
     *     
     */
    public TransientSimulationXmlType.PowerFlowInitialization getPowerFlowInitialization() {
        return powerFlowInitialization;
    }

    /**
     * Sets the value of the powerFlowInitialization property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransientSimulationXmlType.PowerFlowInitialization }
     *     
     */
    public void setPowerFlowInitialization(TransientSimulationXmlType.PowerFlowInitialization value) {
        this.powerFlowInitialization = value;
    }

    /**
     * Gets the value of the dynamicDataList property.
     * 
     * @return
     *     possible object is
     *     {@link DynamicDataListXmlType }
     *     
     */
    public DynamicDataListXmlType getDynamicDataList() {
        return dynamicDataList;
    }

    /**
     * Sets the value of the dynamicDataList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DynamicDataListXmlType }
     *     
     */
    public void setDynamicDataList(DynamicDataListXmlType value) {
        this.dynamicDataList = value;
    }

    /**
     * Gets the value of the outPutSetting property.
     * 
     * @return
     *     possible object is
     *     {@link TransientSimulationXmlType.OutPutSetting }
     *     
     */
    public TransientSimulationXmlType.OutPutSetting getOutPutSetting() {
        return outPutSetting;
    }

    /**
     * Sets the value of the outPutSetting property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransientSimulationXmlType.OutPutSetting }
     *     
     */
    public void setOutPutSetting(TransientSimulationXmlType.OutPutSetting value) {
        this.outPutSetting = value;
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
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OutPutSetting {


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
     *         &lt;element name="powerFlowCase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="powerFlowMethod" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="NR"/>
     *               &lt;enumeration value="PQ"/>
     *               &lt;enumeration value="GS"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="errTolerance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="maxInteration" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "powerFlowCase",
        "powerFlowMethod",
        "errTolerance",
        "maxInteration"
    })
    public static class PowerFlowInitialization {

        protected String powerFlowCase;
        protected String powerFlowMethod;
        protected Double errTolerance;
        protected Double maxInteration;

        /**
         * Gets the value of the powerFlowCase property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPowerFlowCase() {
            return powerFlowCase;
        }

        /**
         * Sets the value of the powerFlowCase property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPowerFlowCase(String value) {
            this.powerFlowCase = value;
        }

        /**
         * Gets the value of the powerFlowMethod property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPowerFlowMethod() {
            return powerFlowMethod;
        }

        /**
         * Sets the value of the powerFlowMethod property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPowerFlowMethod(String value) {
            this.powerFlowMethod = value;
        }

        /**
         * Gets the value of the errTolerance property.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getErrTolerance() {
            return errTolerance;
        }

        /**
         * Sets the value of the errTolerance property.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setErrTolerance(Double value) {
            this.errTolerance = value;
        }

        /**
         * Gets the value of the maxInteration property.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getMaxInteration() {
            return maxInteration;
        }

        /**
         * Sets the value of the maxInteration property.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setMaxInteration(Double value) {
            this.maxInteration = value;
        }

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
     *         &lt;element name="simulationMethod" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="ModifiedEuler"/>
     *               &lt;enumeration value="RungerKutta"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="simlationTime" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType" minOccurs="0"/>
     *         &lt;element name="simulationSteps" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "simulationMethod",
        "simlationTime",
        "simulationSteps"
    })
    public static class SimulationSetting {

        protected String simulationMethod;
        protected TimePeriodXmlType simlationTime;
        protected TimePeriodXmlType simulationSteps;

        /**
         * Gets the value of the simulationMethod property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSimulationMethod() {
            return simulationMethod;
        }

        /**
         * Sets the value of the simulationMethod property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSimulationMethod(String value) {
            this.simulationMethod = value;
        }

        /**
         * Gets the value of the simlationTime property.
         * 
         * @return
         *     possible object is
         *     {@link TimePeriodXmlType }
         *     
         */
        public TimePeriodXmlType getSimlationTime() {
            return simlationTime;
        }

        /**
         * Sets the value of the simlationTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link TimePeriodXmlType }
         *     
         */
        public void setSimlationTime(TimePeriodXmlType value) {
            this.simlationTime = value;
        }

        /**
         * Gets the value of the simulationSteps property.
         * 
         * @return
         *     possible object is
         *     {@link TimePeriodXmlType }
         *     
         */
        public TimePeriodXmlType getSimulationSteps() {
            return simulationSteps;
        }

        /**
         * Sets the value of the simulationSteps property.
         * 
         * @param value
         *     allowed object is
         *     {@link TimePeriodXmlType }
         *     
         */
        public void setSimulationSteps(TimePeriodXmlType value) {
            this.simulationSteps = value;
        }

    }

}
