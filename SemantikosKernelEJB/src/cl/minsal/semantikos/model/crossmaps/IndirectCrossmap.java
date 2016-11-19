package cl.minsal.semantikos.model.crossmaps;

import cl.minsal.semantikos.model.ConceptSMTK;
import cl.minsal.semantikos.model.relationships.RelationshipDefinition;
import cl.minsal.semantikos.model.relationships.Target;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author Andrés Farías on 11/3/16.
 */
public class IndirectCrossmap extends Crossmap {

    private int mapGroup;

    private int mapPriority;

    private String mapRule;

    private String mapAdvice;

    private String mapTarget;

    private long correlation;

    private long idCrossmapCategory;

    private boolean state;

    public IndirectCrossmap(ConceptSMTK sourceConcept, CrossmapSetMember target, RelationshipDefinition relationshipDefinition, Timestamp validityUntil) {
        super(sourceConcept, target, relationshipDefinition, validityUntil);
    }

    public IndirectCrossmap(@NotNull long id, @NotNull ConceptSMTK sourceConcept, @NotNull CrossmapSetMember target, @NotNull RelationshipDefinition relationshipDefinition, Timestamp validityUntil) {
        super(id, sourceConcept, target, relationshipDefinition, validityUntil);
    }

    @Override
    public boolean is(CrossMapType indirect) {
        return indirect.equals(CrossMapType.INDIRECT);
    }

    public int getMapGroup() {
        return mapGroup;
    }

    public void setMapGroup(int mapGroup) {
        this.mapGroup = mapGroup;
    }

    public int getMapPriority() {
        return mapPriority;
    }

    public void setMapPriority(int mapPriority) {
        this.mapPriority = mapPriority;
    }

    public String getMapRule() {
        return mapRule;
    }

    public void setMapRule(String mapRule) {
        this.mapRule = mapRule;
    }

    public String getMapAdvice() {
        return mapAdvice;
    }

    public void setMapAdvice(String mapAdvice) {
        this.mapAdvice = mapAdvice;
    }

    public String getMapTarget() {
        return mapTarget;
    }

    public void setMapTarget(String mapTarget) {
        this.mapTarget = mapTarget;
    }

    public long getCorrelation() {
        return correlation;
    }

    public void setCorrelation(long correlation) {
        this.correlation = correlation;
    }

    public long getIdCrossmapCategory() {
        return idCrossmapCategory;
    }

    public void setIdCrossmapCategory(long idCrossmapCategory) {
        this.idCrossmapCategory = idCrossmapCategory;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
