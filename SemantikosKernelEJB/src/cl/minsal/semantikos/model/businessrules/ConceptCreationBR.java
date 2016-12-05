package cl.minsal.semantikos.model.businessrules;

import cl.minsal.semantikos.model.*;
import cl.minsal.semantikos.model.exceptions.BusinessRuleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;

import static cl.minsal.semantikos.model.ProfileFactory.DESIGNER_PROFILE;
import static cl.minsal.semantikos.model.ProfileFactory.MODELER_PROFILE;

/**
 * Este componente es responsable de almacenar las reglas de negocio relacionadas a la persistencia de conceptos.
 *
 * @author Andrés Farías
 */
public class ConceptCreationBR implements BusinessRulesContainer {

    private static final Logger logger = LoggerFactory.getLogger(ConceptCreationBR.class);


    public void apply(@NotNull ConceptSMTK conceptSMTK, User IUser) throws BusinessRuleException {

        /* Reglas que aplican para todas las categorías */
        br101HasFSN(conceptSMTK);
        br102NonEmptyDescriptions(conceptSMTK);
        brTagSMTK001(conceptSMTK);
        br001creationRights(conceptSMTK, IUser);
    }

    /**
     * BR-TagSMTK-001: Cuando se diseña un nuevo Término se le asigna un Tag por defecto.
     *
     * @param conceptSMTK El concepto sobre el cual se valida que tenga un Tag Semantikos asociado.
     */
    protected void brTagSMTK001(ConceptSMTK conceptSMTK) {

        /* Se obtiene el Tag Semantikos */
        TagSMTK tagSMTK = conceptSMTK.getTagSMTK();

        /* Se valida que no sea nulo y que sea de los oficiales */
        if (tagSMTK == null || !tagSMTK.isValid()) {
            throw new BusinessRuleException("BR-TagSMTK-001", "Todo concepto debe tener un Tag Semántikos (válido).");
        }
    }

    /**
     * Esta regla de negocio valida que un concepto no puede tener descripciones nulas o vacias.
     *
     * @param conceptSMTK El concepto cuyas descripciones de validan.
     */
    private void br102NonEmptyDescriptions(ConceptSMTK conceptSMTK) {

        for (Description description : conceptSMTK.getDescriptions()) {
            String term = description.getTerm();
            if (term == null) {
                throw new BusinessRuleException("BR-TagSMTK-002", "El término de una descripción no puede ser nulo.");
            } else if (term.trim().equals("")) {
                throw new BusinessRuleException("BR-TagSMTK-002", "El término de una descripción no puede ser vacío.");
            }
        }
    }

    /**
     * Usuarios con rol de Diseñador o Modelador pueden crear conceptos de esta categoría.
     *
     * @param conceptSMTK El concepto a crear ser creado.
     * @param user        El usuario que realiza la acción.
     */
    protected void br001creationRights(ConceptSMTK conceptSMTK, User user) {

        /* Categorías restringidas para usuarios con rol diseñador */
        if (user.getProfiles().contains(DESIGNER_PROFILE)) {
            if (conceptSMTK.getCategory().isRestriction()) {
                throw new BusinessRuleException("BR-UNK", "El usuario " + user + " no tiene privilegios para editar la categoría " + conceptSMTK.getCategory());
            }
        }
    }



    private void br101HasFSN(ConceptSMTK conceptSMTK) {
        conceptSMTK.getDescriptionFSN();
    }
}
