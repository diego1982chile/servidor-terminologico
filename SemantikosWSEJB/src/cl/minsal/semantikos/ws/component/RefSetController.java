package cl.minsal.semantikos.ws.component;

import cl.minsal.semantikos.kernel.components.ConceptManager;
import cl.minsal.semantikos.kernel.components.RefSetManager;
import cl.minsal.semantikos.model.ConceptSMTK;
import cl.minsal.semantikos.model.RefSet;
import cl.minsal.semantikos.ws.fault.NotFoundFault;
import cl.minsal.semantikos.ws.mapping.RefSetMapper;
import cl.minsal.semantikos.ws.response.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Created by Development on 2016-11-18.
 *
 */
@Stateless
public class RefSetController {

    @EJB
    private RefSetManager refSetManager;

    @EJB
    private ConceptManager conceptManager;

    @EJB
    private ConceptController conceptController;

    public List<String> findRefSetsByDescriptions(@NotNull List<String> descriptionIds, Boolean includeInstitutions) throws NotFoundFault {
        // TODO: Implementar seguridad especificada en requerimientos y funcion del parametro includeInstitutions
        Set<String> res = new HashSet<>(descriptionIds.size());

        Set<ConceptSMTK> conceptSMTKS = new HashSet<>(descriptionIds.size());
        for ( String descriptionId : descriptionIds ) {
            try {
                conceptSMTKS.add(this.conceptManager.getConceptByDescriptionID(descriptionId));
            } catch (Exception e) {
                throw new NotFoundFault("Descripcion no encontrada: " + descriptionId);
            }
        }

        for ( ConceptSMTK conceptSMTK : conceptSMTKS ) {
            List<RefSet> refSets = refSetManager.findByConcept(conceptSMTK);
            if ( refSets != null ) {
                for ( RefSet refSet : refSets ) {
                    res.add(refSet.getName());
                }
            }
        }

        return new ArrayList<>(res);
    }

    public List<RefSet> findRefsets(List<String> refSetsNames) throws NotFoundFault {
        // TODO: Implementar seguridad especificada en requerimientos
        List<RefSet> refSets;
        if ( refSetsNames != null && !refSetsNames.isEmpty() ) {
            try {
                refSets = this.refSetManager.findRefSetsByName(refSetsNames);
            } catch (Exception e) {
                throw new NotFoundFault(e.getMessage());
            }
        } else {
            refSets = this.refSetManager.getAllRefSets();
        }
        return refSets;
    }

    public List<RefSetResponse> refSetList(Boolean includeAllInstitutions) throws NotFoundFault {
        // TODO considerar funcion del parametro includeAllInstitutions segun especificado en requerimientos
        List<RefSetResponse> res = new ArrayList<>();
        List<RefSet> refSets = this.refSetManager.getAllRefSets();
        if ( refSets != null ) {
            for ( RefSet refSet : refSets ) {
                res.add(this.getResponse(refSet));
            }
        }
        return res;
    }


    public RefSetResponse getResponse(RefSet refSet) throws NotFoundFault {
        if ( refSet == null ) {
            throw new NotFoundFault("RefSet no encontrado");
        }
        return RefSetMapper.map(refSet);
    }

}
