//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.15 at 12:03:20 PM MSK 
//


package scl;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for tTapChanger complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tTapChanger">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.iec.ch/61850/2006/SCL}tPowerSystemResource">
 *       &lt;attGroup ref="{http://www.iec.ch/61850/2006/SCL}agVirtual"/>
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}Name" fixed="LTC" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTapChanger")
public class TTapChanger
    extends TPowerSystemResource
{

    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "Name")
    protected String type;
    @XmlAttribute(name = "virtual")
    protected Boolean virtual;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        if (type == null) {
            return "LTC";
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the virtual property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isVirtual() {
        if (virtual == null) {
            return false;
        } else {
            return virtual;
        }
    }

    /**
     * Sets the value of the virtual property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVirtual(Boolean value) {
        this.virtual = value;
    }

}
