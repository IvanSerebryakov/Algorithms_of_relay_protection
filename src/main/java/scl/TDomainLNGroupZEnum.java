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
 * <p>Java class for tDomainLNGroupZEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tDomainLNGroupZEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *     &lt;pattern value="Z[A-Z]*"/>
 *     &lt;enumeration value="ZAXN"/>
 *     &lt;enumeration value="ZBAT"/>
 *     &lt;enumeration value="ZBSH"/>
 *     &lt;enumeration value="ZCAB"/>
 *     &lt;enumeration value="ZCAP"/>
 *     &lt;enumeration value="ZCON"/>
 *     &lt;enumeration value="ZGEN"/>
 *     &lt;enumeration value="ZGIL"/>
 *     &lt;enumeration value="ZLIN"/>
 *     &lt;enumeration value="ZMOT"/>
 *     &lt;enumeration value="ZREA"/>
 *     &lt;enumeration value="ZRRC"/>
 *     &lt;enumeration value="ZSAR"/>
 *     &lt;enumeration value="ZTCF"/>
 *     &lt;enumeration value="ZTCR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tDomainLNGroupZEnum")
@XmlEnum
public enum TDomainLNGroupZEnum {

    ZAXN,
    ZBAT,
    ZBSH,
    ZCAB,
    ZCAP,
    ZCON,
    ZGEN,
    ZGIL,
    ZLIN,
    ZMOT,
    ZREA,
    ZRRC,
    ZSAR,
    ZTCF,
    ZTCR;

    public String value() {
        return name();
    }

    public static TDomainLNGroupZEnum fromValue(String v) {
        return valueOf(v);
    }

}
