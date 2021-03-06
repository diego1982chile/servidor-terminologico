package cl.minsal.semantikos.kernel.components;


import cl.minsal.semantikos.kernel.daos.HelperTableDAO;
import cl.minsal.semantikos.model.User;
import cl.minsal.semantikos.model.helpertables.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by BluePrints Developer on 14-12-2016.
 */

@Stateless
public class HelperTablesManagerImpl implements HelperTablesManager {

    private static final Logger logger = LoggerFactory.getLogger(HelperTablesManagerImpl.class);

    @EJB
    HelperTableDAO dao;

    @Override
    public HelperTable getById(long id) {
        return dao.getHelperTableByID(id);
    }

    @Override
    public List<HelperTable> findAll() {
        return dao.getAllTables();
    }


    @Override
    public HelperTableColumn updateColumn(HelperTableColumn column) {
        return dao.updateColumn(column);
    }

    @Override
    public List<HelperTableDataType> getAllDataTypes(){
        return dao.getAllDataTypes();
    }

    @Override
    public HelperTableColumn createColumn(HelperTableColumn column) {


        HelperTableColumn createdColumn = dao.createColumn(column);



        return createdColumn;
    }

    @Override
    public List<HelperTableRow> getTableRows(long tableId) {
        return dao.getTableRows(tableId);
    }



    @Override
    public HelperTableRow createRow(Long tableId, String username) {
        HelperTable table= getById(tableId);

        HelperTableRow newRow = new HelperTableRow();

        newRow.setCreationDate(new Date());
        newRow.setCreationUsername(username);
        newRow.setLastEditDate(new Date());
        newRow.setLastEditUsername(username);

        newRow.setDescription("Nuevo Elemento");
        newRow.setValid(false);
        newRow.setHelperTableId(table.getId());

        newRow = dao.createRow(newRow);

        newRow.setCells(new ArrayList<HelperTableData>());
        for (HelperTableColumn column: table.getColumns()) {
            HelperTableData data = createCell(column,newRow);
        }

        return dao.getRowById(newRow.getId());
    }


    private HelperTableData createCell(HelperTableColumn column, HelperTableRow row) {
        HelperTableData data = new HelperTableData();
        data.setColumn(column);
        data.setColumnId(column.getId());
        data.setRow(row);
        data.setRowId(row.getId());


        return dao.createData(data);
    }

    @Override
    public HelperTableRow updateRow(HelperTableRow row, String username) {

        row.setLastEditDate(new Date());
        row.setLastEditUsername(username);

        return dao.updateRow(row);
    }

    @Override
    public HelperTableRow getRowById(long idRow) {
        return dao.getRowById(idRow);
    }

    @Override
    public List<HelperTableRow> searchRows(HelperTable helperTable, String pattern) {
        return dao.searchRecords( helperTable, pattern);
    }

    @Override
    public HelperTableImportReport loadFromFile(HelperTable helperTable, LoadMode loadModeSelected, Reader in, User loggedUser) {
        throw new NotImplementedException();
    }

    @Override
    public List<HelperTableRow> getValidTableRows(long id) {
        return dao.getValidTableRows(id);
    }

    @Override
    public List<HelperTable> getFullDatabase() {
        List<HelperTable> tables= dao.getAllTables();

        for (HelperTable table : tables) {
            table.setRows(getTableRows(table.getId()));
        }

        return tables;
    }
}
