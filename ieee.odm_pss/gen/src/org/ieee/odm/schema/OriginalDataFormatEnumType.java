//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.05.03 at 08:21:20 PM PDT 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for OriginalDataFormatEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OriginalDataFormatEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IEEE-CDF"/>
 *     &lt;enumeration value="PSS-E"/>
 *     &lt;enumeration value="UCTE-DEF"/>
 *     &lt;enumeration value="InterPSS"/>
 *     &lt;enumeration value="PSAT"/>
 *     &lt;enumeration value="IEEE-ODM-PSS"/>
 *     &lt;enumeration value="BPA"/>
 *     &lt;enumeration value="GE-PSLF"/>
 *     &lt;enumeration value="Cim"/>
 *     &lt;enumeration value="Custom"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum OriginalDataFormatEnumType {

    @XmlEnumValue("IEEE-CDF")
    IEEE_CDF("IEEE-CDF"),
    @XmlEnumValue("PSS-E")
    PSS_E("PSS-E"),
    @XmlEnumValue("UCTE-DEF")
    UCTE_DEF("UCTE-DEF"),
    @XmlEnumValue("InterPSS")
    INTER_PSS("InterPSS"),
    PSAT("PSAT"),
    @XmlEnumValue("IEEE-ODM-PSS")
    IEEE_ODM_PSS("IEEE-ODM-PSS"),
    BPA("BPA"),
    @XmlEnumValue("GE-PSLF")
    GE_PSLF("GE-PSLF"),
    @XmlEnumValue("Cim")
    CIM("Cim"),
    @XmlEnumValue("Custom")
    CUSTOM("Custom");
    private final String value;

    OriginalDataFormatEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OriginalDataFormatEnumType fromValue(String v) {
        for (OriginalDataFormatEnumType c: OriginalDataFormatEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
