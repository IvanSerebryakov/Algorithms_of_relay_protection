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
 * <p>Java class for tDomainLNGroupREnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tDomainLNGroupREnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *     &lt;pattern value="R[A-Z]*"/>
 *     &lt;enumeration value="RSYN"/>
 *     &lt;enumeration value="RDRE"/>
 *     &lt;enumeration value="RADR"/>
 *     &lt;enumeration value="RBDR"/>
 *     &lt;enumeration value="RDRS"/>
 *     &lt;enumeration value="RBRF"/>
 *     &lt;enumeration value="RDIR"/>
 *     &lt;enumeration value="RFLO"/>
 *     &lt;enumeration value="RPSB"/>
 *     &lt;enumeration value="RREC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tDomainLNGroupREnum")
@XmlEnum
public enum TDomainLNGroupREnum {

    RSYN,
    RDRE,
    RADR,
    RBDR,
    RDRS,
    RBRF,
    RDIR,
    RFLO,
    RPSB,
    RREC;

    public String value() {
        return name();
    }

    public static TDomainLNGroupREnum fromValue(String v) {
        return valueOf(v);
    }

}
