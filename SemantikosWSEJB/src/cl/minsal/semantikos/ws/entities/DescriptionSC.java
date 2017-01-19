package cl.minsal.semantikos.ws.entities;

import cl.minsal.semantikos.model.ConceptSMTK;
import cl.minsal.semantikos.model.Description;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Esta clase, DescriptionSelfContained, escrita DescriptionSC y DescripcionAC (Auto Contenida), describe una
 * descripción con suficientes campos para poder identificarla y a su contexto: concepto, categoría, etc.
 *
 * @author Andrés Farías on 12/13/16.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "descripcionAC", namespace = "http://service.ws.semantikos.minsal.cl/")
@XmlType(name = "DescripcionAC", namespace = "http://service.ws.semantikos.minsal.cl/")
public class DescriptionSC implements Serializable {

    /** El valor DESCRIPTION_ID de la descripción */
    private String descriptionId;

    /** El término de la descripción */
    private String term;

    /** El tipo de la descripción (preferida, FSN, etc.) */
    private String descriptionType;

    /** El valor CONCEPT ID del concepto que contiene la descripción */
    private String conceptId;

    /** Nombre de la categoría a la que pertenece el concepto que contiene la descripción */
    private String categoryName;

    /** Valor de DESCRIPTION ID de la descripción preferida del concepto que contiene a la descripción */
    private String preferredDescriptionID;

    /** El término de la descripción preferida del concepto que contiene a la descripción */
    private String prefferedDescriptionTerm;

    public DescriptionSC() {
    }

    /**
     * Este constructor tiene como propósito crear una descripción auto-contenida a partir del objeto de negocio.
     *
     * @param description La descripción a partir de la cual se crea la descripción.
     */
    public DescriptionSC(@NotNull Description description) {
        this.descriptionId = description.getDescriptionId();
        this.term = description.getTerm();
        this.descriptionType = description.getDescriptionType().getName();
        ConceptSMTK conceptSMTK = description.getConceptSMTK();
        this.conceptId = conceptSMTK.getConceptID();
        this.categoryName = conceptSMTK.getCategory().getName();
        this.preferredDescriptionID = conceptSMTK.getDescriptionFavorite().getTerm();
    }

    @XmlElement(name = "description_ID")
    public String getDescriptionId() {
        return descriptionId;
    }
    public void setDescriptionId(String descriptionId) {
        this.descriptionId = descriptionId;
    }

    @XmlElement(name = "termino")
    public String getTerm() {
        return term;
    }
    public void setTerm(String term) {
        this.term = term;
    }

    @XmlElement(name = "tipoDescripcion")
    public String getDescriptionType() {
        return descriptionType;
    }
    public void setDescriptionType(String descriptionType) {
        this.descriptionType = descriptionType;
    }

    @XmlElement(name = "concept_ID")
    public String getConceptId() {
        return conceptId;
    }

    public void setConceptId(String conceptId) {
        this.conceptId = conceptId;
    }

    @XmlElement(name = "nombreCategoria")
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @XmlElement(name = "description_ID_Preferida")
    public String getPreferredDescriptionID() {
        return preferredDescriptionID;
    }
    public void setPreferredDescriptionID(String preferredDescriptionID) {
        this.preferredDescriptionID = preferredDescriptionID;
    }

    @XmlElement(name = "terminoPreferida")
    public String getPrefferedDescriptionTerm() {
        return prefferedDescriptionTerm;
    }
    public void setPrefferedDescriptionTerm(String prefferedDescriptionTerm) {
        this.prefferedDescriptionTerm = prefferedDescriptionTerm;
    }
}
