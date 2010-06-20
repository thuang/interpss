//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.20 at 07:45:56 AM GMT-08:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for LineRelayEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LineRelayEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TIOCR1"/>
 *     &lt;enumeration value="DistanceRelay"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum LineRelayEnumType {

    @XmlEnumValue("TIOCR1")
    TIOCR_1("TIOCR1"),
    @XmlEnumValue("DistanceRelay")
    DISTANCE_RELAY("DistanceRelay");
    private final String value;

    LineRelayEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LineRelayEnumType fromValue(String v) {
        for (LineRelayEnumType c: LineRelayEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
