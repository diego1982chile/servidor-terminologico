
package cl.minsal.semantikos.ws.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for refSetsPorIdDescripcionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="refSetsPorIdDescripcionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="refset" type="{http://service.ws.semantikos.minsal.cl/}RespuestaRefSets" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "refSetsPorIdDescripcionResponse", propOrder = {
    "refset"
})
public class RefSetsPorIdDescripcionResponse {

    protected RespuestaRefSets refset;

    /**
     * Gets the value of the refset property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaRefSets }
     *     
     */
    public RespuestaRefSets getRefset() {
        return refset;
    }

    /**
     * Sets the value of the refset property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaRefSets }
     *     
     */
    public void setRefset(RespuestaRefSets value) {
        this.refset = value;
    }

}
