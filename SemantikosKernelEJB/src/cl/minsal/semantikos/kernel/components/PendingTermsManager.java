package cl.minsal.semantikos.kernel.components;

import cl.minsal.semantikos.model.PendingTerm;
import cl.minsal.semantikos.model.User;

import javax.ejb.Local;

/**
 * @author Andrés Farías on 11/22/16.
 */
@Local
public interface PendingTermsManager {

    /**
     * Este método es responsable de agregar un término pendiente al sistema.
     *
     * @param pendingTerm El término que se desea agregar.
     * @param loggedUser  El usuario conectado que realiza la operación.
     */
    public void addPendingTerm(PendingTerm pendingTerm, User loggedUser);
}
