package cl.minsal.semantikos.kernel.components;

import cl.minsal.semantikos.model.User;
import cl.minsal.semantikos.model.helpertables.*;
import cl.minsal.semantikos.model.relationships.Target;

import java.io.Reader;
import java.util.Collection;
import java.util.List;

/**
 * Created by BluePrints Developer on 09-01-2017.
 */
public interface HelperTablesManager {
    HelperTable getById(long id);

    List<HelperTable> findAll();

    HelperTableColumn updateColumn(HelperTableColumn column);

    List<HelperTableDataType> getAllDataTypes();

    HelperTableColumn createColumn(HelperTableColumn column);

    List<HelperTableRow> getTableRows(long tableId);

    /*
    crea una nueva fila con campos por defecto para la tabla proporcionada

     */
    HelperTableRow createRow(Long tableId, String username);

    HelperTableRow updateRow(HelperTableRow row, String username);

    HelperTableRow getRowById(long idRow);

    /**
     * Este método es responsable de recuperar registros de una tabla auxiliar de acuerdo a un patrón de búsqueda sobre
     * una de sus descripcion.
     *
     * @param helperTable La tabla sobre la cual se realiza la búsqueda.
     * @param pattern     El patrón utilizado para la búsqueda.
     *
     * @return La lista de registros en la tabla <code>helperTable</code> que cumplen con el <code>pattern</code> de
     * búsqueda.
     */
    List<HelperTableRow> searchRows(HelperTable helperTable, String pattern);


    HelperTableImportReport loadFromFile(HelperTable helperTable, LoadMode loadModeSelected, Reader in, User loggedUser);


    List<HelperTableRow> getValidTableRows(long id);

    List<HelperTable> getFullDatabase();

}
