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

        result.append(toHTML(concepto.getRelaciones()));

        return result.toString();
    }

    /**
     * Este método imprime las relaciones de un concepto en una expresión HTML.
     *
     * @param relaciones Las relaciones a listar.
     * @return La expresión HTML para las relaciones.
     */
    private static String toHTML(Concepto.Relaciones relaciones) {
        if (relaciones == null || relaciones.getRelacion() == null || relaciones.getRelacion().isEmpty()) {
            return "<em>Sin Relaciones</em>.<p/>";
        }

        StringBuilder result = new StringBuilder("Relaciones:<br />\n<ol>");
        List<Relacion> theRelationships = relaciones.getRelacion();
        for (Relacion aRelationship : theRelationships) {
            result.append("<li>").append(aRelationship.getDefinicion().getName()).append("</li>");
        }
        return result.append("</ol>").toString();
    }

    private static String toHTML(Concepto.RefSets refSets) {

        if (refSets == null) {
            return "<em>Sin Refsets</em>.<p/>";
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
            return "<em>Sin crossmaps directos</em><p/>";
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

    /**
     * Este método es responsable de imprimir las descripciones de un concepto.
     *
     * @param descripciones Las descripciones a imprimir.
     * @return Una expresión HTML con una lista ordenada de las descripciones.
     */
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

    public static String toHTML(RespuestaBuscarTerminoGenerica.DescripcionPerfectMatch serviceResponse) {

        /* Se verifica si hay algo que imprimir */
        if (serviceResponse == null
                || serviceResponse.getDescripcionesPerfectMatch() == null
                || serviceResponse.getDescripcionesPerfectMatch().isEmpty()) {
            return "<em>No hay descripciónes con perfect match</em>";
        }

        StringBuilder result = new StringBuilder("<em>Perfect Match</em>: <br/>");
        result.append("<ol>\n");
        for (DescripcionAC description : serviceResponse.getDescripcionesPerfectMatch()) {
            result.append("<li>").append(toHTML(description)).append("</li>");
        }
        result.append("</ol>");

        return result.toString();
    }

    public static String toHTML(RespuestaBuscarTerminoGenerica.DescripcionesNoValidas descripcionesNoValidas) {

        /* Se verifica si hay algo que imprimir */
        if (descripcionesNoValidas == null
                || descripcionesNoValidas.getDescripcionNoValida() == null
                || descripcionesNoValidas.getDescripcionNoValida().isEmpty()) {
            return "<em>No se encontraron descripciones <b>No Válidas</b></em>";
        }

        StringBuilder result = new StringBuilder("<em>No Válidas</em>: <br/>");
        result.append("<ol>\n");
        for (DescripcionNoValida description : descripcionesNoValidas.getDescripcionNoValida()) {
            result.append("<li>").append(toHTML(description)).append("</li>");
        }
        result.append("</ol>");

        return result.toString();
    }

    public static String toHTML(RespuestaBuscarTerminoGenerica.DescripcionesPendientes descripcionesPendientes) {
 /* Se verifica si hay algo que imprimir */
        if (descripcionesPendientes == null
                || descripcionesPendientes.getDescripcionPendiente() == null
                || descripcionesPendientes.getDescripcionPendiente().isEmpty()) {
            return "<em>No se encontraron descripciones <b>Pendientes</b></em>";
        }

        StringBuilder result = new StringBuilder("<em>Pendientes</em>: <br/>");
        result.append("<ol>\n");
        for (DescripcionPendiente description : descripcionesPendientes.getDescripcionPendiente()) {
            result.append("<li>").append(toHTML(description)).append("</li>");
        }
        result.append("</ol>");

        return result.toString();
    }

    /**
     * Este método es responsable de imprimir una expresion de descripcion autocontenida.
     *
     * @param description La descripción a imprimir.
     * @return Un String con una expresión HTML que representa, en una línea, la descripción autocontenida.
     */
    private static String toHTML(DescripcionAC description) {

        StringBuilder result = new StringBuilder("<b>").append(description.getTermino()).append("</b> (").append
                (description.getTipoDescripcion()).append("). DESCRIPTION ID=").append(description.getDescriptionID());

        /* Info contextual ahora */
        result.append(", en Concept ID='").append(description.getConceptID()).append("' de la categoría '").append
                (description.getNombreCategoria()).append("', con Preferida = '").append(description
                .getTerminoPreferida()).append("' (").append(description.getDescriptionIDPreferida()).append(").");

        return result.toString();
    }

    private static String toHTML(DescripcionNoValida description) {
        StringBuilder result = new StringBuilder("<b>Razón</b>:<em>").append(description.getRazonNoValido()).append
                ("</em>. ").append("Valido: ").append(description.isValidez() ? "Si" : "No");

        /* Ahora se listan los sugeridos */
        DescripcionNoValida.DescripcionesSugeridas descripcionesSugeridas = description.getDescripcionesSugeridas();
        if (descripcionesSugeridas == null) {
            result.append("No hay descripciones sugeridas.");
        }
        result.append("<ul>");
        for (DescripcionAC descripcionAC : descripcionesSugeridas.getDescripcionSugerida()) {
            result.append("<li>Concept ID=").append(descripcionAC.getConceptID()).append(". Preferida DESC ID=")
                    .append(descripcionAC.getDescriptionIDPreferida());
        }
        result.append("</ul>");
        return result.toString();
    }

    private static String toHTML(DescripcionPendiente description) {
        StringBuilder result = new StringBuilder("<b>Pendiente para categoría '").append(description
                .getNombreCategoria()).append("'.");

        return result.toString();
    }

    public static String toHTML(RespuestaBuscarTermino.Conceptos serviceResponse) {

        if (serviceResponse == null){
            return "No se encontraron conceptos.";
        }

        StringBuilder result = new StringBuilder("<ol>");
        for (ConceptoLight conceptoLight : serviceResponse.getConcepto()) {
            result.append("\t<li>").append(toHTML(conceptoLight)).append("</li>\n");
        }
        result .append("</ol>");

        return result.toString();
    }

    private static String toHTML(ConceptoLight conceptoLight) {
        return conceptoLight.getConceptID() + ": " + conceptoLight.getDescripcionPreferida() + "(" + conceptoLight.getIdDescripcionPreferida() + ") -- <em>" + conceptoLight.getCategoria() + "</em>";
    }
}
