//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.15 at 12:03:20 PM MSK 
//


package scl;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for tExtRef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tExtRef">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{http://www.iec.ch/61850/2006/SCL}agDORef"/>
 *       &lt;attribute name="daName" type="{http://www.iec.ch/61850/2006/SCL}tName" />
 *       &lt;attribute name="intAddr" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tExtRef")
public class TExtRef {

    @XmlAttribute(name = "daName")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String daName;
    @XmlAttribute(name = "intAddr")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String intAddr;
    @XmlAttribute(name = "doName", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String doName;
    @XmlAttribute(name = "prefix")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String prefix;
    @XmlAttribute(name = "lnClass", required = true)
    protected List<String> lnClass;
    @XmlAttribute(name = "lnInst", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String lnInst;
    @XmlAttribute(name = "iedName", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String iedName;
    @XmlAttribute(name = "ldInst", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String ldInst;

    /**
     * Gets the value of the daName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDaName() {
        return daName;
    }

    /**
     * Sets the value of the daName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDaName(String value) {
        this.daName = value;
    }

    /**
     * Gets the value of the intAddr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntAddr() {
        return intAddr;
    }

    /**
     * Sets the value of the intAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntAddr(String value) {
        this.intAddr = value;
    }

    /**
     * Gets the value of the doName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoName() {
        return doName;
    }

    /**
     * Sets the value of the doName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoName(String value) {
        this.doName = value;
    }

    /**
     * Gets the value of the prefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets the value of the prefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefix(String value) {
        this.prefix = value;
    }

    /**
     * Gets the value of the lnClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lnClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLnClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLnClass() {
        if (lnClass == null) {
            lnClass = new ArrayList<String>();
        }
        return this.lnClass;
    }

    /**
     * Gets the value of the lnInst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLnInst() {
        return lnInst;
    }

    /**
     * Sets the value of the lnInst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLnInst(String value) {
        this.lnInst = value;
    }

    /**
     * Gets the value of the iedName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIedName() {
        return iedName;
    }

    /**
     * Sets the value of the iedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIedName(String value) {
        this.iedName = value;
    }

    /**
     * Gets the value of the ldInst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLdInst() {
        return ldInst;
    }

    /**
     * Sets the value of the ldInst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLdInst(String value) {
        this.ldInst = value;
    }

}
