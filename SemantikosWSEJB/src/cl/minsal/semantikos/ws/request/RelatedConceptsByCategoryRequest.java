package cl.minsal.semantikos.ws.request;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by Development on 2016-11-23.
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "peticionConceptosRelacionadosPorCategoria", namespace = "http://service.ws.semantikos.minsal.cl/")
@XmlType(name = "PeticionConceptosRelacionadosPorCategoria", namespace = "http://service.ws.semantikos.minsal.cl/")
public class RelatedConceptsByCategoryRequest implements Serializable {

    @XmlElement(required = false, name = "idConcepto")
    private String conceptId;
    @XmlElement(required = false, name = "idDescripcion")
    private String descriptionId;
    @XmlElement(required = true, name = "categoriaRelacion")
    private String relatedCategoryName;

    public String getConceptId() {
        return conceptId;
    }

    public void setConceptId(String conceptId) {
        this.conceptId = conceptId;
    }

    public String getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(String descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getRelatedCategoryName() {
        return relatedCategoryName;
    }

    public void setRelatedCategoryName(String relatedCategoryName) {
        this.relatedCategoryName = relatedCategoryName;
    }

}
