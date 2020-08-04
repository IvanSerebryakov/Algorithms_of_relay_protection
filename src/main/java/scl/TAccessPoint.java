//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.15 at 12:03:20 PM MSK 
//


package scl;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for tAccessPoint complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tAccessPoint">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.iec.ch/61850/2006/SCL}tNaming">
 *       &lt;choice minOccurs="0">
 *         &lt;element name="Server" type="{http://www.iec.ch/61850/2006/SCL}tServer"/>
 *         &lt;element ref="{http://www.iec.ch/61850/2006/SCL}LN" maxOccurs="unbounded"/>
 *       &lt;/choice>
 *       &lt;attribute name="router" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="clock" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tAccessPoint", propOrder = {
    "server",
    "ln"
})
public class TAccessPoint
    extends TNaming
{

    @XmlElement(name = "Server")
    protected TServer server;
    @XmlElement(name = "LN")
    protected List<TLN> ln;
    @XmlAttribute(name = "router")
    protected Boolean router;
    @XmlAttribute(name = "clock")
    protected Boolean clock;

    /**
     * Gets the value of the server property.
     * 
     * @return
     *     possible object is
     *     {@link TServer }
     *     
     */
    public TServer getServer() {
        return server;
    }

    /**
     * Sets the value of the server property.
     * 
     * @param value
     *     allowed object is
     *     {@link TServer }
     *     
     */
    public void setServer(TServer value) {
        this.server = value;
    }

    /**
     * Gets the value of the ln property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ln property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLN().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TLN }
     * 
     * 
     */
    public List<TLN> getLN() {
        if (ln == null) {
            ln = new ArrayList<TLN>();
        }
        return this.ln;
    }

    /**
     * Gets the value of the router property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isRouter() {
        if (router == null) {
            return false;
        } else {
            return router;
        }
    }

    /**
     * Sets the value of the router property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRouter(Boolean value) {
        this.router = value;
    }

    /**
     * Gets the value of the clock property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isClock() {
        if (clock == null) {
            return false;
        } else {
            return clock;
        }
    }

    /**
     * Sets the value of the clock property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setClock(Boolean value) {
        this.clock = value;
    }

}
