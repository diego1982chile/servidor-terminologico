package cl.minsal.semantikos.ws.shared;

import java.util.List;

/**
 * @author Andres Farias on 09-01-17.
 */
public class Stringer {

    public static String toString(RespuestaBuscarTerminoGenerica respuestaBuscarTerminoGenerica) {

        RespuestaBuscarTerminoGenerica.DescripcionesPerfectMatch descripcionesPerfectMatch = respuestaBuscarTerminoGenerica.getDescripcionesPerfectMatch();

        return "Perfect match (" + descripcionesPerfectMatch.getDescripcionPerfectMatch().size() + "): " + descripcionesPerfectMatch.getDescripcionPerfectMatch() + ", No validas: " + Stringer.toString(respuestaBuscarTerminoGenerica.getDescripcionesNoValidas());
    }

    private static String toString(RespuestaBuscarTerminoGenerica.DescripcionesNoValidas descripcionesNoValidas) {
        StringBuilder result = new StringBuilder("[");
        for (DescripcionNoValida descripcionNoValida : descripcionesNoValidas.getDescripcionNoValida()) {
            result.append(descripcionNoValida);
        }

        return result.append("]").toString();
    }

    public static String toString(RespuestaBuscarTerminoGenerica.DescripcionesPerfectMatch descripcionesPerfectMatch) {
        StringBuilder result = new StringBuilder("[");
        for (DescripcionPerfectMatch descripcionPerfectMatch : descripcionesPerfectMatch.getDescripcionPerfectMatch()) {
            result.append(descripcionPerfectMatch);
        }

        return result.append("]").toString();
    }

    public static String toString(RespuestaConceptosPorCategoria.Conceptos conceptosResponse) {
        StringBuilder result = new StringBuilder("[");
        for (Concepto aConcept : conceptosResponse.getConcepto()) {
            result.append(aConcept);
        }

        return result.append("]").toString();
    }

    public static String toString(PeticionPorCategoria peticion) {
        StringBuilder result = new StringBuilder("[");
        result.append("Categoría='").append(peticion.getNombreCategoria());
        result.append(";ID Establecimiento=").append(peticion.getIdEstablecimiento());

        return result.append("]").toString();
    }

    public static String toString(PeticionBuscarTermino peticion) {
        StringBuilder result = new StringBuilder("[");
        result.append("Term='").append(peticion.getTermino());
        result.append(", Categoría='").append(peticion.getNombreCategoria());
        result.append(", RefSets='").append(peticion.getNombreRefSet());
        //result.append(", ID Establecimiento=").append(peticion.getIdEstablecimiento());

        return result.append("]").toString();
    }

    public static String toString(RespuestaConceptosPorCategoria response) {
        StringBuilder result = new StringBuilder("[");

        RespuestaConceptosPorCategoria.Conceptos conceptos = response.getConceptos();
        for (Concepto concepto : conceptos.getConcepto()) {
            result.append(toString(concepto));
        }

        return result.append("]").toString();
    }

    protected static String toString(Concepto concepto) {
        return "Concepto[" + concepto.getId() + "]";
    }

    protected static String toString(ConceptoLight concepto) {
        return "Concepto[" + concepto.getConceptID() + "]";
    }

    public static String toString(RespuestaBuscarTermino response) {
        StringBuilder result = new StringBuilder("[");

        RespuestaBuscarTermino.Conceptos conceptos = response.getConceptos();
        for (ConceptoLight concepto : conceptos.getConcepto()) {
            result.append(toString(concepto));
        }

        return result.append("]").toString();
    }
}
