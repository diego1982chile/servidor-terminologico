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

    private static String toString(RespuestaBuscarTerminoGenerica.DescripcionesPerfectMatch descripcionesPerfectMatch) {
        StringBuilder result = new StringBuilder("[");
        for (DescripcionPerfectMatch descripcionPerfectMatch : descripcionesPerfectMatch.getDescripcionPerfectMatch()) {
            result.append(descripcionPerfectMatch);
        }

        return result.append("]").toString();
    }
}
