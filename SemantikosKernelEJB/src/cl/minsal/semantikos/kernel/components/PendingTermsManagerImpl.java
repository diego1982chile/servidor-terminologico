package cl.minsal.semantikos.kernel.components;

import cl.minsal.semantikos.model.*;
import cl.minsal.semantikos.model.businessrules.PendingTermAddingBR;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @author Andrés Farías on 11/23/16.
 */
@Stateless
public class PendingTermsManagerImpl implements PendingTermsManager {

    @EJB
    PendingTermDAO pendingTermDAO;

    @EJB
    PendingTermAddingBR pendingTermAddingBR;

    @EJB
    ConceptManager conceptManager;

    @EJB
    DescriptionManager descriptionManager;

    @Override
    public void addPendingTerm(PendingTerm pendingTerm, User loggedUser) {

        /* Acciones de negocio a continuación */

        /* 1. Persistir el término pendiente */
        pendingTermDAO.persist(pendingTerm);

        /* 2. Agregarlo al concepto especial 'Pendientes' */
        ConceptSMTK pendingTermsConcept = conceptManager.getPendingConcept();
        descriptionManager.bindDescriptionToConcept(pendingTermsConcept, pendingTerm.getTerm(), DescriptionType.SYNONYMOUS, loggedUser);

        /* Validación de post-condiciones */
        pendingTermAddingBR.validatePostConditions(pendingTerm);
    }
}
