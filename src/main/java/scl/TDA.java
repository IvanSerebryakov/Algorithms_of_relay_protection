//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.15 at 12:03:20 PM MSK 
//


package scl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tDA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDA">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.iec.ch/61850/2006/SCL}tAbstractDataAttribute">
 *       &lt;attGroup ref="{http://www.iec.ch/61850/2006/SCL}agDATrgOp"/>
 *       &lt;attribute name="fc" use="required" type="{http://www.iec.ch/61850/2006/SCL}tFCEnum" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDA")
public class TDA
    extends TAbstractDataAttribute
{

    @XmlAttribute(name = "fc", required = true)
    protected TFCEnum fc;
    @XmlAttribute(name = "dchg")
    protected Boolean dchg;
    @XmlAttribute(name = "qchg")
    protected Boolean qchg;
    @XmlAttribute(name = "dupd")
    protected Boolean dupd;

    /**
     * Gets the value of the fc property.
     * 
     * @return
     *     possible object is
     *     {@link TFCEnum }
     *     
     */
    public TFCEnum getFc() {
        return fc;
    }

    /**
     * Sets the value of the fc property.
     * 
     * @param value
     *     allowed object is
     *     {@link TFCEnum }
     *     
     */
    public void setFc(TFCEnum value) {
        this.fc = value;
    }

    /**
     * Gets the value of the dchg property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDchg() {
        if (dchg == null) {
            return false;
        } else {
            return dchg;
        }
    }

    /**
     * Sets the value of the dchg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDchg(Boolean value) {
        this.dchg = value;
    }

    /**
     * Gets the value of the qchg property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isQchg() {
        if (qchg == null) {
            return false;
        } else {
            return qchg;
        }
    }

    /**
     * Sets the value of the qchg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setQchg(Boolean value) {
        this.qchg = value;
    }

    /**
     * Gets the value of the dupd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDupd() {
        if (dupd == null) {
            return false;
        } else {
            return dupd;
        }
    }

    /**
     * Sets the value of the dupd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDupd(Boolean value) {
        this.dupd = value;
    }

}
