package cl.minsal.semantikos.pendingterms;

import cl.minsal.semantikos.kernel.components.CategoryManager;
import cl.minsal.semantikos.kernel.components.ConceptManager;
import cl.minsal.semantikos.kernel.components.PendingTermsManager;
import cl.minsal.semantikos.model.Category;
import cl.minsal.semantikos.model.ConceptSMTK;
import cl.minsal.semantikos.model.Description;
import cl.minsal.semantikos.model.PendingTerm;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by des01c7 on 22-11-16.
 */


@ManagedBean(name = "managerPendingTermsBean")
@ViewScoped
public class ManagerPendingTermsBean {

    @EJB
    private ConceptManager conceptManager;

    @EJB
    private CategoryManager categoryManager;

    @EJB
    private PendingTermsManager pendingTermsManager;

    private PendingTerm termSelected;

    private List<PendingTerm> pendingTerms;

    private List<PendingTerm> pendingTermsListFilter;

    private ConceptSMTK conceptPending;

    private List<Category> categories;


    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }


    public ConceptSMTK getConceptPending() {
        return conceptPending;
    }

    public void setConceptPending(ConceptSMTK conceptPending) {
        this.conceptPending = conceptPending;
    }

    public List<PendingTerm> getPendingTermsListFilter() {
        return pendingTermsListFilter;
    }

    public void setPendingTermsListFilter(List<PendingTerm> pendingTermsListFilter) {
        this.pendingTermsListFilter = pendingTermsListFilter;
    }

    public PendingTerm getTermSelected() {
        return termSelected;
    }

    public void setTermSelected(PendingTerm termSelected) {
        this.termSelected = termSelected;
    }

    public List<PendingTerm> getPendingTerms() {
        return pendingTerms;
    }

    public void setPendingTerms(List<PendingTerm> pendingTerms) {
        this.pendingTerms = pendingTerms;
    }

    @PostConstruct
    public void init(){
        conceptPending=conceptManager.getPendingConcept();
        categories= categoryManager.getCategories();
        pendingTerms=pendingTermsManager.getAllPendingTerms();
    }


}
