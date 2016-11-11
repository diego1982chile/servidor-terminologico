package cl.minsal.semantikos.model.businessrules;

import cl.minsal.semantikos.model.exceptions.BusinessRuleException;
import cl.minsal.semantikos.model.helpertables.HelperTable;
import cl.minsal.semantikos.model.helpertables.HelperTableColumn;

/**
 * @author Andrés Farías on 11/11/16.
 */
public class HelperTableSearchBR {

    public void validatePreConditions(HelperTable helperTable, String columnName, String pattern) {
        precondition01(helperTable, columnName);


        /* El patrón de búsqueda sobre la columna debe ser mayor a dos caracteres */

    }

    /**
     * La tabla debe tener una columna con el nombre dado.
     *
     * @param helperTable La tabla auxiliar sobre la cual se realiza la validación.
     * @param columnName  El nombre de la columna que debe contener.
     */
    private void precondition01(HelperTable helperTable, String columnName) {

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
    private void precondition02(HelperTable helperTable, String columnName) {

        HelperTableColumn helperTableColumn = helperTable.getColumnByName(columnName);
    }

}
