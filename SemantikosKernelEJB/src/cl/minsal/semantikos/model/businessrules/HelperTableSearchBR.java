package cl.minsal.semantikos.model.businessrules;

import cl.minsal.semantikos.model.exceptions.BusinessRuleException;
import cl.minsal.semantikos.model.helpertables.HelperTable;
import cl.minsal.semantikos.model.helpertables.HelperTableColumn;

/**
 * @author Andrés Farías on 11/11/16.
 */
public class HelperTableSearchBR {

    /** Mínima cantidad de caracteres en el patrón de búsqueda en tablas auxiliares */
    public short MINIMUM_PATTERN_LENGTH = 2;

    /**
     * Método para realizar las validaciones.
     *
     * @param helperTable La tabla Auxiliar que se desea validar.
     * @param columnName  El nombre de la columna en la que se desea realizar la búsqueda.
     * @param pattern     El patrón de búsqueda.
     *
     * @throws cl.minsal.semantikos.model.exceptions.BusinessRuleException Si alguna regla de negocio no se cumple.
     */
    public void validatePreConditions(HelperTable helperTable, String columnName, String pattern) {

        /* La columna debe existir */
        precondition01(helperTable, columnName);

        /* La columna debe ser buscable */
        precondition02(helperTable, columnName);

        /* El patrón de búsqueda sobre la columna debe ser mayor a dos caracteres */
        precondition03(pattern);
    }

    /**
     * La tabla debe tener una columna con el nombre dado.
     *
     * @param helperTable La tabla auxiliar sobre la cual se realiza la validación.
     * @param columnName  El nombre de la columna que debe contener.
     */
    protected void precondition01(HelperTable helperTable, String columnName) {

        if (!helperTable.getAllColumnsNames().contains(columnName)) {
            throw new BusinessRuleException("HelperTable BR-PC01: La tabla auxiliar " + helperTable + " no posee una columna de nombre " + columnName + " sobre la cual realizar las búsquedas");
        }
    }

    /**
     * La tabla debe tener una columna con el nombre dado que sea buscable.
     *
     * @param helperTable La tabla auxiliar sobre la cual se realiza la validación.
     * @param columnName  El nombre de la columna que debe contener.
     */
    protected void precondition02(HelperTable helperTable, String columnName) {

        /* Se recupera la columna de la tabla auxiliar */
        HelperTableColumn helperTableColumn = helperTable.getColumnByName(columnName);

        /* Se valida que la columna sea buscable */
        if (!helperTableColumn.isSearchable()) {
            throw new BusinessRuleException("HelperTable BR-PC02: La columna " + columnName + " no está definida como buscable para la tabla auxiliar " + helperTable);
        }
    }

    /**
     * El patrón de búsqueda debe ser de al menos dos caracteres.
     *
     * @param pattern El patrón de búsqueda.
     */
    protected void precondition03(String pattern) {
        if ((pattern == null) || pattern.length() < MINIMUM_PATTERN_LENGTH) {
            throw new BusinessRuleException("HelperTable BR-PC03: El patrón de búsqueda sobre tablas auxiliares debe tener un largo mínimo de " + MINIMUM_PATTERN_LENGTH + " caracteres.")
        }
    }
}
