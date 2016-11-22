package cl.minsal.semantikos.pendingterms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.sql.Timestamp;

/**
 * @author Andrés Farías on 11/21/16.
 */

@ManagedBean(name = "pendingTerms")
@ViewScoped
public class PendingTermsBean {

    static final Logger logger = LoggerFactory.getLogger(PendingTermsBean.class);

    private String term;

    private Timestamp date;

    private boolean sensibility;

    private long categoryId;
    private String nameProfessional;
    private String profession;
    private String speciality;
    private String subspeciality;
    private String mail;
    private String observation;

    public String getTerm() {
        return term;
    }

    public Timestamp getDate() {
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

    public void save(){
        logger.info("Se está grabando el término");
    }
}
