package cl.minsal.semantikos.model;

import java.util.Date;

/**
 * @author Andrés Farías on 11/22/16.
 */
public class PendingTerm extends PersistentEntity {

    private String term;

    private Date date;

    private boolean sensibility;

    private Category category;

    private String nameProfessional;

    private String profession;

    private String speciality;

    private String subspeciality;

    private String mail;

    private String observation;

    public PendingTerm(String term, Date date, boolean sensibility, Category category, String nameProfessional, String profession, String speciality, String subspeciality, String mail, String observation) {
        this.term = term;
        this.date = date;
        this.sensibility = sensibility;
        this.category = category;
        this.nameProfessional = nameProfessional;
        this.profession = profession;
        this.speciality = speciality;
        this.subspeciality = subspeciality;
        this.mail = mail;
        this.observation = observation;
    }

    public String getTerm() {
        return term;
    }

    public Date getDate() {
        return date;
    }

    public boolean isSensibility() {
        return sensibility;
    }

    public Category getCategory() {
        return category;
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

    @Override
    public String toString() {
        return "PendingTerm{" +
                "term='" + term + '\'' +
                ", enviado el " + date +
                " por '" + nameProfessional + '\'' +
                "('" + mail + "\')" +
                '}';
    }
}
