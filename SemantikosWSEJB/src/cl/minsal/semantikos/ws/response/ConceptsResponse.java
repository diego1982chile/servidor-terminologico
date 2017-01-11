package cl.minsal.semantikos.ws.response;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Esta clase representa una respuesta XML con una lista de conceptos.
 *
 * @author Alfonso Cornejo on 2016-10-11.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "respuestaConceptosPorCategoria", namespace = "http://service.ws.semantikos.minsal.cl/")
@XmlType(name = "RespuestaConceptosPorCategoria", namespace = "http://service.ws.semantikos.minsal.cl/")
public class ConceptsResponse implements Serializable {

    @XmlElementWrapper(name = "conceptos")
    @XmlElement(name = "concepto")
    private List<ConceptResponse> conceptResponses;

    public List<ConceptResponse> getConceptResponses() {
        return conceptResponses;
    }

    public void setConceptResponses(List<ConceptResponse> conceptResponses) {
        this.conceptResponses = conceptResponses;
    }
}
