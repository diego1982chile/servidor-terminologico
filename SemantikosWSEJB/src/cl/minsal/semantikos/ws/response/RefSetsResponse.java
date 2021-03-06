package cl.minsal.semantikos.ws.response;

import cl.minsal.semantikos.model.RefSet;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrés Farías on 12-01-17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "respuestaRefSets", namespace = "http://service.ws.semantikos.minsal.cl/")
@XmlType(name = "RespuestaRefSets", namespace = "http://service.ws.semantikos.minsal.cl/")
public class RefSetsResponse {

    @XmlElementWrapper(name = "refsets")
    @XmlElement(name = "refset")
    private List<RefSetResponse> refSetResponses;

    public RefSetsResponse() {
        this.refSetResponses = new ArrayList<>();
    }

    public RefSetsResponse(List<RefSet> refSets) {
        this();

        if (refSets == null || refSets.isEmpty()){
            return;
        }

        for (RefSet refSet : refSets) {
            refSetResponses.add(new RefSetResponse(refSet));
        }
    }

    public List<RefSetResponse> getRefSetResponses() {
        return refSetResponses;
    }

    public void setRefSetResponses(List<RefSetResponse> refSetResponses) {
        this.refSetResponses = refSetResponses;
    }
}
