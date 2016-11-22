package cl.minsal.semantikos.pendingterms;

import cl.minsal.semantikos.kernel.components.ConceptManager;
import cl.minsal.semantikos.model.ConceptSMTK;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by des01c7 on 22-11-16.
 */


@ManagedBean(name = "managerPendingTermsBean")
@ViewScoped
public class ManagerPendingTermsBean {

    @EJB
    private ConceptManager conceptManager;

    private ConceptSMTK conceptPending;

    public ConceptSMTK getConceptPending() {
        return conceptPending;
    }

    public void setConceptPending(ConceptSMTK conceptPending) {
        this.conceptPending = conceptPending;
    }

    @PostConstruct
    public void init(){
        conceptPending=conceptManager.getPendingConcept();
    }


}
