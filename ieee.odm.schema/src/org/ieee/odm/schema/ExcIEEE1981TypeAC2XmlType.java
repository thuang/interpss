//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.13 at 10:08:41 ���� CST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExcIEEE1981TypeAC2XmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExcIEEE1981TypeAC2XmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}ExcSimpleTypeXmlType">
 *       &lt;sequence>
 *         &lt;element name="TR" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="TB" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="TC" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="VAMAX" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="VAMIN" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="KB" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TE" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="KL" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="KH" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="KF" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TF" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="KC" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="KD" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="KE" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="VLR" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExcIEEE1981TypeAC2XmlType", propOrder = {
    "tr",
    "tb",
    "tc",
    "vamax",
    "vamin",
    "kb",
    "te",
    "kl",
    "kh",
    "kf",
    "tf",
    "kc",
    "kd",
    "ke",
    "vlr"
})
public class ExcIEEE1981TypeAC2XmlType
    extends ExcSimpleTypeXmlType
{

    @XmlElement(name = "TR", namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TimePeriodXmlType tr;
    @XmlElement(name = "TB", namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TimePeriodXmlType tb;
    @XmlElement(name = "TC", namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TimePeriodXmlType tc;
    @XmlElement(name = "VAMAX", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double vamax;
    @XmlElement(name = "VAMIN", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double vamin;
    @XmlElement(name = "KB", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double kb;
    @XmlElement(name = "TE", namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TimePeriodXmlType te;
    @XmlElement(name = "KL", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double kl;
    @XmlElement(name = "KH", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double kh;
    @XmlElement(name = "KF", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double kf;
    @XmlElement(name = "TF", namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TimePeriodXmlType tf;
    @XmlElement(name = "KC", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double kc;
    @XmlElement(name = "KD", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double kd;
    @XmlElement(name = "KE", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double ke;
    @XmlElement(name = "VLR", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double vlr;

    /**
     * Gets the value of the tr property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTR() {
        return tr;
    }

    /**
     * Sets the value of the tr property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTR(TimePeriodXmlType value) {
        this.tr = value;
    }

    /**
     * Gets the value of the tb property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTB() {
        return tb;
    }

    /**
     * Sets the value of the tb property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTB(TimePeriodXmlType value) {
        this.tb = value;
    }

    /**
     * Gets the value of the tc property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTC() {
        return tc;
    }

    /**
     * Sets the value of the tc property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTC(TimePeriodXmlType value) {
        this.tc = value;
    }

    /**
     * Gets the value of the vamax property.
     * 
     */
    public double getVAMAX() {
        return vamax;
    }

    /**
     * Sets the value of the vamax property.
     * 
     */
    public void setVAMAX(double value) {
        this.vamax = value;
    }

    /**
     * Gets the value of the vamin property.
     * 
     */
    public double getVAMIN() {
        return vamin;
    }

    /**
     * Sets the value of the vamin property.
     * 
     */
    public void setVAMIN(double value) {
        this.vamin = value;
    }

    /**
     * Gets the value of the kb property.
     * 
     */
    public double getKB() {
        return kb;
    }

    /**
     * Sets the value of the kb property.
     * 
     */
    public void setKB(double value) {
        this.kb = value;
    }

    /**
     * Gets the value of the te property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTE() {
        return te;
    }

    /**
     * Sets the value of the te property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTE(TimePeriodXmlType value) {
        this.te = value;
    }

    /**
     * Gets the value of the kl property.
     * 
     */
    public double getKL() {
        return kl;
    }

    /**
     * Sets the value of the kl property.
     * 
     */
    public void setKL(double value) {
        this.kl = value;
    }

    /**
     * Gets the value of the kh property.
     * 
     */
    public double getKH() {
        return kh;
    }

    /**
     * Sets the value of the kh property.
     * 
     */
    public void setKH(double value) {
        this.kh = value;
    }

    /**
     * Gets the value of the kf property.
     * 
     */
    public double getKF() {
        return kf;
    }

    /**
     * Sets the value of the kf property.
     * 
     */
    public void setKF(double value) {
        this.kf = value;
    }

    /**
     * Gets the value of the tf property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTF() {
        return tf;
    }

    /**
     * Sets the value of the tf property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTF(TimePeriodXmlType value) {
        this.tf = value;
    }

    /**
     * Gets the value of the kc property.
     * 
     */
    public double getKC() {
        return kc;
    }

    /**
     * Sets the value of the kc property.
     * 
     */
    public void setKC(double value) {
        this.kc = value;
    }

    /**
     * Gets the value of the kd property.
     * 
     */
    public double getKD() {
        return kd;
    }

    /**
     * Sets the value of the kd property.
     * 
     */
    public void setKD(double value) {
        this.kd = value;
    }

    /**
     * Gets the value of the ke property.
     * 
     */
    public double getKE() {
        return ke;
    }

    /**
     * Sets the value of the ke property.
     * 
     */
    public void setKE(double value) {
        this.ke = value;
    }

    /**
     * Gets the value of the vlr property.
     * 
     */
    public double getVLR() {
        return vlr;
    }

    /**
     * Sets the value of the vlr property.
     * 
     */
    public void setVLR(double value) {
        this.vlr = value;
    }

}
