package cl.minsal.semantikos.kernel.components;

import cl.minsal.semantikos.model.PendingTerm;

import javax.ejb.Local;

/**
 * @author Andrés Farías on 11/22/16.
 */
@Local
public interface PendingTermDAO {

    /**
     * Este método es responsable de persistir el termino pendiente en la base de datos.
     *
     * @param pendingTerm El término pendiente que se desea persistir.
     */
    public void persist(PendingTerm pendingTerm);
}
