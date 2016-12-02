package cl.minsal.semantikos.designer_modeler.browser;

import cl.minsal.semantikos.designer_modeler.auth.AuthenticationBean;
import cl.minsal.semantikos.designer_modeler.designer.SMTKTypeBean;
import cl.minsal.semantikos.kernel.auth.UserManager;
import cl.minsal.semantikos.kernel.components.*;
import cl.minsal.semantikos.model.Category;
import cl.minsal.semantikos.model.ConceptSMTK;
import cl.minsal.semantikos.model.Tag;
import cl.minsal.semantikos.model.User;
import cl.minsal.semantikos.model.basictypes.BasicTypeValue;
import cl.minsal.semantikos.model.browser.ConceptQuery;
import cl.minsal.semantikos.model.browser.ConceptQueryFilter;
import cl.minsal.semantikos.model.helpertables.HelperTableRecord;
import cl.minsal.semantikos.model.relationships.RelationshipDefinition;
import cl.minsal.semantikos.model.relationships.Target;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by diego on 26/06/2016.
 */

@ManagedBean(name = "drugsBrowserBean")
@ViewScoped
public class DrugsBrowserBean implements Serializable {

    static final Logger logger = LoggerFactory.getLogger(DrugsBrowserBean.class);

    @EJB
    DrugsManager drugsManager;

    /**
     * Lista de usuarios para el despliegue del filtro por usuarios
     */
    private List<User> users = new ArrayList<User>();

    /**
     * Lista de conceptos para el despliegue del resultado de la consulta
     */
    private LazyDataModel<ConceptSMTK> concepts;

    private ConceptSMTK conceptSelected = null;

    @EJB
    private CategoryManager categoryManager;

    @EJB
    private ConceptManager conceptManager;

    @PostConstruct
    public void init(){
    }

    public ConceptSMTK getConceptSelected() {
        return conceptSelected;
    }

    public void setConceptSelected(ConceptSMTK conceptSelected) {
        this.conceptSelected = conceptSelected;
        drugsManager.getDrugsConceptChains(this.conceptSelected);
    }

    public DrugsManager getDrugsManager() {
        return drugsManager;
    }

    public void setDrugsManager(DrugsManager drugsManager) {
        this.drugsManager = drugsManager;
    }

}

