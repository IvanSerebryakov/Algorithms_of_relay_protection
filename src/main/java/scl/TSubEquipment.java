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
 * <p>Java class for tSubEquipment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tSubEquipment">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.iec.ch/61850/2006/SCL}tPowerSystemResource">
 *       &lt;attGroup ref="{http://www.iec.ch/61850/2006/SCL}agVirtual"/>
 *       &lt;attribute name="phase" type="{http://www.iec.ch/61850/2006/SCL}tPhaseEnum" default="none" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSubEquipment")
public class TSubEquipment
    extends TPowerSystemResource
{

    @XmlAttribute(name = "phase")
    protected TPhaseEnum phase;
    @XmlAttribute(name = "virtual")
    protected Boolean virtual;

    /**
     * Gets the value of the phase property.
     * 
     * @return
     *     possible object is
     *     {@link TPhaseEnum }
     *     
     */
    public TPhaseEnum getPhase() {
        if (phase == null) {
            return TPhaseEnum.NONE;
        } else {
            return phase;
        }
    }

    /**
     * Sets the value of the phase property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPhaseEnum }
     *     
     */
    public void setPhase(TPhaseEnum value) {
        this.phase = value;
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
