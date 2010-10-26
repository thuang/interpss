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
 * <p>Java class for AcscFaultCategoryEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AcscFaultCategoryEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fault3Phase"/>
 *     &lt;enumeration value="LineToLine"/>
 *     &lt;enumeration value="LineToGround"/>
 *     &lt;enumeration value="LineLineToGround"/>
 *     &lt;enumeration value="Outage_3Phase"/>
 *     &lt;enumeration value="Outage_1Phase"/>
 *     &lt;enumeration value="Outage_2Phase"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum AcscFaultCategoryEnumType {

    @XmlEnumValue("Fault3Phase")
    FAULT_3_PHASE("Fault3Phase"),
    @XmlEnumValue("LineToLine")
    LINE_TO_LINE("LineToLine"),
    @XmlEnumValue("LineToGround")
    LINE_TO_GROUND("LineToGround"),
    @XmlEnumValue("LineLineToGround")
    LINE_LINE_TO_GROUND("LineLineToGround"),
    @XmlEnumValue("Outage_3Phase")
    OUTAGE_3_PHASE("Outage_3Phase"),
    @XmlEnumValue("Outage_1Phase")
    OUTAGE_1_PHASE("Outage_1Phase"),
    @XmlEnumValue("Outage_2Phase")
    OUTAGE_2_PHASE("Outage_2Phase");
    private final String value;

    AcscFaultCategoryEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AcscFaultCategoryEnumType fromValue(String v) {
        for (AcscFaultCategoryEnumType c: AcscFaultCategoryEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
