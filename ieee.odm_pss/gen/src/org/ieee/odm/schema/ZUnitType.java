//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.21 at 12:23:41 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for ZUnitType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ZUnitType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PU"/>
 *     &lt;enumeration value="OHM"/>
 *     &lt;enumeration value="Percent"/>
 *     &lt;enumeration value="OHMPerMile"/>
 *     &lt;enumeration value="OHMPerFt"/>
 *     &lt;enumeration value="OHMPerKM"/>
 *     &lt;enumeration value="OHMPerM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ZUnitType {

    PU("PU"),
    OHM("OHM"),
    @XmlEnumValue("Percent")
    PERCENT("Percent"),
    @XmlEnumValue("OHMPerMile")
    OHM_PER_MILE("OHMPerMile"),
    @XmlEnumValue("OHMPerFt")
    OHM_PER_FT("OHMPerFt"),
    @XmlEnumValue("OHMPerKM")
    OHM_PER_KM("OHMPerKM"),
    @XmlEnumValue("OHMPerM")
    OHM_PER_M("OHMPerM");
    private final String value;

    ZUnitType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ZUnitType fromValue(String v) {
        for (ZUnitType c: ZUnitType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
