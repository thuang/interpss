//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.11 at 02:43:09 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for ODMSchemaVersionEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ODMSchemaVersionEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="V0.8.2"/>
 *     &lt;enumeration value="V0.8.1"/>
 *     &lt;enumeration value="V0.8"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ODMSchemaVersionEnumType {

    @XmlEnumValue("V0.8.2")
    V_0_8_2("V0.8.2"),
    @XmlEnumValue("V0.8.1")
    V_0_8_1("V0.8.1"),
    @XmlEnumValue("V0.8")
    V_0_8("V0.8");
    private final String value;

    ODMSchemaVersionEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ODMSchemaVersionEnumType fromValue(String v) {
        for (ODMSchemaVersionEnumType c: ODMSchemaVersionEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
