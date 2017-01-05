package cl.minsal.semantikos.model.relationships;

import cl.minsal.semantikos.model.Multiplicity;

/**
 * Created by des01c7 on 04-01-17.
 */
public class RelationshipAttributeDefinitionWeb  extends RelationshipAttributeDefinition {

    /** El identificador del composite que se quiere usar en las vistas */
    private long compositeID;

    /** Establece el orden o posición */
    private int order;

    public RelationshipAttributeDefinitionWeb(long id, TargetDefinition target, String name, Multiplicity multiplicity, long compositeID, int order) {
        super(id, target,name, multiplicity);
        this.order =order;
        this.compositeID=compositeID;
    }

    public long getCompositeID() {
        return compositeID;
    }

    public void setCompositeID(long compositeID) {
        this.compositeID = compositeID;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
