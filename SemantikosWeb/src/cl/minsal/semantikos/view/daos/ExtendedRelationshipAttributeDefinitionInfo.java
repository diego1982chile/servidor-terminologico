package cl.minsal.semantikos.view.daos;

import cl.minsal.semantikos.model.relationships.Target;

/**
 * Created by des01c7 on 04-01-17.
 */
public class ExtendedRelationshipAttributeDefinitionInfo extends ExtendedRelationshipDefinitionInfo{

    public ExtendedRelationshipAttributeDefinitionInfo(long idComposite, int order, Target defaultValue) {
        super(idComposite,  order, defaultValue);
    }
}
