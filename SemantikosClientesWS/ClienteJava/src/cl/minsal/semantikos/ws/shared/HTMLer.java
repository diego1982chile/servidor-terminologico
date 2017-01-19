package cl.minsal.semantikos.ws.shared;

import com.sun.istack.internal.NotNull;
import com.sun.org.apache.regexp.internal.RE;

import java.util.List;

/**
 * @author Andrès Farías on 11-01-17.
 */
public class HTMLer {

    public static String toHTML(RespuestaConceptosPorCategoria.Conceptos serviceResponse) {
        StringBuilder result = new StringBuilder("<ul>");
        for (Concepto concepto : serviceResponse.getConcepto()) {
            result.append("<li>" + toHTML(concepto) + "</li>");
        }
        return result.append("</ul>").toString();
    }

    /**
     * Este es el metodo que imprime un objeto en formato HTML. Por ahora, en una sola linea.
     *
     * @param concepto El concepto que se desea imprimir.
     * @return Una expreison HTML que representa el concepto.
     */
    public static String toHTML(Concepto concepto) {
        /* Lo principal del concepto: preferida y categoría */
        StringBuilder result = new StringBuilder("Concepto <b>" + getPreferida(concepto) + "</b> &isin; ").append
                (concepto.getCategoria().getNombre()).append("<br/>");

        /* Luego sus descripciones */
        result.append(toHTML(concepto.getDescripciones()));

        /* Luego sus crossmaps */
        result.append(toHTML(concepto.getCrossmapsDirectos()));

        /* Luego sus refsets */
        result.append(toHTML(concepto.getRefSets()));

        return result.toString();
    }

    private static String toHTML(Concepto.RefSets refSets) {

        if (refSets == null) {
            return "<em>Sin Refsets</em>.";
        }

        StringBuilder result = new StringBuilder("Refsets:<br />\n<ol>");
        for (RefSet refSet : refSets.getRefSet()) {
            result.append("<li>").append(refSet.getNombre()).append(" (de ").append
                    (refSet.getInstitucion()).append(") ").append("</li>");
        }
        return result.append("</ol>").toString();

    }

    /**
     * Este método imprime una lista ordenada con los crossmaps directos del concepto.
     *
     * @param crossmapsDirectos Los crossmaps directos del concepto.
     * @return Una expresion HTML con los crossmaps.
     */
    private static String toHTML(Concepto.CrossmapsDirectos crossmapsDirectos) {

        if (crossmapsDirectos == null) {
            return "<em>Sin crossmaps directos</em>";
        }

        StringBuilder result = new StringBuilder("Crossmaps Directos:<br />\n<ol>");
        for (CrossmapSetMember crossmapSetMember : crossmapsDirectos.getCrossmapDirecto()) {
            result.append("<li>").append(crossmapSetMember.getCrossmapSet().getName()).append(": ").append
                    (crossmapSetMember.getGloss()).append(" (").append(crossmapSetMember.getCode()).append(").")
                    .append("</li>");
        }
        return result.append("</ol>").toString();
    }

    /**
     * Este metodo permite recuperar la descripcion preferida del concepto.
     *
     * @param concepto El concepto cuya descripcion preferida se desea recuperar.
     * @return La descripcion preferida del concepto.
     */
    private static String getPreferida(Concepto concepto) {

        StringBuilder result = new StringBuilder("");
        Concepto.Descripciones descripciones = concepto.getDescripciones();
        for (Descripcion descripcion : descripciones.getDescripcion()) {
            if (descripcion.getTipo().equals("preferida")) {
                return descripcion.getTermino();
            }
        }

        return "Sin Preferida";
    }

    public static String toHTML(RespuestaConceptosPorCategoria serviceResponse) {
        if (serviceResponse == null) {
            return "Sin conceptos que mostrar!";
        } else {
            List<Concepto> conceptos = serviceResponse.getConceptos().getConcepto();
            StringBuilder result = new StringBuilder(conceptos.size() + "conceptos retornados; <br/>");
            result.append("<ol>");
            for (Concepto concepto : conceptos) {
                result.append("\t<li>").append(concepto.getId()).append(": ").append(toHTML(concepto.getDescripciones
                        ()));

                Concepto.CrossmapsIndirectos crossmapsIndirectos = concepto.getCrossmapsIndirectos();
                if (crossmapsIndirectos == null) {
                    continue;
                }

                List<IndirectCrossmap> crossmapIndirecto = crossmapsIndirectos.getCrossmapIndirecto();
                if (crossmapIndirecto != null && crossmapIndirecto.size() > 0) {
                    result.append("CrossInd: {");
                    for (IndirectCrossmap indirectCrossmap : crossmapIndirecto) {
                        result.append(indirectCrossmap.getCorrelation());
                    }
                    result.append("}");
                }

                result.append("\t</li>");
            }
            result.append("</ol>");

            return result.toString();
        }
    }

    private static String toHTML(Concepto.Descripciones descripciones) {

        StringBuilder result = new StringBuilder("Descripciones: <br/>\n<ol>");
        for (Descripcion descripcion : descripciones.getDescripcion()) {
            result.append("<li>").append(descripcion.getTermino()).append(" (DESCRIPTION_ID=").append(descripcion
                    .getId()).append(")").append("</li>");
        }

        return result.append("\n</ol>").toString();
    }

    /**
     * Este metodo permite imprimir categorias.
     *
     * @param response El objeto que contiene las categorias.
     * @return Una expresion HTML que representa las categorias.
     */
    public static String toHTML(@NotNull RespuestaCategorias response) {

        /* Caso sin categorías */
        RespuestaCategorias.Categorias categorias = response.getCategorias();
        if (categorias == null) {
            return "<b>No</b> hay categorías en el sistema!";
        }

        StringBuilder result = new StringBuilder("<ol>\n");
        for (Categoria categoria : categorias.getCategoria()) {
            result.append("<li>").append(categoria.getNombre()).append(" (").append(categoria.getNombreAbreviado())
                    .append(")</li>");
        }

        return result.append("\n</ol>").toString();
    }

    public static String toHTML(RespuestaBuscarTerminoGenerica.DescripcionesPerfectMatch serviceResponse) {

        /* Se verifica si hay algo que imprimir */
        if (serviceResponse == null
                || serviceResponse.getDescripcionPerfectMatch() == null
                || serviceResponse.getDescripcionPerfectMatch().isEmpty()) {
            return "<em>No hay descripciónes con perfect match</em>";
        }

        StringBuilder result = new StringBuilder("<em>Perfect Match</em>: <br/><ol>");
        for (DescripcionPerfectMatch description : serviceResponse.getDescripcionPerfectMatch()) {
            result.append("<li>").append(description.getTermino()).append(", ID=").append(description
                    .getIdDescripcion()).append("</li>");
        }
        return result.append("</ol>").toString();
    }
}
