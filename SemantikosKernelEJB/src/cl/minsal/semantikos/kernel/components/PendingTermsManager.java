package cl.minsal.semantikos.kernel.components;

import cl.minsal.semantikos.model.PendingTerm;

import javax.ejb.EJB;
import javax.ejb.Local;

/**
 * @author Andrés Farías on 11/22/16.
 */
@Local
public class PendingTermsManager {

    @EJB
    PendingTermDAO pendingTermDAO;

    public void addPendingTerm(PendingTerm pendingTerm) {
        pendingTermDAO.persist(pendingTerm);
    }
}
