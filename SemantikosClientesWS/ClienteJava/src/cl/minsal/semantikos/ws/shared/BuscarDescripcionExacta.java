
package cl.minsal.semantikos.ws.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buscarDescripcionExacta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buscarDescripcionExacta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="peticionPatron" type="{http://service.ws.semantikos.minsal.cl/}PatronDeBusqueda"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarDescripcionExacta", propOrder = {
    "peticionPatron"
})
public class BuscarDescripcionExacta {

    @XmlElement(required = true)
    protected PatronDeBusqueda peticionPatron;

    /**
     * Gets the value of the peticionPatron property.
     * 
     * @return
     *     possible object is
     *     {@link PatronDeBusqueda }
     *     
     */
    public PatronDeBusqueda getPeticionPatron() {
        return peticionPatron;
    }

    /**
     * Sets the value of the peticionPatron property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatronDeBusqueda }
     *     
     */
    public void setPeticionPatron(PatronDeBusqueda value) {
        this.peticionPatron = value;
    }

}
