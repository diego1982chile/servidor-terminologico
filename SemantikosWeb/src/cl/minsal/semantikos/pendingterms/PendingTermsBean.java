package cl.minsal.semantikos.pendingterms;

import cl.minsal.semantikos.kernel.components.CategoryManager;
import cl.minsal.semantikos.kernel.components.PendingTermsManager;
import cl.minsal.semantikos.model.Category;
import cl.minsal.semantikos.model.PendingTerm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Date;

/**
 * @author Andrés Farías on 11/21/16.
 */

@ManagedBean(name = "pendingTerms")
@ViewScoped
public class PendingTermsBean {

    static final Logger logger = LoggerFactory.getLogger(PendingTermsBean.class);

    private String term;

    private Date date;

    private boolean sensibility;

    private int categoryId;
    private String nameProfessional;
    private String profession;
    private String speciality;
    private String subspeciality;
    private String mail;
    private String observation;

    @EJB
    private PendingTermsManager pendingTermsManager;

    @EJB
    private CategoryManager categoryManager;

    public PendingTermsBean() {
        this.term = "Un término";
        this.date = new Date();
        this.sensibility = true;
        this.nameProfessional = "Juan José Todo Trivial";
        this.profession = "Doctor";
        this.speciality = "Oncología";
        this.subspeciality = "Cerebro";
        this.mail = "gustavo.punucura@gmail.com";
        this.observation = "Observación " + this.date;
    }

    public String getTerm() {
        return term;
    }

    public Date getDate() {
        return date;
    }

    public boolean getSensibility() {
        return sensibility;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getNameProfessional() {
        return nameProfessional;
    }

    public String getProfession() {
        return profession;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getSubspeciality() {
        return subspeciality;
    }

    public String getMail() {
        return mail;
    }

    public String getObservation() {
        return observation;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSensibility(boolean sensibility) {
        this.sensibility = sensibility;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setNameProfessional(String nameProfessional) {
        this.nameProfessional = nameProfessional;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setSubspeciality(String subspeciality) {
        this.subspeciality = subspeciality;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public void save(){
        logger.info("Se está grabando el término pendiente: " + this);

        Category category = categoryManager.getCategoryById(categoryId);
        PendingTerm pendingTerm = new PendingTerm(term, date, sensibility, category, nameProfessional, profession, speciality, subspeciality, mail, observation);
        pendingTermsManager.addPendingTerm(pendingTerm);
    }

    @Override
    public String toString() {
        return "PendingTermsBean{" +
                "term='" + term + '\'' +
                ", date=" + date +
                ", sensibility=" + sensibility +
                ", categoryId=" + categoryId +
                ", nameProfessional='" + nameProfessional + '\'' +
                ", profession='" + profession + '\'' +
                ", speciality='" + speciality + '\'' +
                ", subspeciality='" + subspeciality + '\'' +
                ", mail='" + mail + '\'' +
                ", observation='" + observation + '\'' +
                '}';
    }
}
