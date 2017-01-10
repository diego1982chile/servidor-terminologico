
package cl.minsal.semantikos.ws.shared;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RespuestaConceptosPorCategoria complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RespuestaConceptosPorCategoria">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://service.ws.semantikos.minsal.cl/}categoria" minOccurs="0"/>
 *         &lt;element ref="{http://service.ws.semantikos.minsal.cl/}paginacion" minOccurs="0"/>
 *         &lt;element name="conceptos" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://service.ws.semantikos.minsal.cl/}concepto" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaConceptosPorCategoria", propOrder = {
    "categoria",
    "paginacion",
    "conceptos"
})
public class RespuestaConceptosPorCategoria {

    @XmlElement(namespace = "http://service.ws.semantikos.minsal.cl/")
    protected Categoria categoria;
    @XmlElement(namespace = "http://service.ws.semantikos.minsal.cl/")
    protected Paginacion paginacion;
    protected RespuestaConceptosPorCategoria.Conceptos conceptos;

    /**
     * Gets the value of the categoria property.
     * 
     * @return
     *     possible object is
     *     {@link Categoria }
     *     
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Sets the value of the categoria property.
     * 
     * @param value
     *     allowed object is
     *     {@link Categoria }
     *     
     */
    public void setCategoria(Categoria value) {
        this.categoria = value;
    }

    /**
     * Gets the value of the paginacion property.
     * 
     * @return
     *     possible object is
     *     {@link Paginacion }
     *     
     */
    public Paginacion getPaginacion() {
        return paginacion;
    }

    /**
     * Sets the value of the paginacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Paginacion }
     *     
     */
    public void setPaginacion(Paginacion value) {
        this.paginacion = value;
    }

    /**
     * Gets the value of the conceptos property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaConceptosPorCategoria.Conceptos }
     *     
     */
    public RespuestaConceptosPorCategoria.Conceptos getConceptos() {
        return conceptos;
    }

    /**
     * Sets the value of the conceptos property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaConceptosPorCategoria.Conceptos }
     *     
     */
    public void setConceptos(RespuestaConceptosPorCategoria.Conceptos value) {
        this.conceptos = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{http://service.ws.semantikos.minsal.cl/}concepto" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "concepto"
    })
    public static class Conceptos {

        @XmlElement(namespace = "http://service.ws.semantikos.minsal.cl/")
        protected List<Concepto> concepto;

        /**
         * Gets the value of the concepto property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the concepto property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getConcepto().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Concepto }
         * 
         * 
         */
        public List<Concepto> getConcepto() {
            if (concepto == null) {
                concepto = new ArrayList<Concepto>();
            }
            return this.concepto;
        }

    }

}
