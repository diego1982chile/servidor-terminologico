package cl.minsal.semantikos.kernel.components;

import cl.minsal.semantikos.kernel.daos.ConceptQueryDAO;
import cl.minsal.semantikos.kernel.daos.RelationshipDAO;
import cl.minsal.semantikos.model.Category;
import cl.minsal.semantikos.model.ConceptSMTK;
import cl.minsal.semantikos.model.MultiplicityFactory;
import cl.minsal.semantikos.model.browser.ConceptQuery;
import cl.minsal.semantikos.model.browser.ConceptQueryColumn;
import cl.minsal.semantikos.model.browser.ConceptQueryFilter;
import cl.minsal.semantikos.model.browser.Sort;
import cl.minsal.semantikos.model.relationships.Relationship;
import cl.minsal.semantikos.model.relationships.RelationshipAttribute;
import cl.minsal.semantikos.model.relationships.RelationshipDefinition;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BluePrints Developer on 21-09-2016.
 */
@Stateless
public class DrugsManagerImpl implements DrugsManager {


    @EJB
    private ConceptManager conceptManager;

    @EJB
    private CategoryManager categoryManager;

    @EJB
    private RelationshipDAO relationshipDAO;


    @Override
    public List<Category> getDrugsCategories() {

        List<Category> drugsCategories = new ArrayList<>();

        for (Category category : categoryManager.getCategories()) {
            if(category.getName().toLowerCase().startsWith("fármacos"))
                drugsCategories.add(category);
        }

        return drugsCategories;
    }

    @Override
    public List<ConceptSMTK> getDrugsConceptChains(ConceptSMTK concept) {

        return _getDrugsConceptChains(concept, new ArrayList<ConceptSMTK>());

    }

    private List<ConceptSMTK> _getDrugsConceptChains(ConceptSMTK concept, List<ConceptSMTK> chains){
        if(conceptManager.getRelatedConcepts(concept).isEmpty()) {
            chains.add(concept);
            return chains;
        }
        else{
            for (ConceptSMTK parentConcept : conceptManager.getRelatedConcepts(concept)) {
                RelationshipDefinition rd = new RelationshipDefinition(concept.getCategory().getName(),concept.getCategory().getName(),MultiplicityFactory.ONE_TO_ONE,concept.getCategory());
                Relationship r = new Relationship(parentConcept, concept, rd, new ArrayList<RelationshipAttribute>(), null);
                parentConcept.addRelationship(r);
                return _getDrugsConceptChains(parentConcept, chains);
            }
        }
        return chains;
    }
}
