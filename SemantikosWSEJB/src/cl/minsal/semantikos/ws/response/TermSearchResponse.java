package cl.minsal.semantikos.ws.response;

import cl.minsal.semantikos.model.ConceptSMTK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "respuestaBuscarTermino", namespace = "http://service.ws.semantikos.minsal.cl/")
@XmlType(name = "RespuestaBuscarTermino", namespace = "http://service.ws.semantikos.minsal.cl/")
public class TermSearchResponse implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(TermSearchResponse.class);

    @XmlElementWrapper(name = "conceptos")
    @XmlElement(name = "concepto")
    private List<ConceptLightResponse> concepts;

    public TermSearchResponse() {
        this.concepts = new ArrayList<>();
    }

    /**
     * Este constructor incializa la lista de conceptos pedibles.
     *
     * @param requestableConcepts Los conceptos pedibles con los que se inicializa la búsqueda.
     */
    public TermSearchResponse(List<ConceptSMTK> requestableConcepts) {
        this();

        if (requestableConcepts == null || requestableConcepts.isEmpty()){
            logger.debug("TermSearchResponse(" + requestableConcepts + ") se creo con 0 conceptos.");
            return;
        }

        for (ConceptSMTK requestableConcept : requestableConcepts) {
            concepts.add(new ConceptLightResponse(requestableConcept));
        }
        logger.debug("TermSearchResponse(" + requestableConcepts + ") se creo con {} conceptos.", requestableConcepts.size());
    }

    public List<ConceptLightResponse> getConcepts() {
        return concepts;
    }

    public void setConcepts(List<ConceptLightResponse> concepts) {
        this.concepts = concepts;
    }

    @Override
    public String toString() {
        return "TermSearchResponse{" +
                "concepts=" + concepts +
                '}';
    }
}
