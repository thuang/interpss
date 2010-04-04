//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.04 at 10:04:25 AM PDT 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DynamicDataListXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DynamicDataListXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="busDynDataList" type="{http://www.ieee.org/odm/Schema}BusDynDataListXmlType" minOccurs="0"/>
 *         &lt;element name="branchDynDataList" type="{http://www.ieee.org/odm/Schema}BranchDynDataListXmlType" minOccurs="0"/>
 *         &lt;element name="faultList" type="{http://www.ieee.org/odm/Schema}FaultListXmlType" minOccurs="0"/>
 *         &lt;element name="sequenceDataList" type="{http://www.ieee.org/odm/Schema}SequenceDataListXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DynamicDataListXmlType", propOrder = {
    "busDynDataList",
    "branchDynDataList",
    "faultList",
    "sequenceDataList"
})
public class DynamicDataListXmlType {

    protected BusDynDataListXmlType busDynDataList;
    protected BranchDynDataListXmlType branchDynDataList;
    protected FaultListXmlType faultList;
    protected SequenceDataListXmlType sequenceDataList;

    /**
     * Gets the value of the busDynDataList property.
     * 
     * @return
     *     possible object is
     *     {@link BusDynDataListXmlType }
     *     
     */
    public BusDynDataListXmlType getBusDynDataList() {
        return busDynDataList;
    }

    /**
     * Sets the value of the busDynDataList property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusDynDataListXmlType }
     *     
     */
    public void setBusDynDataList(BusDynDataListXmlType value) {
        this.busDynDataList = value;
    }

    /**
     * Gets the value of the branchDynDataList property.
     * 
     * @return
     *     possible object is
     *     {@link BranchDynDataListXmlType }
     *     
     */
    public BranchDynDataListXmlType getBranchDynDataList() {
        return branchDynDataList;
    }

    /**
     * Sets the value of the branchDynDataList property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchDynDataListXmlType }
     *     
     */
    public void setBranchDynDataList(BranchDynDataListXmlType value) {
        this.branchDynDataList = value;
    }

    /**
     * Gets the value of the faultList property.
     * 
     * @return
     *     possible object is
     *     {@link FaultListXmlType }
     *     
     */
    public FaultListXmlType getFaultList() {
        return faultList;
    }

    /**
     * Sets the value of the faultList property.
     * 
     * @param value
     *     allowed object is
     *     {@link FaultListXmlType }
     *     
     */
    public void setFaultList(FaultListXmlType value) {
        this.faultList = value;
    }

    /**
     * Gets the value of the sequenceDataList property.
     * 
     * @return
     *     possible object is
     *     {@link SequenceDataListXmlType }
     *     
     */
    public SequenceDataListXmlType getSequenceDataList() {
        return sequenceDataList;
    }

    /**
     * Sets the value of the sequenceDataList property.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceDataListXmlType }
     *     
     */
    public void setSequenceDataList(SequenceDataListXmlType value) {
        this.sequenceDataList = value;
    }

}
