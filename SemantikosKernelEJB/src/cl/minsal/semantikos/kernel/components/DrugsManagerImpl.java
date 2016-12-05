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
import java.util.Arrays;
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

        return _getDrugsConceptChains(Arrays.asList(concept));

    }

    private List<ConceptSMTK> _getDrugsConceptChains(List<ConceptSMTK> nodes){

        for (ConceptSMTK node : nodes) {

            List<ConceptSMTK> parentNodes = new ArrayList<>();

            if(conceptManager.getRelatedConcepts(node).isEmpty()) {
                nodes.add(node);
                return nodes;
            }

            for (ConceptSMTK parentNode : conceptManager.getRelatedConcepts(node)) {
                RelationshipDefinition rd = new RelationshipDefinition(parentNode.getCategory().getName(),parentNode.getCategory().getName(),MultiplicityFactory.ONE_TO_ONE,parentNode.getCategory());
                Relationship r = new Relationship(parentNode, node, rd, new ArrayList<RelationshipAttribute>(), null);
                parentNode.addRelationship(r);
                parentNodes.add(parentNode);
            }
            return _getDrugsConceptChains(parentNodes);
        }
        return nodes;
    }

}
