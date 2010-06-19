//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.19 at 10:22:07 AM GMT-08:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MachineModelSelectionXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MachineModelSelectionXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="equiGenUnit" type="{http://www.ieee.org/odm/Schema}EquiMachineXmlType" minOccurs="0"/>
 *         &lt;element name="classicalModel" type="{http://www.ieee.org/odm/Schema}ClassicMachineXmlType" minOccurs="0"/>
 *         &lt;element name="transModel" type="{http://www.ieee.org/odm/Schema}TransientMachineXmlType" minOccurs="0"/>
 *         &lt;element name="subTransientModel" type="{http://www.ieee.org/odm/Schema}SubTransientMachineXmlType" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MachineModelSelectionXmlType", propOrder = {
    "equiGenUnit",
    "classicalModel",
    "transModel",
    "subTransientModel"
})
public class MachineModelSelectionXmlType {

    protected EquiMachineXmlType equiGenUnit;
    protected ClassicMachineXmlType classicalModel;
    protected TransientMachineXmlType transModel;
    protected SubTransientMachineXmlType subTransientModel;

    /**
     * Gets the value of the equiGenUnit property.
     * 
     * @return
     *     possible object is
     *     {@link EquiMachineXmlType }
     *     
     */
    public EquiMachineXmlType getEquiGenUnit() {
        return equiGenUnit;
    }

    /**
     * Sets the value of the equiGenUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link EquiMachineXmlType }
     *     
     */
    public void setEquiGenUnit(EquiMachineXmlType value) {
        this.equiGenUnit = value;
    }

    /**
     * Gets the value of the classicalModel property.
     * 
     * @return
     *     possible object is
     *     {@link ClassicMachineXmlType }
     *     
     */
    public ClassicMachineXmlType getClassicalModel() {
        return classicalModel;
    }

    /**
     * Sets the value of the classicalModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassicMachineXmlType }
     *     
     */
    public void setClassicalModel(ClassicMachineXmlType value) {
        this.classicalModel = value;
    }

    /**
     * Gets the value of the transModel property.
     * 
     * @return
     *     possible object is
     *     {@link TransientMachineXmlType }
     *     
     */
    public TransientMachineXmlType getTransModel() {
        return transModel;
    }

    /**
     * Sets the value of the transModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransientMachineXmlType }
     *     
     */
    public void setTransModel(TransientMachineXmlType value) {
        this.transModel = value;
    }

    /**
     * Gets the value of the subTransientModel property.
     * 
     * @return
     *     possible object is
     *     {@link SubTransientMachineXmlType }
     *     
     */
    public SubTransientMachineXmlType getSubTransientModel() {
        return subTransientModel;
    }

    /**
     * Sets the value of the subTransientModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubTransientMachineXmlType }
     *     
     */
    public void setSubTransientModel(SubTransientMachineXmlType value) {
        this.subTransientModel = value;
    }

}
