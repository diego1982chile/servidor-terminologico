package cl.minsal.semantikos.designer_modeler.browser;

import cl.minsal.semantikos.designer_modeler.auth.AuthenticationBean;
import cl.minsal.semantikos.kernel.auth.UserManager;
import cl.minsal.semantikos.kernel.components.*;
import cl.minsal.semantikos.model.*;
import cl.minsal.semantikos.model.browser.DescriptionQuery;
import cl.minsal.semantikos.model.browser.NoValidQuery;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * Created by diego on 26/06/2016.
 */

@ManagedBean(name = "noValidBrowserBean")
@ViewScoped
public class NoValidBrowserBean implements Serializable {

    static final Logger logger = LoggerFactory.getLogger(NoValidBrowserBean.class);

    @EJB
    QueryManager queryManager;

    @EJB
    RefSetManager refSetManager;

    /**
     * Objeto de consulta: contiene todos los filtros y columnas necesarios para el despliegue de los resultados en el navegador
     */
    private NoValidQuery noValidQuery;

    /**
     * Lista de tipos de descripción para el despliegue del filtro por tipo
     */
    private List<DescriptionType> descriptionTypes = new ArrayList<DescriptionType>();

    /**
     * Lista de categorías para el despliegue del filtro por tipo de observación
     */
    private List<ObservationNoValid> observationTypes = new ArrayList<ObservationNoValid>();

    /**
     * Lista de descripciones para el despliegue del resultado de la consulta
     */
    private LazyDataModel<NoValidDescription> noValidDescriptions;

    NoValidDescription noValidDescriptionSelected = null;

    ConceptSMTK conceptSelected = null;

    private User user;

    @ManagedProperty(value = "#{authenticationBean}")
    private AuthenticationBean authenticationBean;

    @EJB
    private DescriptionManager descriptionManager;

    @EJB
    private ConceptManager conceptManager;

    @PostConstruct
    public void init(){
        descriptionTypes = DescriptionTypeFactory.getInstance().getDescriptionTypes();
        observationTypes = descriptionManager.getObservationsNoValid();
        user = authenticationBean.getLoggedUser();
    }

    /**
     * Este método es el responsable de ejecutar la consulta
     */
    public void executeQuery() {

        /**
         * Si el objeto de consulta no está inicializado, inicializarlo
         */
        if(noValidQuery == null)
            noValidQuery = queryManager.getDefaultNoValidQuery();

        /**
         * Ejecutar la consulta
         */
        noValidDescriptions = new LazyDataModel<NoValidDescription>() {
            @Override
            public List<NoValidDescription> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

                //List<ConceptSMTK> conceptSMTKs = conceptManager.findConceptBy(category, first, pageSize);

                noValidQuery.setPageNumber(first);
                noValidQuery.setPageSize(pageSize);
                noValidQuery.setOrder(new Integer(sortField));

                if(sortOrder.name().substring(0,3).toLowerCase().equals("asc"))
                    noValidQuery.setAsc(sortOrder.name().substring(0,3).toLowerCase());
                else
                    noValidQuery.setAsc(sortOrder.name().substring(0,4).toLowerCase());

                List<NoValidDescription> noValidDescriptions = queryManager.executeQuery(noValidQuery);

                this.setRowCount(30);
                //this.setRowCount(queryManager.countQueryResults(noValidQuery));

                return noValidDescriptions;
            }

        };

    }

    public void translateDescription() {
        FacesContext context = FacesContext.getCurrentInstance();

        noValidDescriptionSelected.getNoValidDescription().getConceptSMTK().removeDescription(noValidDescriptionSelected.getNoValidDescription());
        noValidDescriptionSelected.getNoValidDescription().setConceptSMTK(conceptSelected);

        try {
            descriptionManager.moveDescriptionToConcept(conceptSelected, noValidDescriptionSelected.getNoValidDescription(), user);
        } catch (EJBException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }

        //pendingTerms = pendingTermsManager.getAllPendingTerms();

        conceptSelected = null;
        noValidDescriptionSelected = null;
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "La descripción fue trasladada exitosamente"));
    }

    public NoValidQuery getNoValidQuery() {
        return noValidQuery;
    }

    public LazyDataModel<NoValidDescription> getNoValidDescriptions() {
        return noValidDescriptions;
    }

    public void setDescriptions(LazyDataModel<NoValidDescription> descriptions) {
        this.noValidDescriptions = descriptions;
    }

    public ConceptManager getConceptManager() {
        return conceptManager;
    }

    public void setConceptManager(ConceptManager conceptManager) {
        this.conceptManager = conceptManager;
    }

    public AuthenticationBean getAuthenticationBean() {
        return authenticationBean;
    }

    public void setAuthenticationBean(AuthenticationBean authenticationBean) {
        this.authenticationBean = authenticationBean;
    }

    public List<DescriptionType> getDescriptionTypes() {
        return descriptionTypes;
    }

    public List<ObservationNoValid> getObservationTypes() {
        return observationTypes;
    }

    public NoValidDescription getNoValidDescriptionSelected() {
        return noValidDescriptionSelected;
    }

    public void setNoValidDescriptionSelected(NoValidDescription noValidDescriptionSelected) {
        this.noValidDescriptionSelected = noValidDescriptionSelected;
    }

    public ConceptSMTK getConceptSelected() {
        return conceptSelected;
    }

    public void setConceptSelected(ConceptSMTK conceptSelected) {
        this.conceptSelected = conceptSelected;
    }

}

