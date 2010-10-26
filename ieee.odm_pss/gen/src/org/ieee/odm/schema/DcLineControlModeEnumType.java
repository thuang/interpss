//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.25 at 11:53:57 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for DcLineControlModeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DcLineControlModeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="blocked"/>
 *     &lt;enumeration value="power"/>
 *     &lt;enumeration value="current"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum DcLineControlModeEnumType {

    @XmlEnumValue("blocked")
    BLOCKED("blocked"),
    @XmlEnumValue("power")
    POWER("power"),
    @XmlEnumValue("current")
    CURRENT("current");
    private final String value;

    DcLineControlModeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DcLineControlModeEnumType fromValue(String v) {
        for (DcLineControlModeEnumType c: DcLineControlModeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
