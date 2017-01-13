package cl.minsal.semantikos.ws.request;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Alfonso Cornejo on 2016-11-23.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "conceptosPedibles", namespace = "http://service.ws.semantikos.minsal.cl/")
@XmlType(name = "PeticionConceptosPedibles", namespace = "http://service.ws.semantikos.minsal.cl/")
public class RequestableConceptsRequest implements Serializable {

    @XmlElement(required = true, name = "pedible")
    private String requestable;

    @XmlElement(name = "nombreCategoria")
    private List<String> categoryNames;

    @XmlElement(name = "nombreRefSet")
    private List<String> refSetNames;

    @XmlElement(required = true, name = "idEstablecimiento")
    private String idStablishment;

    public List<String> getCategoryNames() {
        return categoryNames;
    }

    public void setCategoryNames(List<String> categoryNames) {
        this.categoryNames = categoryNames;
    }

    public List<String> getRefSetNames() {
        return refSetNames;
    }

    public void setRefSetNames(List<String> refSetNames) {
        this.refSetNames = refSetNames;
    }

    public String getRequestable() {
        return requestable;
    }

    public void setRequestable(String requestable) {
        this.requestable = requestable;
    }

    public String getIdStablishment() {
        return idStablishment;
    }

    public void setIdStablishment(String idStablishment) {
        this.idStablishment = idStablishment;
    }
}