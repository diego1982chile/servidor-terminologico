
package cl.minsal.semantikos.ws.shared;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PeticionRefSetsPorIdDescripcion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeticionRefSetsPorIdDescripcion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idDescripcion" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="incluyeEstablecimientos" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeticionRefSetsPorIdDescripcion", propOrder = {
    "idDescripcion",
    "incluyeEstablecimientos"
})
public class PeticionRefSetsPorIdDescripcion {

    @XmlElement(required = true)
    protected List<String> idDescripcion;
    @XmlElement(defaultValue = "true")
    protected Boolean incluyeEstablecimientos;

    /**
     * Gets the value of the idDescripcion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idDescripcion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdDescripcion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIdDescripcion() {
        if (idDescripcion == null) {
            idDescripcion = new ArrayList<String>();
        }
        return this.idDescripcion;
    }

    /**
     * Gets the value of the incluyeEstablecimientos property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncluyeEstablecimientos() {
        return incluyeEstablecimientos;
    }

    /**
     * Sets the value of the incluyeEstablecimientos property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncluyeEstablecimientos(Boolean value) {
        this.incluyeEstablecimientos = value;
    }

}
