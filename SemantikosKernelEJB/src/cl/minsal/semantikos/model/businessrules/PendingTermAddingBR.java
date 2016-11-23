package cl.minsal.semantikos.model.businessrules;

import cl.minsal.semantikos.kernel.daos.ConceptDAO;
import cl.minsal.semantikos.model.ConceptSMTK;
import cl.minsal.semantikos.model.Description;
import cl.minsal.semantikos.model.PendingTerm;
import cl.minsal.semantikos.model.exceptions.BusinessRuleException;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

/**
 * @author Andrés Farías on 11/23/16.
 */
@Singleton
public class PendingTermAddingBR {

    @EJB
    ConceptDAO conceptDAO;

    /**
     * Este método valida las post-condiciones asociadas a la agregación del c
     *
     * @param pendingTerm El término pendiente que se ha agregado.
     */
    public void validatePostConditions(PendingTerm pendingTerm) {

        /* El concepto fue asociado al concepto especial 'Pendientes' */
        postCondition001(pendingTerm);
    }

    /**
     * BR-PEND-001: El valor del campo Término del Formulario de Solicitud quedará asociado a una descripción
     * perteneciente a un concepto cuyo “Pendientes”  de la Categoría Concepto Especial.
     *
     * @param pendingTerm El término agregado.
     */
    private void postCondition001(PendingTerm pendingTerm) {

        /* Se recupera el concepto pendiente */
        ConceptSMTK pendingConcept = conceptDAO.getPendingConcept();

        List<Description> descriptions = pendingConcept.getDescriptions();
        for (Description description : descriptions) {
            if (description.getTerm().equals(pendingTerm.getTerm())) {
                return;
            }
        }

        /* En este punto, no se encontró el término en las descripcioens del concepto */
        throw new BusinessRuleException("El término pendiente " + pendingTerm + " no fue agregado como descripción al concepto 'Pendientes'.");
    }
}
