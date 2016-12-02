package cl.minsal.semantikos.beans.relationship;

import cl.minsal.semantikos.beans.concept.ConceptBean;
import cl.minsal.semantikos.model.ConceptSMTK;
import cl.minsal.semantikos.model.RelationshipWeb;
import cl.minsal.semantikos.model.basictypes.BasicTypeValue;
import cl.minsal.semantikos.model.relationships.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * Este método es el encargado de agregar relaciones al concepto recibiendo como parámetro un Relationship
     * Definition. Este método es utilizado por el componente BasicType, el cual agrega relaciones con target sin valor
     */
    public void addRelationship(RelationshipDefinition relationshipDefinition) {
        Target target = new BasicTypeValue(null);
        Relationship relationship = new Relationship(conceptBean.getConcept(), target, relationshipDefinition, new ArrayList<RelationshipAttribute>(), null);
        // Se utiliza el constructor mínimo (sin id)
        conceptBean.getConcept().addRelationshipWeb(new RelationshipWeb(relationship, relationship.getRelationshipAttributes()));
    }

public List<RelationshipDefinitionWeb> getOrderedRelationshipDefinitions(){
    return null;
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

    public boolean changeDirectMultiplicity(RelationshipDefinition relationshipDefinition) {
        //MCCE Pack Multi
        if (relationshipDefinition.getId() == 77) return changeDirectMultiplicity(relationshipDefinition, 16L);
        //MCCE Volumen total
        if (relationshipDefinition.getId() == 93) return changeDirectMultiplicity(relationshipDefinition, 17L);
        //MC Cantidad Volumen total
        if (relationshipDefinition.getId() == 69) return changeDirectMultiplicity(relationshipDefinition, 12L);
        return false;
    }

    public boolean changeDirectMultiplicity(RelationshipDefinition relationshipDefinition, Long idAttributeDefinition) {
        for (RelationshipAttributeDefinition relationshipAttributeDefinition : relationshipDefinition.getRelationshipAttributeDefinitions()) {
            if (relationshipAttributeDefinition.getId() == idAttributeDefinition) {
                if (!conceptBean.getConcept().getRelationshipsByRelationDefinition(relationshipDefinition).isEmpty()) {
                    for (Relationship relationship : conceptBean.getConcept().getRelationshipsByRelationDefinition(relationshipDefinition)) {
                        return relationship.getAttributesByAttributeDefinition(relationshipAttributeDefinition).isEmpty();
                    }
                }
            }
        }
        return false;
    }

    public boolean changeIndirectMultiplicity(Relationship relation, RelationshipDefinition relationshipDefinition, RelationshipAttributeDefinition relationshipAttributeDefinition) {
        if (relationshipAttributeDefinition.getId() == 8 && relation.getAttributesByAttributeDefinition(relationshipAttributeDefinition).size() > 0) {
            return isEmpty(relation, relationshipDefinition, relationshipAttributeDefinition, 9L);
        }
        if (relationshipAttributeDefinition.getId() == 10 && relation.getAttributesByAttributeDefinition(relationshipAttributeDefinition).size() > 0) {
            return isEmpty(relation, relationshipDefinition, relationshipAttributeDefinition, 11L);
        }
        return false;
    }

    public boolean isEmpty(Relationship relation, RelationshipDefinition relationshipDefinition, RelationshipAttributeDefinition relationshipAttributeDefinition, Long idAttributeDefinition) {
        if (relation.getAttributesByAttributeDefinition(relationshipAttributeDefinition).size() != 0) {
            for (RelationshipAttributeDefinition rAD : relationshipDefinition.getRelationshipAttributeDefinitions()) {
                if (rAD.getId() == idAttributeDefinition) {
                    return relation.getAttributesByAttributeDefinition(rAD).isEmpty();
                }
            }
        }
        return true;
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


    public ConceptSMTK getTargetForRD(RelationshipDefinition relationshipDefinition, ConceptSMTK conceptSel, Map<Long,ConceptSMTK> targetSelected) {
        if (targetSelected == null) {
            targetSelected = new HashMap<Long, ConceptSMTK>();
        }
        if (!targetSelected.containsKey(relationshipDefinition.getId())) {
            targetSelected.put(relationshipDefinition.getId(), conceptSel);
        }
        return targetSelected.get(relationshipDefinition.getId());
    }
}
