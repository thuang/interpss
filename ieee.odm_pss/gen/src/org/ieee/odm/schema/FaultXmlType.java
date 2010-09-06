//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.05 at 07:28:10 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FaultXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaultXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="faultType" type="{http://www.ieee.org/odm/Schema/2008}FaultTypeEnumType"/>
 *         &lt;choice>
 *           &lt;element name="branchFault" type="{http://www.ieee.org/odm/Schema/2008}BranchFaultXmlType" minOccurs="0"/>
 *           &lt;element name="busFault" type="{http://www.ieee.org/odm/Schema/2008}BusFaultXmlType" minOccurs="0"/>
 *           &lt;element name="dcLineFault" type="{http://www.ieee.org/odm/Schema/2008}DcLineFaultXmlType" minOccurs="0"/>
 *           &lt;element name="branchOutage" type="{http://www.ieee.org/odm/Schema/2008}BranchOutageXmlType" minOccurs="0"/>
 *           &lt;element name="loadChange" type="{http://www.ieee.org/odm/Schema/2008}LoadChangeDynamicEventXmlType" minOccurs="0"/>
 *           &lt;element name="genChange" type="{http://www.ieee.org/odm/Schema/2008}GenChangeDynamicEventXmlType" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaultXmlType", propOrder = {
    "faultType",
    "branchFault",
    "busFault",
    "dcLineFault",
    "branchOutage",
    "loadChange",
    "genChange"
})
public class FaultXmlType {

    @XmlElement(required = true)
    protected FaultTypeEnumType faultType;
    protected BranchFaultXmlType branchFault;
    protected BusFaultXmlType busFault;
    protected DcLineFaultXmlType dcLineFault;
    protected BranchOutageXmlType branchOutage;
    protected LoadChangeDynamicEventXmlType loadChange;
    protected GenChangeDynamicEventXmlType genChange;

    /**
     * Gets the value of the faultType property.
     * 
     * @return
     *     possible object is
     *     {@link FaultTypeEnumType }
     *     
     */
    public FaultTypeEnumType getFaultType() {
        return faultType;
    }

    /**
     * Sets the value of the faultType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FaultTypeEnumType }
     *     
     */
    public void setFaultType(FaultTypeEnumType value) {
        this.faultType = value;
    }

    /**
     * Gets the value of the branchFault property.
     * 
     * @return
     *     possible object is
     *     {@link BranchFaultXmlType }
     *     
     */
    public BranchFaultXmlType getBranchFault() {
        return branchFault;
    }

    /**
     * Sets the value of the branchFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchFaultXmlType }
     *     
     */
    public void setBranchFault(BranchFaultXmlType value) {
        this.branchFault = value;
    }

    /**
     * Gets the value of the busFault property.
     * 
     * @return
     *     possible object is
     *     {@link BusFaultXmlType }
     *     
     */
    public BusFaultXmlType getBusFault() {
        return busFault;
    }

    /**
     * Sets the value of the busFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusFaultXmlType }
     *     
     */
    public void setBusFault(BusFaultXmlType value) {
        this.busFault = value;
    }

    /**
     * Gets the value of the dcLineFault property.
     * 
     * @return
     *     possible object is
     *     {@link DcLineFaultXmlType }
     *     
     */
    public DcLineFaultXmlType getDcLineFault() {
        return dcLineFault;
    }

    /**
     * Sets the value of the dcLineFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link DcLineFaultXmlType }
     *     
     */
    public void setDcLineFault(DcLineFaultXmlType value) {
        this.dcLineFault = value;
    }

    /**
     * Gets the value of the branchOutage property.
     * 
     * @return
     *     possible object is
     *     {@link BranchOutageXmlType }
     *     
     */
    public BranchOutageXmlType getBranchOutage() {
        return branchOutage;
    }

    /**
     * Sets the value of the branchOutage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchOutageXmlType }
     *     
     */
    public void setBranchOutage(BranchOutageXmlType value) {
        this.branchOutage = value;
    }

    /**
     * Gets the value of the loadChange property.
     * 
     * @return
     *     possible object is
     *     {@link LoadChangeDynamicEventXmlType }
     *     
     */
    public LoadChangeDynamicEventXmlType getLoadChange() {
        return loadChange;
    }

    /**
     * Sets the value of the loadChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadChangeDynamicEventXmlType }
     *     
     */
    public void setLoadChange(LoadChangeDynamicEventXmlType value) {
        this.loadChange = value;
    }

    /**
     * Gets the value of the genChange property.
     * 
     * @return
     *     possible object is
     *     {@link GenChangeDynamicEventXmlType }
     *     
     */
    public GenChangeDynamicEventXmlType getGenChange() {
        return genChange;
    }

    /**
     * Sets the value of the genChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenChangeDynamicEventXmlType }
     *     
     */
    public void setGenChange(GenChangeDynamicEventXmlType value) {
        this.genChange = value;
    }

}
