package cl.minsal.semantikos.ws.response;

import cl.minsal.semantikos.model.Description;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa una respuesta XML con una lista de descripciones.
 *
 * @author Andrés Farías on 2017-01-18.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "respuestaDescripciones", namespace = "http://service.ws.semantikos.minsal.cl/")
@XmlType(name = "RespuestaDescripciones", namespace = "http://service.ws.semantikos.minsal.cl/")
public class DescriptionsResponse implements Serializable {

    /**
     * Las descripciones de la respuesta
     */
    private List<DescriptionResponse> descriptionResponses;

    /**
     * Validador de la cantidad de respuestas
     */
    private int quantity;

    public DescriptionsResponse() {
        this.descriptionResponses = new ArrayList<>();
        this.quantity = 0;
    }

    /**
     * Este constructor permite iniciar la respuesta con el contenido deseado.
     *
     * @param descriptions Las descripciones a contener.
     */
    public DescriptionsResponse(List<Description> descriptions) {
        for (Description description : descriptions) {
            this.descriptionResponses.add(new DescriptionResponse(description));
        }
        this.quantity = this.descriptionResponses.size();
    }

    @XmlElementWrapper(name = "descripcion")
    @XmlElement(name = "descripciones")
    public List<DescriptionResponse> getDescriptionResponses() {
        return descriptionResponses;
    }

    public void setDescriptionResponses(List<DescriptionResponse> descriptionResponses) {
        this.descriptionResponses = descriptionResponses;
    }

    @XmlElement(name = "cantidadRegistros")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
