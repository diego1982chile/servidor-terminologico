
package cl.minsal.semantikos.ws.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for crossMapsIndirectosPorDescripcionIDorConceptID complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="crossMapsIndirectosPorDescripcionIDorConceptID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descripcionIDorConceptIDRequest" type="{http://service.ws.semantikos.minsal.cl/}descriptionIDorConceptIDRequest"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crossMapsIndirectosPorDescripcionIDorConceptID", propOrder = {
    "descripcionIDorConceptIDRequest"
})
public class CrossMapsIndirectosPorDescripcionIDorConceptID {

    @XmlElement(required = true)
    protected DescriptionIDorConceptIDRequest descripcionIDorConceptIDRequest;

    /**
     * Gets the value of the descripcionIDorConceptIDRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionIDorConceptIDRequest }
     *     
     */
    public DescriptionIDorConceptIDRequest getDescripcionIDorConceptIDRequest() {
        return descripcionIDorConceptIDRequest;
    }

    /**
     * Sets the value of the descripcionIDorConceptIDRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionIDorConceptIDRequest }
     *     
     */
    public void setDescripcionIDorConceptIDRequest(DescriptionIDorConceptIDRequest value) {
        this.descripcionIDorConceptIDRequest = value;
    }

}
