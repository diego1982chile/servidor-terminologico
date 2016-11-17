package cl.minsal.semantikos.model.businessrules;

import cl.minsal.semantikos.kernel.components.RelationshipManager;
import cl.minsal.semantikos.kernel.daos.ConceptDAO;
import cl.minsal.semantikos.model.ConceptSMTK;
import cl.minsal.semantikos.model.User;
import cl.minsal.semantikos.model.exceptions.BusinessRuleException;
import cl.minsal.semantikos.model.relationships.Relationship;
import cl.minsal.semantikos.model.relationships.SnomedCTRelationship;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.validation.constraints.NotNull;
import java.util.List;

import static cl.minsal.semantikos.model.ProfileFactory.MODELER_PROFILE;

/**
 * @author Andrés Farías on 9/8/16.
 */
@Singleton
public class RelationshipBindingBR {

    @EJB
    private RelationshipManager relationshipManager;

    /**
     * Este método es responsabled de realizar las validaciones de reglas de negocio.
     */
    public void verifyPreConditions(ConceptSMTK concept, Relationship relationship, User user) {

        /* Privilegios del usuario */
        brRelationshipBinding001(relationship, user);

        /* Que no se agreguen dos Snomed de tipo "ES UN MAPEDO DE" */
        brRelationshipBinding002(concept, relationship);

        /* Las relaciones de semantikos con Snomed CT son 1-1 */
        brRelationshipBinding003(concept, relationship);
    }

    /**
     * Este método gatilla todas las acciones relacionadas con la asociación de relaciones.
     * Un concepto que se elimina siempre es invalidado. Sólo si satisface una regla de negocio (BR-
     *
     * @param relationship La relación que se asoció.
     * @param conceptDAO   El DAO para realizar las acciones.
     */
    public void postActions(Relationship relationship, @NotNull ConceptDAO conceptDAO) {
        publishConceptBySCT(relationship, conceptDAO);
    }

    /**
     * Este método es responsable de implementar la regla de negocio BR-CON-004.
     * ﻿BR-CON-004 Solo un usuario con rol Modelador puede agregar una relación Snomed CT.
     *
     * @param relationship La relación en cuestión.
     * @param user         El usuario que realiza la asociación.
     */
    public void brRelationshipBinding001(Relationship relationship, User user) {
        if (relationship.getRelationshipDefinition().getTargetDefinition().isSnomedCTType() && !user.getProfiles().contains(MODELER_PROFILE)) {
            throw new BusinessRuleException("Solo el usuario con rol Modelador puede agregar relaciones de tipo Snomed CT.");
        }
    }

    /**
     * Este método es responsable de implmentar la regla de negocio BR-SCT-002.
     * <b>BR-SCT-002</b>: Si la relación que se agrega es de tipo “Es un Mapeo”, el sistema valida que el concepto no
     * tenga otra relación de tipo “Es un Mapeo”. Si la tuviese, debe indicar esto al usuario, y no se agrega la
     * relación ingresada.
     *
     * @param concept      El concepto al cual se quiere asociar la relación.
     * @param relationship La relación que se quiere asociar al concepto.
     */
    private void brRelationshipBinding002(ConceptSMTK concept, Relationship relationship) {

        /* Esta regla de negocio aplica sólo a relaciones de tipo SnomedCT */
        if (!relationship.getRelationshipDefinition().getTargetDefinition().isSnomedCTType()) {
            return;
        }

        /* Se transforma a una relación Snomed CT */
        SnomedCTRelationship snomedCTRelationship = (SnomedCTRelationship) relationship;

        /* Y se verifica que sup tipo sea "ES_UN_MAPEO DE" */
        if (!snomedCTRelationship.isES_UN_MAPEO_DE()) {
            return;
        }

        /* El concepto no debe tener más de una relación del tipo "ES UN MAPEO DE" */
        List<SnomedCTRelationship> relationshipsSnomedCT = concept.getRelationshipsSnomedCT();
        for (SnomedCTRelationship ctRelationship : relationshipsSnomedCT) {

            /* Si es la misma no se compara */
            if (ctRelationship == relationshipsSnomedCT) {
                continue;
            }

            /* Si la relación es del tipo ES UN MAPEO, viola la regla */
            if (ctRelationship.isES_UN_MAPEO_DE()) {
                throw new BusinessRuleException("BR-SCT-002: Si la relación que se agrega es de tipo “Es un Mapeo”, el " +
                        "sistema valida que el concepto no tenga otra relación de tipo “Es un Mapeo”. Si la tuviese, " +
                        "debe indicar esto al usuario, y no se agrega la relación ingresada.");
            }
        }
    }

    /**
     * <b>BR-SCT-001</b>: La Relación de Tipo “Es un Mapeo de” que asocia un Concepto de Semantikos con un Concepto de
     * SNOMED-CT; esta relación es uno a uno y es la que hereda el grado de definición de la tabla del Snapshot
     * conceptos de SNOMED CT.
     *
     * @param concept      El concepto al cual se desea agregar la relación.
     * @param relationship La relación que se desea agregar.
     */
    private void brRelationshipBinding003(ConceptSMTK concept, Relationship relationship) {

        /* Esta regla de negocio aplica sólo a relaciones de tipo SnomedCT */
        if (!relationship.getRelationshipDefinition().getTargetDefinition().isSnomedCTType()) {
            return;
        }

        /* Se transforma a una relación Snomed CT */
        SnomedCTRelationship snomedCTRelationship = (SnomedCTRelationship) relationship;

        /* Y se verifica que sup tipo sea "ES_UN_MAPEO DE" */
        if (!snomedCTRelationship.isES_UN_MAPEO_DE()) {
            return;
        }

        /* Ahora que sabemos que es una relación Snomed y de tipo ES UN MAPEO DE, se verifica que no exista otra
         * relación Snomed desde otro concepto al mismo concepto destino
         */

            /* Se recuperan todas las relaciones del mismo tipo de relación y que se dirigen al mismo concepto SCT */
        List<Relationship> relationshipsLike = relationshipManager.getRelationshipsLike(snomedCTRelationship.getRelationshipDefinition(), snomedCTRelationship.getTarget());
        for (Relationship relationshipCandidate : relationshipsLike) {
            ConceptSMTK candidateConcept = relationshipCandidate.getSourceConcept();

                /* Si es el mismo concepto, no importa */
            if (candidateConcept.equals(concept)) {
                continue;
            }

            throw new BusinessRuleException("La Relación de Tipo “Es un Mapeo de” que asocia un Concepto de Semantikos " +
                    "con un Concepto de SNOMED-CT; esta relación es uno a uno y es la que hereda el grado de definición " +
                    "de la tabla del Snapshot conceptos de SNOMED CT.");
        }
    }

    /**
     * <p>Este método implementa la post-acción definida por la regla de negocio BR-CON-003.</p>
     * ﻿<p>BR-CON-003: Concepto pasa de Borrador a Modelado cuando se mapea a SnomedCT.</p>
     *
     * @param relationship La relación que se agregó al concepto.
     * @param conceptDAO   El DAO para actualizar el estado.
     */
    private void publishConceptBySCT(Relationship relationship, ConceptDAO conceptDAO) {

        ConceptSMTK sourceConcept = relationship.getSourceConcept();
        boolean isSnomedCTType = relationship.getRelationshipDefinition().getTargetDefinition().isSnomedCTType();

        /* BL-MOD-001: Un término en Borrador pasará a Modelado cuando el usuario con Rol Modelador realice el
         * mapeo del concepto Semantikos a un concepto a SNOMED CT, o al menos realice una relación del tipo “Es un”.
         */
        if (!isSnomedCTType || sourceConcept.isModeled()) {
            return;
        }

        /* Si es una relación definitoria, se hace deja como modelada */
        SnomedCTRelationship sctRelationship = (SnomedCTRelationship) relationship;
        if (sctRelationship.isDefinitional()) {
            sourceConcept.setModeled(true);
            conceptDAO.update(sourceConcept);
        }
    }
}
