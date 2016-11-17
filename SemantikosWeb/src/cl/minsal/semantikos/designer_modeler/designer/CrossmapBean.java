package cl.minsal.semantikos.designer_modeler.designer;

import cl.minsal.semantikos.kernel.components.CrossmapsManager;
import cl.minsal.semantikos.kernel.components.HelperTableManager;
import cl.minsal.semantikos.model.ConceptSMTK;
import cl.minsal.semantikos.model.crossmaps.Crossmap;
import cl.minsal.semantikos.model.helpertables.HelperTable;
import cl.minsal.semantikos.model.helpertables.HelperTableRecord;
import cl.minsal.semantikos.model.relationships.RelationshipDefinition;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * Created by des01c7 on 26-07-16.
 */

@ManagedBean(name = "crossmapBean")
@ViewScoped
public class CrossmapBean implements Serializable {

    private String pattern;

    private Crossmap crossmapPlaceHolder = null;

    @EJB
    private CrossmapsManager crossmapsManager;

    @PostConstruct
    public void init() {
    }

    public List<Crossmap> getCrossmapSearchInput(String patron) {

        /* Si el patrón viene vacío o es menor a tres caracteres, no se hace nada */
         if ( patron == null || patron.length() < 2 ) {
            return emptyList();
        }

        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext context2 = RequestContext.getCurrentInstance();

        ConceptSMTK concept = (ConceptSMTK) UIComponent.getCurrentComponent(context).getAttributes().get("concept");
        RelationshipDefinition relationshipDefinition = (RelationshipDefinition) UIComponent.getCurrentComponent(context).getAttributes().get("relationshipDefinition");

        List<Crossmap> someCrossmaps = crossmapsManager.getCrossmaps(concept);

        return someCrossmaps;
    }


    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Crossmap getCrossmapPlaceHolder() {
        return crossmapPlaceHolder;
    }

    public void setCrossmapPlaceHolder(Crossmap crossmapPlaceHolder) {
        this.crossmapPlaceHolder = crossmapPlaceHolder;
    }

    public CrossmapsManager getCrossmapsManager() {
        return crossmapsManager;
    }

    public void setCrossmapsManager(CrossmapsManager crossmapsManager) {
        this.crossmapsManager = crossmapsManager;
    }


}
