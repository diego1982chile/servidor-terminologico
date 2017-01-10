
package cl.minsal.semantikos.ws.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PeticionConceptosPorRefSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeticionConceptosPorRefSet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombreRefSet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numeroPagina" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tamanoPagina" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeticionConceptosPorRefSet", propOrder = {
    "nombreRefSet",
    "numeroPagina",
    "tamanoPagina"
})
public class PeticionConceptosPorRefSet {

    @XmlElement(required = true)
    protected String nombreRefSet;
    @XmlElement(defaultValue = "0")
    protected Integer numeroPagina;
    @XmlElement(defaultValue = "10")
    protected Integer tamanoPagina;

    /**
     * Gets the value of the nombreRefSet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreRefSet() {
        return nombreRefSet;
    }

    /**
     * Sets the value of the nombreRefSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreRefSet(String value) {
        this.nombreRefSet = value;
    }

    /**
     * Gets the value of the numeroPagina property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroPagina() {
        return numeroPagina;
    }

    /**
     * Sets the value of the numeroPagina property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroPagina(Integer value) {
        this.numeroPagina = value;
    }

    /**
     * Gets the value of the tamanoPagina property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTamanoPagina() {
        return tamanoPagina;
    }

    /**
     * Sets the value of the tamanoPagina property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTamanoPagina(Integer value) {
        this.tamanoPagina = value;
    }

}
