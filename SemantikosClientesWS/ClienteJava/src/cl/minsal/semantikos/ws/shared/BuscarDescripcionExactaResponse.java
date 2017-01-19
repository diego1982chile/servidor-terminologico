
package cl.minsal.semantikos.ws.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buscarDescripcionExactaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buscarDescripcionExactaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="respuestaBuscarTermino" type="{http://service.ws.semantikos.minsal.cl/}RespuestaDescripciones" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarDescripcionExactaResponse", propOrder = {
    "respuestaBuscarTermino"
})
public class BuscarDescripcionExactaResponse {

    protected RespuestaDescripciones respuestaBuscarTermino;

    /**
     * Gets the value of the respuestaBuscarTermino property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaDescripciones }
     *     
     */
    public RespuestaDescripciones getRespuestaBuscarTermino() {
        return respuestaBuscarTermino;
    }

    /**
     * Sets the value of the respuestaBuscarTermino property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaDescripciones }
     *     
     */
    public void setRespuestaBuscarTermino(RespuestaDescripciones value) {
        this.respuestaBuscarTermino = value;
    }

}
