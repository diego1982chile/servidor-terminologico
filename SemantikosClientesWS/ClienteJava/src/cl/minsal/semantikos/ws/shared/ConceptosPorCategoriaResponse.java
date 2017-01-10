
package cl.minsal.semantikos.ws.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for conceptosPorCategoriaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="conceptosPorCategoriaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://service.ws.semantikos.minsal.cl/}respuestaConceptosPorCategoria" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conceptosPorCategoriaResponse", propOrder = {
    "respuestaConceptosPorCategoria"
})
public class ConceptosPorCategoriaResponse {

    @XmlElement(namespace = "http://service.ws.semantikos.minsal.cl/")
    protected RespuestaConceptosPorCategoria respuestaConceptosPorCategoria;

    /**
     * Gets the value of the respuestaConceptosPorCategoria property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaConceptosPorCategoria }
     *     
     */
    public RespuestaConceptosPorCategoria getRespuestaConceptosPorCategoria() {
        return respuestaConceptosPorCategoria;
    }

    /**
     * Sets the value of the respuestaConceptosPorCategoria property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaConceptosPorCategoria }
     *     
     */
    public void setRespuestaConceptosPorCategoria(RespuestaConceptosPorCategoria value) {
        this.respuestaConceptosPorCategoria = value;
    }

}
