package cl.minsal.semantikos.ws.mapping;

import cl.minsal.semantikos.model.helpertables.HelperTableData;
import cl.minsal.semantikos.model.helpertables.HelperTableRecord;
import cl.minsal.semantikos.model.helpertables.HelperTableRow;
import cl.minsal.semantikos.model.relationships.Relationship;
import cl.minsal.semantikos.ws.response.ISPRegisterResponse;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Created by Development on 2016-12-30.
 *
 */
public class ISPRegisterMapper {

    public static ISPRegisterResponse map(@NotNull Relationship relationship) {
        if ( !relationship.getRelationshipDefinition().isBioequivalente() && !relationship.getRelationshipDefinition().isISP() ) {
            throw new IllegalArgumentException("Solo se permiten mapear relacioens Bioequivalente e ISP");
        }

        ISPRegisterResponse res = new ISPRegisterResponse();

        HelperTableRow helperTableRecord = (HelperTableRow) relationship.getTarget();
        List<HelperTableData> values = helperTableRecord.getCells();

        res.setRegistro(values.get("registro"));
        res.setName(values.get("nombre"));
        res.setDescription(values.get("description"));
        res.setValid(values.get("valid"));
        res.setValidityUntil(values.get("validity_until"));
        res.setEstadoDelRegistro(values.get("estado_del_registro"));
        res.setTitular(values.get("titular"));
        res.setReferenciaDeTramite(values.get("referencia_de_tramite"));
        res.setEquivalenciaTerapeutica(values.get("equivalencia_terapeutica"));
        res.setResolucionInscribase(values.get("resolucion_inscribase"));
        res.setFechaIngreso(values.get("creation_date"));
        res.setFechaInscribase(values.get("fecha_inscribase"));
        res.setUltimaRenovacion(values.get("ultima_renovacion"));
        res.setFechaProximaRenovacion(values.get("fecha_proxima_renovacion"));
        res.setRegimen(values.get("regimen"));
        res.setViaAdministracion(values.get("via_administracion"));
        res.setCondicionDeVenta(values.get("condicion_de_venta"));
        res.setExpendeTipoEstablecimiento(values.get("expende_tipo_establecimiento"));
        res.setIndicacion(values.get("indicacion"));

        return res;
    }

}
