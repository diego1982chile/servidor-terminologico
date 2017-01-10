
package cl.minsal.semantikos.ws.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buscarTruncatePerfectResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buscarTruncatePerfectResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://service.ws.semantikos.minsal.cl/}respuestaBuscarTermino" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarTruncatePerfectResponse", propOrder = {
    "respuestaBuscarTermino"
})
public class BuscarTruncatePerfectResponse {

    @XmlElement(namespace = "http://service.ws.semantikos.minsal.cl/")
    protected RespuestaBuscarTermino respuestaBuscarTermino;

    /**
     * Gets the value of the respuestaBuscarTermino property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaBuscarTermino }
     *     
     */
    public RespuestaBuscarTermino getRespuestaBuscarTermino() {
        return respuestaBuscarTermino;
    }

    /**
     * Sets the value of the respuestaBuscarTermino property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaBuscarTermino }
     *     
     */
    public void setRespuestaBuscarTermino(RespuestaBuscarTermino value) {
        this.respuestaBuscarTermino = value;
    }

}
