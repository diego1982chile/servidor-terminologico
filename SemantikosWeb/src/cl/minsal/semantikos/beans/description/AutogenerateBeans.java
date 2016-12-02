package cl.minsal.semantikos.beans.description;

import cl.minsal.semantikos.kernel.components.RelationshipManager;
import cl.minsal.semantikos.model.*;
import cl.minsal.semantikos.model.relationships.Relationship;
import cl.minsal.semantikos.model.relationships.RelationshipDefinition;
import cl.minsal.semantikos.model.relationships.Target;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by des01c7 on 02-12-16.
 */
@ManagedBean(name = "autogenerateBeans")
@ViewScoped
public class AutogenerateBeans {

     @EJB
     private RelationshipManager relationshipManager;

    public String autogenerate(List<String> autoGenerateList) {
        String autogenerateString = "";
        for (int i = 0; i < autoGenerateList.size(); i++) {
            if (i == 0) {
                autogenerateString = autoGenerateList.get(i);
            } else {
                autogenerateString = autogenerateString + " + " + autoGenerateList.get(i);
            }
        }
        return autogenerateString;
    }

    public void autogenerateRelationshipWithAttributes(RelationshipDefinition relationshipDefinition, Relationship relationship, ConceptSMTKWeb concept, List<String> autoGenerateList, AutogenerateMC autogenerateMC) {
        if (!concept.isPersistent()) {
            if (relationshipDefinition.getId() == 45) {
                autoGenerateList.add(((ConceptSMTK) relationship.getTarget()).getDescriptionFavorite().getTerm());
                concept.getDescriptionFavorite().setTerm(autogenerate(autoGenerateList));
                concept.getDescriptionFSN().setTerm(concept.getDescriptionFavorite().getTerm());
            }
            if (relationshipDefinition.getId() == 47) {
                autogenerateMC.addSustancia(relationship);
                concept.getDescriptionFavorite().setTerm(autogenerateMC.toString());
                concept.getDescriptionFSN().setTerm(concept.getDescriptionFavorite().getTerm());
            }
            if (relationshipDefinition.getId() == 58) {
                autogenerateMC.addFFA(relationship);
                concept.getDescriptionFavorite().setTerm(autogenerateMC.toString());
                concept.getDescriptionFSN().setTerm(concept.getDescriptionFavorite().getTerm());
            }
        }
    }



    public void autogenerateRelationship(RelationshipDefinition relationshipDefinition, Relationship relationship, Target target, ConceptSMTKWeb concept, AutogenerateMC autogenerateMC, AutogenerateMCCE autogenerateMCCE, AutogeneratePCCE autogeneratePCCE) {
        if (!concept.isPersistent()) {
            if (relationshipDefinition.getId() == 48) {
                autogenerateMCCE.setMC(((ConceptSMTK) relationship.getTarget()).getDescriptionFavorite().getTerm());
                concept.getDescriptionFavorite().setTerm(autogenerateMCCE.toString());
                concept.getDescriptionFSN().setTerm(concept.getDescriptionFavorite().getTerm());
            }
            if (relationshipDefinition.getId() == 92) {
                autogenerateMCCE.setCantidad(relationship.getTarget().toString());
                concept.getDescriptionFavorite().setTerm(autogenerateMCCE.toString());
                concept.getDescriptionFSN().setTerm(concept.getDescriptionFavorite().getTerm());
            }
            if (relationshipDefinition.getId() == 93) {
                autogenerateMCCE.setVolumen(target.toString());
                concept.getDescriptionFavorite().setTerm(autogenerateMCCE.toString());
                concept.getDescriptionFSN().setTerm(concept.getDescriptionFavorite().getTerm());
            }
            if (relationshipDefinition.getId() == 77) {
                autogenerateMCCE.setPack(target.toString());
                concept.getDescriptionFavorite().setTerm(autogenerateMCCE.toString());
                concept.getDescriptionFSN().setTerm(concept.getDescriptionFavorite().getTerm());
            }
            if (relationshipDefinition.getId() == 69) {
                autogenerateMC.setVolumen(relationship);
                concept.getDescriptionFavorite().setTerm(autogenerateMC.toString());
                concept.getDescriptionFSN().setTerm(concept.getDescriptionFavorite().getTerm());
            }
            if (relationshipDefinition.getId() == 52) {
                ConceptSMTK c = (ConceptSMTK) relationship.getTarget();
                c.setRelationships(relationshipManager.getRelationshipsBySourceConcept(c));
                autogeneratePCCE.autogeratePCCE((ConceptSMTK) relationship.getTarget());
                concept.getDescriptionFavorite().setTerm(autogeneratePCCE.toString());
                concept.getDescriptionFSN().setTerm(concept.getDescriptionFavorite().getTerm());
            }
            if (relationshipDefinition.getId() == 51) {
                autogeneratePCCE.setPc(((ConceptSMTK) relationship.getTarget()).getDescriptionFavorite().getTerm());
                concept.getDescriptionFavorite().setTerm(autogeneratePCCE.toString());
                concept.getDescriptionFSN().setTerm(concept.getDescriptionFavorite().getTerm());
            }
        }
    }
}
