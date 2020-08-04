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
 * <p>Java class for tConnectedAP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tConnectedAP">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.iec.ch/61850/2006/SCL}tUnNaming">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://www.iec.ch/61850/2006/SCL}tAddress" minOccurs="0"/>
 *         &lt;element name="GSE" type="{http://www.iec.ch/61850/2006/SCL}tGSE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SMV" type="{http://www.iec.ch/61850/2006/SCL}tSMV" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PhysConn" type="{http://www.iec.ch/61850/2006/SCL}tPhysConn" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="iedName" use="required" type="{http://www.iec.ch/61850/2006/SCL}tName" />
 *       &lt;attribute name="apName" use="required" type="{http://www.iec.ch/61850/2006/SCL}tName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tConnectedAP", propOrder = {
    "address",
    "gse",
    "smv",
    "physConn"
})
public class TConnectedAP
    extends TUnNaming
{

    @XmlElement(name = "Address")
    protected TAddress address;
    @XmlElement(name = "GSE")
    protected List<TGSE> gse;
    @XmlElement(name = "SMV")
    protected List<TSMV> smv;
    @XmlElement(name = "PhysConn")
    protected List<TPhysConn> physConn;
    @XmlAttribute(name = "iedName", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String iedName;
    @XmlAttribute(name = "apName", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String apName;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link TAddress }
     *     
     */
    public TAddress getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAddress }
     *     
     */
    public void setAddress(TAddress value) {
        this.address = value;
    }

    /**
     * Gets the value of the gse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGSE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TGSE }
     * 
     * 
     */
    public List<TGSE> getGSE() {
        if (gse == null) {
            gse = new ArrayList<TGSE>();
        }
        return this.gse;
    }

    /**
     * Gets the value of the smv property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the smv property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSMV().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TSMV }
     * 
     * 
     */
    public List<TSMV> getSMV() {
        if (smv == null) {
            smv = new ArrayList<TSMV>();
        }
        return this.smv;
    }

    /**
     * Gets the value of the physConn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the physConn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhysConn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TPhysConn }
     * 
     * 
     */
    public List<TPhysConn> getPhysConn() {
        if (physConn == null) {
            physConn = new ArrayList<TPhysConn>();
        }
        return this.physConn;
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
     * Gets the value of the apName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApName() {
        return apName;
    }

    /**
     * Sets the value of the apName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApName(String value) {
        this.apName = value;
    }

}
