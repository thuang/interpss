//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.09 at 02:27:16 PM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		
 * 
 * <p>Java class for DStabBusXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DStabBusXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}ShortCircuitBusXmlType">
 *       &lt;sequence>
 *         &lt;element name="machineList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="machine" type="{http://www.ieee.org/odm/Schema/2008}DynamicMachineXmlType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="dynamicLoad" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="location" type="{http://www.ieee.org/odm/Schema/2008}LoadCharacteristicLocationEnumType"/>
 *                   &lt;element name="LoadXmlType" type="{http://www.ieee.org/odm/Schema/2008}LoadCharacteristicTypeEnumType"/>
 *                   &lt;element name="LoadModel" type="{http://www.ieee.org/odm/Schema/2008}DynamicLoadModelSelectionXmlType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DStabBusXmlType", propOrder = {
    "machineList",
    "dynamicLoad"
})
public class DStabBusXmlType
    extends ShortCircuitBusXmlType
{

    protected DStabBusXmlType.MachineList machineList;
    protected DStabBusXmlType.DynamicLoad dynamicLoad;

    /**
     * Gets the value of the machineList property.
     * 
     * @return
     *     possible object is
     *     {@link DStabBusXmlType.MachineList }
     *     
     */
    public DStabBusXmlType.MachineList getMachineList() {
        return machineList;
    }

    /**
     * Sets the value of the machineList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DStabBusXmlType.MachineList }
     *     
     */
    public void setMachineList(DStabBusXmlType.MachineList value) {
        this.machineList = value;
    }

    /**
     * Gets the value of the dynamicLoad property.
     * 
     * @return
     *     possible object is
     *     {@link DStabBusXmlType.DynamicLoad }
     *     
     */
    public DStabBusXmlType.DynamicLoad getDynamicLoad() {
        return dynamicLoad;
    }

    /**
     * Sets the value of the dynamicLoad property.
     * 
     * @param value
     *     allowed object is
     *     {@link DStabBusXmlType.DynamicLoad }
     *     
     */
    public void setDynamicLoad(DStabBusXmlType.DynamicLoad value) {
        this.dynamicLoad = value;
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
     *         &lt;element name="location" type="{http://www.ieee.org/odm/Schema/2008}LoadCharacteristicLocationEnumType"/>
     *         &lt;element name="LoadXmlType" type="{http://www.ieee.org/odm/Schema/2008}LoadCharacteristicTypeEnumType"/>
     *         &lt;element name="LoadModel" type="{http://www.ieee.org/odm/Schema/2008}DynamicLoadModelSelectionXmlType"/>
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
        "location",
        "loadXmlType",
        "loadModel"
    })
    public static class DynamicLoad {

        @XmlElement(required = true)
        protected LoadCharacteristicLocationEnumType location;
        @XmlElement(name = "LoadXmlType", required = true)
        protected LoadCharacteristicTypeEnumType loadXmlType;
        @XmlElement(name = "LoadModel", required = true)
        protected DynamicLoadModelSelectionXmlType loadModel;

        /**
         * Gets the value of the location property.
         * 
         * @return
         *     possible object is
         *     {@link LoadCharacteristicLocationEnumType }
         *     
         */
        public LoadCharacteristicLocationEnumType getLocation() {
            return location;
        }

        /**
         * Sets the value of the location property.
         * 
         * @param value
         *     allowed object is
         *     {@link LoadCharacteristicLocationEnumType }
         *     
         */
        public void setLocation(LoadCharacteristicLocationEnumType value) {
            this.location = value;
        }

        /**
         * Gets the value of the loadXmlType property.
         * 
         * @return
         *     possible object is
         *     {@link LoadCharacteristicTypeEnumType }
         *     
         */
        public LoadCharacteristicTypeEnumType getLoadXmlType() {
            return loadXmlType;
        }

        /**
         * Sets the value of the loadXmlType property.
         * 
         * @param value
         *     allowed object is
         *     {@link LoadCharacteristicTypeEnumType }
         *     
         */
        public void setLoadXmlType(LoadCharacteristicTypeEnumType value) {
            this.loadXmlType = value;
        }

        /**
         * Gets the value of the loadModel property.
         * 
         * @return
         *     possible object is
         *     {@link DynamicLoadModelSelectionXmlType }
         *     
         */
        public DynamicLoadModelSelectionXmlType getLoadModel() {
            return loadModel;
        }

        /**
         * Sets the value of the loadModel property.
         * 
         * @param value
         *     allowed object is
         *     {@link DynamicLoadModelSelectionXmlType }
         *     
         */
        public void setLoadModel(DynamicLoadModelSelectionXmlType value) {
            this.loadModel = value;
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
     *         &lt;element name="machine" type="{http://www.ieee.org/odm/Schema/2008}DynamicMachineXmlType" maxOccurs="unbounded"/>
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
        "machine"
    })
    public static class MachineList {

        @XmlElement(required = true)
        protected List<DynamicMachineXmlType> machine;

        /**
         * Gets the value of the machine property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the machine property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMachine().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DynamicMachineXmlType }
         * 
         * 
         */
        public List<DynamicMachineXmlType> getMachine() {
            if (machine == null) {
                machine = new ArrayList<DynamicMachineXmlType>();
            }
            return this.machine;
        }

    }

}
