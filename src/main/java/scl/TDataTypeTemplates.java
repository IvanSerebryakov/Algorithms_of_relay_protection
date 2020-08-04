//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.15 at 12:03:20 PM MSK 
//


package scl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for tDataTypeTemplates complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDataTypeTemplates">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LNodeType" type="{http://www.iec.ch/61850/2006/SCL}tLNodeType" maxOccurs="unbounded"/>
 *         &lt;element name="DOType" type="{http://www.iec.ch/61850/2006/SCL}tDOType" maxOccurs="unbounded"/>
 *         &lt;element name="DAType" type="{http://www.iec.ch/61850/2006/SCL}tDAType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EnumType" type="{http://www.iec.ch/61850/2006/SCL}tEnumType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDataTypeTemplates", propOrder = {
    "lNodeType",
    "doType",
    "daType",
    "enumType"
})
public class TDataTypeTemplates {

    @XmlElement(name = "LNodeType", required = true)
    protected List<TLNodeType> lNodeType;
    @XmlElement(name = "DOType", required = true)
    protected List<TDOType> doType;
    @XmlElement(name = "DAType")
    protected List<TDAType> daType;
    @XmlElement(name = "EnumType")
    protected List<TEnumType> enumType;

    /**
     * Gets the value of the lNodeType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lNodeType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLNodeType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TLNodeType }
     * 
     * 
     */
    public List<TLNodeType> getLNodeType() {
        if (lNodeType == null) {
            lNodeType = new ArrayList<TLNodeType>();
        }
        return this.lNodeType;
    }

    /**
     * Gets the value of the doType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the doType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDOType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDOType }
     * 
     * 
     */
    public List<TDOType> getDOType() {
        if (doType == null) {
            doType = new ArrayList<TDOType>();
        }
        return this.doType;
    }

    /**
     * Gets the value of the daType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the daType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDAType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDAType }
     * 
     * 
     */
    public List<TDAType> getDAType() {
        if (daType == null) {
            daType = new ArrayList<TDAType>();
        }
        return this.daType;
    }

    /**
     * Gets the value of the enumType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enumType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnumType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TEnumType }
     * 
     * 
     */
    public List<TEnumType> getEnumType() {
        if (enumType == null) {
            enumType = new ArrayList<TEnumType>();
        }
        return this.enumType;
    }

}