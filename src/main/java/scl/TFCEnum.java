//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.15 at 12:03:20 PM MSK 
//


package scl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tFCEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tFCEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *     &lt;enumeration value="ST"/>
 *     &lt;enumeration value="MX"/>
 *     &lt;enumeration value="CO"/>
 *     &lt;enumeration value="SP"/>
 *     &lt;enumeration value="SG"/>
 *     &lt;enumeration value="SE"/>
 *     &lt;enumeration value="SV"/>
 *     &lt;enumeration value="CF"/>
 *     &lt;enumeration value="DC"/>
 *     &lt;enumeration value="EX"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tFCEnum")
@XmlEnum
public enum TFCEnum {

    ST,
    MX,
    CO,
    SP,
    SG,
    SE,
    SV,
    CF,
    DC,
    EX;

    public String value() {
        return name();
    }

    public static TFCEnum fromValue(String v) {
        return valueOf(v);
    }

}
