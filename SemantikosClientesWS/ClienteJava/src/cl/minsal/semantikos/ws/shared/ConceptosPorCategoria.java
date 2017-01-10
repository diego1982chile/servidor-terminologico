
package cl.minsal.semantikos.ws.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for conceptosPorCategoria complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="conceptosPorCategoria">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://service.ws.semantikos.minsal.cl/}peticionConceptosPorCategoria"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conceptosPorCategoria", propOrder = {
    "peticionConceptosPorCategoria"
})
public class ConceptosPorCategoria {

    @XmlElement(namespace = "http://service.ws.semantikos.minsal.cl/", required = true)
    protected PeticionConceptosPorCategoria peticionConceptosPorCategoria;

    /**
     * Gets the value of the peticionConceptosPorCategoria property.
     * 
     * @return
     *     possible object is
     *     {@link PeticionConceptosPorCategoria }
     *     
     */
    public PeticionConceptosPorCategoria getPeticionConceptosPorCategoria() {
        return peticionConceptosPorCategoria;
    }

    /**
     * Sets the value of the peticionConceptosPorCategoria property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeticionConceptosPorCategoria }
     *     
     */
    public void setPeticionConceptosPorCategoria(PeticionConceptosPorCategoria value) {
        this.peticionConceptosPorCategoria = value;
    }

}
