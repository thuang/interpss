//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.22 at 06:40:06 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for XfrZeroSeqConnectLocationEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="XfrZeroSeqConnectLocationEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AtBus1"/>
 *     &lt;enumeration value="AtBus2"/>
 *     &lt;enumeration value="BetweenBus1nBus2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum XfrZeroSeqConnectLocationEnumType {

    @XmlEnumValue("AtBus1")
    AT_BUS_1("AtBus1"),
    @XmlEnumValue("AtBus2")
    AT_BUS_2("AtBus2"),
    @XmlEnumValue("BetweenBus1nBus2")
    BETWEEN_BUS_1_N_BUS_2("BetweenBus1nBus2");
    private final String value;

    XfrZeroSeqConnectLocationEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static XfrZeroSeqConnectLocationEnumType fromValue(String v) {
        for (XfrZeroSeqConnectLocationEnumType c: XfrZeroSeqConnectLocationEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
