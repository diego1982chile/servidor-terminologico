package cl.minsal.semantikos.ws.response;

import cl.minsal.semantikos.model.crossmaps.IndirectCrossmap;

import javax.xml.bind.annotation.*;

/**
 * @author Andrés Farías on 12/15/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "indirectCrossmap", namespace = "http://service.ws.semantikos.minsal.cl/")
@XmlType(name = "IndirectCrossmap", namespace = "http://service.ws.semantikos.minsal.cl/")
public class IndirectCrossMapResponse {

    @XmlElement(name = "mapGroup")
    private int mapGroup;

    @XmlElement(name = "mapPriority")
    private int mapPriority;

    @XmlElement(name = "mapRule")
    private String mapRule;

    @XmlElement(name = "mapAdvice")
    private String mapAdvice;

    @XmlElement(name = "mapTarget")
    private String mapTarget;

    @XmlElement(name = "correlation")
    private long correlation;

    @XmlElement(name = "idCrossmapCategory")
    private long idCrossmapCategory;

    @XmlElement(name = "state")
    private boolean state;

    public IndirectCrossMapResponse() {
    }

    public IndirectCrossMapResponse(IndirectCrossmap indirectCrossmap) {
        this();

        this.mapGroup = indirectCrossmap.getMapGroup();
        this.mapPriority = indirectCrossmap.getMapPriority();
        this.mapRule = indirectCrossmap.getMapRule();
        this.mapAdvice = indirectCrossmap.getMapAdvice();
        this.mapTarget = indirectCrossmap.getMapTarget();
        this.correlation = indirectCrossmap.getCorrelation();
        this.idCrossmapCategory = indirectCrossmap.getIdCrossmapCategory();
        this.state = indirectCrossmap.isState();
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
