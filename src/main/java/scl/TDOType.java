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
 * <p>Java class for tDOType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDOType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.iec.ch/61850/2006/SCL}tIDNaming">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="SDO" type="{http://www.iec.ch/61850/2006/SCL}tSDO"/>
 *         &lt;element name="DA" type="{http://www.iec.ch/61850/2006/SCL}tDA"/>
 *       &lt;/choice>
 *       &lt;attribute name="iedType" type="{http://www.iec.ch/61850/2006/SCL}tAnyName" default="" />
 *       &lt;attribute name="cdc" use="required" type="{http://www.iec.ch/61850/2006/SCL}tCDCEnum" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDOType", propOrder = {
    "sdoOrDA"
})
public class TDOType
    extends TIDNaming
{

    @XmlElements({
        @XmlElement(name = "SDO", type = TSDO.class),
        @XmlElement(name = "DA", type = TDA.class)
    })
    protected List<TBaseElement> sdoOrDA;
    @XmlAttribute(name = "iedType")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String iedType;
    @XmlAttribute(name = "cdc", required = true)
    protected String cdc;

    /**
     * Gets the value of the sdoOrDA property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sdoOrDA property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSDOOrDA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TSDO }
     * {@link TDA }
     * 
     * 
     */
    public List<TBaseElement> getSDOOrDA() {
        if (sdoOrDA == null) {
            sdoOrDA = new ArrayList<TBaseElement>();
        }
        return this.sdoOrDA;
    }

    /**
     * Gets the value of the iedType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIedType() {
        if (iedType == null) {
            return "";
        } else {
            return iedType;
        }
    }

    /**
     * Sets the value of the iedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIedType(String value) {
        this.iedType = value;
    }

    /**
     * Gets the value of the cdc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdc() {
        return cdc;
    }

    /**
     * Sets the value of the cdc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdc(String value) {
        this.cdc = value;
    }

}
