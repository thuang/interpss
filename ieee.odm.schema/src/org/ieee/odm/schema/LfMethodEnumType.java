//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.13 at 10:08:41 ���� CST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for LfMethodEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LfMethodEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NR"/>
 *     &lt;enumeration value="PQ"/>
 *     &lt;enumeration value="GS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum LfMethodEnumType {

    GS,
    NR,
    PQ;

    public String value() {
        return name();
    }

    public static LfMethodEnumType fromValue(String v) {
        return valueOf(v);
    }

}
