package cl.minsal.semantikos.beans.relationship;

import cl.minsal.semantikos.beans.concept.ConceptBean;
import cl.minsal.semantikos.model.relationships.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by des01c7 on 02-12-16.
 */
@ManagedBean(name = "relationshipBean")
@ViewScoped
public class RelationshipBeans {
    @ManagedProperty( value="#{conceptBean}")
    ConceptBean conceptBean;

    public ConceptBean getConceptBean() {
        return conceptBean;
    }

    public void setConceptBean(ConceptBean conceptBean) {
        this.conceptBean = conceptBean;
    }

    /**
     * Este método es el responsable de retornar verdadero en caso que se cumpla el UpperBoundary de la multiplicidad,
     * para asi desactivar
     * la opción de agregar más relaciones en la vista. En el caso que se retorne falso este seguirá activo el boton en
     * la presentación.
     *
     * @return
     */
    public boolean limitRelationship(RelationshipDefinition relationshipD) {
        if (relationshipD.getMultiplicity().getUpperBoundary() != 0) {
            if (conceptBean.getConcept().getValidRelationshipsByRelationDefinition(relationshipD).size() == relationshipD.getMultiplicity().getUpperBoundary()) {
                return true;
            }
        }
        return false;
    }


    public List<RelationshipAttribute> getRelationshipAttributesByRelationshipDefinition(RelationshipDefinition definition) {

        if (definition == null)
            return new ArrayList<RelationshipAttribute>();
        if (!conceptBean.getRelationshipAttributesPlaceholder().containsKey(definition)) {

            List<RelationshipAttribute> attributes = new ArrayList<RelationshipAttribute>(definition.getRelationshipAttributeDefinitions().size());

            for (RelationshipAttributeDefinition attributeDefinition : definition.getRelationshipAttributeDefinitions()) {
                RelationshipAttribute attribute = new RelationshipAttribute();
                attribute.setRelationAttributeDefinition(attributeDefinition);
                Target t = new TargetFactory().createPlaceholderTargetFromTargetDefinition(definition.getTargetDefinition());
                attribute.setTarget(t);
                attributes.add(attribute);
            }
            conceptBean.getRelationshipAttributesPlaceholder().put(definition, attributes);
        }
        return conceptBean.getRelationshipAttributesPlaceholder().get(definition);
    }
}
