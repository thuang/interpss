//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.05.03 at 08:21:20 PM PDT 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PssIEEE1982Type2AXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PssIEEE1982Type2AXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stabilizerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstInputSignal" type="{http://www.ieee.org/odm/Schema}StabilizerInputSignalEnumType"/>
 *         &lt;element name="firstRemoteBusId" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType"/>
 *         &lt;element name="secondInputSignal" type="{http://www.ieee.org/odm/Schema}StabilizerInputSignalEnumType"/>
 *         &lt;element name="secondRemoteBusId" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType"/>
 *         &lt;element name="M" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="N" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TW1" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="TW2" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="T6" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="TW3" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="TW4" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="T7" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="KS2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="KS3" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T8" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="T9" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="KS1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T1" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="T2" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="T3" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="T4" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="VSTMAX" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VSTMIN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PssIEEE1982Type2AXmlType", propOrder = {
    "stabilizerName",
    "desc",
    "firstInputSignal",
    "firstRemoteBusId",
    "secondInputSignal",
    "secondRemoteBusId",
    "m",
    "n",
    "tw1",
    "tw2",
    "t6",
    "tw3",
    "tw4",
    "t7",
    "ks2",
    "ks3",
    "t8",
    "t9",
    "ks1",
    "t1",
    "t2",
    "t3",
    "t4",
    "vstmax",
    "vstmin"
})
public class PssIEEE1982Type2AXmlType {

    protected String stabilizerName;
    protected String desc;
    @XmlElement(required = true)
    protected StabilizerInputSignalEnumType firstInputSignal;
    @XmlElement(required = true)
    protected IDRefRecordXmlType firstRemoteBusId;
    @XmlElement(required = true)
    protected StabilizerInputSignalEnumType secondInputSignal;
    @XmlElement(required = true)
    protected IDRefRecordXmlType secondRemoteBusId;
    @XmlElement(name = "M")
    protected double m;
    @XmlElement(name = "N")
    protected double n;
    @XmlElement(name = "TW1", required = true)
    protected TimePeriodXmlType tw1;
    @XmlElement(name = "TW2", required = true)
    protected TimePeriodXmlType tw2;
    @XmlElement(name = "T6", required = true)
    protected TimePeriodXmlType t6;
    @XmlElement(name = "TW3", required = true)
    protected TimePeriodXmlType tw3;
    @XmlElement(name = "TW4", required = true)
    protected TimePeriodXmlType tw4;
    @XmlElement(name = "T7", required = true)
    protected TimePeriodXmlType t7;
    @XmlElement(name = "KS2")
    protected double ks2;
    @XmlElement(name = "KS3")
    protected double ks3;
    @XmlElement(name = "T8", required = true)
    protected TimePeriodXmlType t8;
    @XmlElement(name = "T9", required = true)
    protected TimePeriodXmlType t9;
    @XmlElement(name = "KS1")
    protected double ks1;
    @XmlElement(name = "T1", required = true)
    protected TimePeriodXmlType t1;
    @XmlElement(name = "T2", required = true)
    protected TimePeriodXmlType t2;
    @XmlElement(name = "T3", required = true)
    protected TimePeriodXmlType t3;
    @XmlElement(name = "T4", required = true)
    protected TimePeriodXmlType t4;
    @XmlElement(name = "VSTMAX", required = true)
    protected String vstmax;
    @XmlElement(name = "VSTMIN", required = true)
    protected String vstmin;

    /**
     * Gets the value of the stabilizerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStabilizerName() {
        return stabilizerName;
    }

    /**
     * Sets the value of the stabilizerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStabilizerName(String value) {
        this.stabilizerName = value;
    }

    /**
     * Gets the value of the desc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Gets the value of the firstInputSignal property.
     * 
     * @return
     *     possible object is
     *     {@link StabilizerInputSignalEnumType }
     *     
     */
    public StabilizerInputSignalEnumType getFirstInputSignal() {
        return firstInputSignal;
    }

    /**
     * Sets the value of the firstInputSignal property.
     * 
     * @param value
     *     allowed object is
     *     {@link StabilizerInputSignalEnumType }
     *     
     */
    public void setFirstInputSignal(StabilizerInputSignalEnumType value) {
        this.firstInputSignal = value;
    }

    /**
     * Gets the value of the firstRemoteBusId property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getFirstRemoteBusId() {
        return firstRemoteBusId;
    }

    /**
     * Sets the value of the firstRemoteBusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setFirstRemoteBusId(IDRefRecordXmlType value) {
        this.firstRemoteBusId = value;
    }

    /**
     * Gets the value of the secondInputSignal property.
     * 
     * @return
     *     possible object is
     *     {@link StabilizerInputSignalEnumType }
     *     
     */
    public StabilizerInputSignalEnumType getSecondInputSignal() {
        return secondInputSignal;
    }

    /**
     * Sets the value of the secondInputSignal property.
     * 
     * @param value
     *     allowed object is
     *     {@link StabilizerInputSignalEnumType }
     *     
     */
    public void setSecondInputSignal(StabilizerInputSignalEnumType value) {
        this.secondInputSignal = value;
    }

    /**
     * Gets the value of the secondRemoteBusId property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getSecondRemoteBusId() {
        return secondRemoteBusId;
    }

    /**
     * Sets the value of the secondRemoteBusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setSecondRemoteBusId(IDRefRecordXmlType value) {
        this.secondRemoteBusId = value;
    }

    /**
     * Gets the value of the m property.
     * 
     */
    public double getM() {
        return m;
    }

    /**
     * Sets the value of the m property.
     * 
     */
    public void setM(double value) {
        this.m = value;
    }

    /**
     * Gets the value of the n property.
     * 
     */
    public double getN() {
        return n;
    }

    /**
     * Sets the value of the n property.
     * 
     */
    public void setN(double value) {
        this.n = value;
    }

    /**
     * Gets the value of the tw1 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTW1() {
        return tw1;
    }

    /**
     * Sets the value of the tw1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTW1(TimePeriodXmlType value) {
        this.tw1 = value;
    }

    /**
     * Gets the value of the tw2 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTW2() {
        return tw2;
    }

    /**
     * Sets the value of the tw2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTW2(TimePeriodXmlType value) {
        this.tw2 = value;
    }

    /**
     * Gets the value of the t6 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT6() {
        return t6;
    }

    /**
     * Sets the value of the t6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT6(TimePeriodXmlType value) {
        this.t6 = value;
    }

    /**
     * Gets the value of the tw3 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTW3() {
        return tw3;
    }

    /**
     * Sets the value of the tw3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTW3(TimePeriodXmlType value) {
        this.tw3 = value;
    }

    /**
     * Gets the value of the tw4 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTW4() {
        return tw4;
    }

    /**
     * Sets the value of the tw4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTW4(TimePeriodXmlType value) {
        this.tw4 = value;
    }

    /**
     * Gets the value of the t7 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT7() {
        return t7;
    }

    /**
     * Sets the value of the t7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT7(TimePeriodXmlType value) {
        this.t7 = value;
    }

    /**
     * Gets the value of the ks2 property.
     * 
     */
    public double getKS2() {
        return ks2;
    }

    /**
     * Sets the value of the ks2 property.
     * 
     */
    public void setKS2(double value) {
        this.ks2 = value;
    }

    /**
     * Gets the value of the ks3 property.
     * 
     */
    public double getKS3() {
        return ks3;
    }

    /**
     * Sets the value of the ks3 property.
     * 
     */
    public void setKS3(double value) {
        this.ks3 = value;
    }

    /**
     * Gets the value of the t8 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT8() {
        return t8;
    }

    /**
     * Sets the value of the t8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT8(TimePeriodXmlType value) {
        this.t8 = value;
    }

    /**
     * Gets the value of the t9 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT9() {
        return t9;
    }

    /**
     * Sets the value of the t9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT9(TimePeriodXmlType value) {
        this.t9 = value;
    }

    /**
     * Gets the value of the ks1 property.
     * 
     */
    public double getKS1() {
        return ks1;
    }

    /**
     * Sets the value of the ks1 property.
     * 
     */
    public void setKS1(double value) {
        this.ks1 = value;
    }

    /**
     * Gets the value of the t1 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT1() {
        return t1;
    }

    /**
     * Sets the value of the t1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT1(TimePeriodXmlType value) {
        this.t1 = value;
    }

    /**
     * Gets the value of the t2 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT2() {
        return t2;
    }

    /**
     * Sets the value of the t2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT2(TimePeriodXmlType value) {
        this.t2 = value;
    }

    /**
     * Gets the value of the t3 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT3() {
        return t3;
    }

    /**
     * Sets the value of the t3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT3(TimePeriodXmlType value) {
        this.t3 = value;
    }

    /**
     * Gets the value of the t4 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT4() {
        return t4;
    }

    /**
     * Sets the value of the t4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT4(TimePeriodXmlType value) {
        this.t4 = value;
    }

    /**
     * Gets the value of the vstmax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVSTMAX() {
        return vstmax;
    }

    /**
     * Sets the value of the vstmax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVSTMAX(String value) {
        this.vstmax = value;
    }

    /**
     * Gets the value of the vstmin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVSTMIN() {
        return vstmin;
    }

    /**
     * Sets the value of the vstmin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVSTMIN(String value) {
        this.vstmin = value;
    }

}
