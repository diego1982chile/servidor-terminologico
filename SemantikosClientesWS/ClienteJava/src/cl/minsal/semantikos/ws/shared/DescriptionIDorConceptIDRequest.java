
package cl.minsal.semantikos.ws.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for descriptionIDorConceptIDRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="descriptionIDorConceptIDRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="concept_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stablishment_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "descriptionIDorConceptIDRequest", propOrder = {
    "descriptionId",
    "conceptId",
    "stablishmentId"
})
public class DescriptionIDorConceptIDRequest {

    @XmlElement(name = "description_id", required = true)
    protected String descriptionId;
    @XmlElement(name = "concept_id", required = true)
    protected String conceptId;
    @XmlElement(name = "stablishment_id", required = true)
    protected String stablishmentId;

    /**
     * Gets the value of the descriptionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescriptionId() {
        return descriptionId;
    }

    /**
     * Sets the value of the descriptionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescriptionId(String value) {
        this.descriptionId = value;
    }

    /**
     * Gets the value of the conceptId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConceptId() {
        return conceptId;
    }

    /**
     * Sets the value of the conceptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConceptId(String value) {
        this.conceptId = value;
    }

    /**
     * Gets the value of the stablishmentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStablishmentId() {
        return stablishmentId;
    }

    /**
     * Sets the value of the stablishmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStablishmentId(String value) {
        this.stablishmentId = value;
    }

}
