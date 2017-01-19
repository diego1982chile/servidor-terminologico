
package cl.minsal.semantikos.ws.shared;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RespuestaDescripciones complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RespuestaDescripciones">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descripcion" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="descripciones" type="{http://service.ws.semantikos.minsal.cl/}Descripcion" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="cantidadRegistros" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaDescripciones", propOrder = {
    "descripcion",
    "cantidadRegistros"
})
public class RespuestaDescripciones {

    protected RespuestaDescripciones.Descripcion descripcion;
    protected int cantidadRegistros;

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaDescripciones.Descripcion }
     *     
     */
    public RespuestaDescripciones.Descripcion getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaDescripciones.Descripcion }
     *     
     */
    public void setDescripcion(RespuestaDescripciones.Descripcion value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the cantidadRegistros property.
     * 
     */
    public int getCantidadRegistros() {
        return cantidadRegistros;
    }

    /**
     * Sets the value of the cantidadRegistros property.
     * 
     */
    public void setCantidadRegistros(int value) {
        this.cantidadRegistros = value;
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
     *         &lt;element name="descripciones" type="{http://service.ws.semantikos.minsal.cl/}Descripcion" maxOccurs="unbounded" minOccurs="0"/>
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
        "descripciones"
    })
    public static class Descripcion {

        protected List<cl.minsal.semantikos.ws.shared.Descripcion> descripciones;

        /**
         * Gets the value of the descripciones property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the descripciones property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDescripciones().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link cl.minsal.semantikos.ws.shared.Descripcion }
         * 
         * 
         */
        public List<cl.minsal.semantikos.ws.shared.Descripcion> getDescripciones() {
            if (descripciones == null) {
                descripciones = new ArrayList<cl.minsal.semantikos.ws.shared.Descripcion>();
            }
            return this.descripciones;
        }

    }

}
