package cl.minsal.semantikos.ws.shared;

/**
 * @author Andrès Farías on 11-01-17.
 */
public class HTMLer {
    public static String toHTML(RespuestaConceptosPorCategoria.Conceptos serviceResponse) {
        StringBuilder result = new StringBuilder("<ul>");
        for (Concepto concepto : serviceResponse.getConcepto()) {
            result.append("<li>" + Stringer.toString(concepto) + "</li>");
        }
        return result.append("</ul>").toString();
    }
}
