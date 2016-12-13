package cl.minsal.semantikos.kernel.components;

import cl.minsal.semantikos.model.Category;
import cl.minsal.semantikos.model.ConceptSMTK;
import cl.minsal.semantikos.model.Description;
import cl.minsal.semantikos.model.NoValidDescription;
import cl.minsal.semantikos.model.browser.GeneralQuery;
import cl.minsal.semantikos.model.browser.DescriptionQuery;
import cl.minsal.semantikos.model.browser.NoValidQuery;
import cl.minsal.semantikos.model.relationships.Relationship;
import cl.minsal.semantikos.model.relationships.RelationshipDefinition;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by BluePrints Developer on 21-09-2016.
 */
@Local
public interface QueryManager {

    public GeneralQuery getDefaultGeneralQuery(Category category);

    public DescriptionQuery getDefaultDescriptionQuery();

    public NoValidQuery getDefaultNoValidQuery();

    public List<ConceptSMTK> executeQuery(GeneralQuery query);

    public List<Description> executeQuery(DescriptionQuery query);

    public List<NoValidDescription> executeQuery(NoValidQuery query);

    public int countQueryResults(GeneralQuery query);

    public int countQueryResults(DescriptionQuery query);

    public int countQueryResults(NoValidQuery query);

    public List<RelationshipDefinition> getSearchableAttributesByCategory(Category category);

    public List<RelationshipDefinition> getShowableAttributesByCategory(Category category);

}
