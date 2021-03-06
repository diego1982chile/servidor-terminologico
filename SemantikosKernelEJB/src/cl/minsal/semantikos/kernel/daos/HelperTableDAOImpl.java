package cl.minsal.semantikos.kernel.daos;


import cl.minsal.semantikos.kernel.util.ConnectionBD;
import cl.minsal.semantikos.model.helpertables.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.*;

import java.io.IOException;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blueprints on 9/16/2015.
 */
@Stateless
public class HelperTableDAOImpl implements Serializable, HelperTableDAO {

    /** Logger de la clase */
    private static final Logger logger = LoggerFactory.getLogger(HelperTableDAOImpl.class);


    @EJB
    HelperTableRecordFactory helperTableRecordFactory;

    @Override
    public List<HelperTable> getAllTables() {

        ConnectionBD connectionBD = new ConnectionBD();
        String selectRecord = "{call semantikos.get_helper_tables()}";
        List<HelperTable> recordFromJSON;
        try (Connection connection = connectionBD.getConnection();
             CallableStatement call = connection.prepareCall(selectRecord)) {

            /* Se prepara y realiza la consulta */
            call.execute();
            ResultSet rs = call.getResultSet();
            if (rs.next()) {
                recordFromJSON = this.helperTableRecordFactory.createHelperTablesFromJSON(rs.getString(1));

                for (HelperTable table: recordFromJSON) {
                    if(table.getColumns()==null)
                        table.setColumns(new ArrayList<HelperTableColumn>());
                }

            } else {
                throw new EJBException("Error imposible en HelperTableDAOImpl");
            }
            rs.close();
        } catch (SQLException e) {
            logger.error("Hubo un error al acceder a la base de datos.", e);
            throw new EJBException(e);
        } catch (IOException e) {
            logger.error("Hubo un error procesar los resultados con JSON.", e);
            throw new EJBException(e);
        }

        return recordFromJSON;
    }


    @Override
    public HelperTableColumn createColumn(HelperTableColumn column) {

        ConnectionBD connect = new ConnectionBD();
        String UPDATE = "{call semantikos.create_helper_table_column(?,?,?,?,?,?)}";

        try (Connection connection = connect.getConnection();
             CallableStatement call = connection.prepareCall(UPDATE)) {

            call.setLong(1, column.getHelperTableDataTypeId());
            call.setLong(2, column.getHelperTableId());
            call.setLong(3, column.getForeignKeyHelperTableId());
            call.setString(4,  column.getName());
            call.setBoolean(5,column.isForeignKey());
            call.setString(6,column.getDescription());

            ResultSet rs = call.executeQuery();

            if (rs.next()) {
                column.setId(rs.getLong(1));
            } else {
                String errorMsg = "La columna no fue creada. Esta es una situación imposible. Contactar a Desarrollo";
                logger.error(errorMsg);
                throw new IllegalArgumentException(errorMsg);
            }

        } catch (SQLException e) {
            logger.error("Error al crear la columnas:" + column, e);
        }

        return column;
    }

    @Override
    public HelperTableColumn updateColumn(HelperTableColumn column) {

        // update_helper_table_column

        ConnectionBD connect = new ConnectionBD();
        String UPDATE = "{call semantikos.update_helper_table_column(?,?,?,?,?,?,?)}";

        try (Connection connection = connect.getConnection();
             CallableStatement call = connection.prepareCall(UPDATE)) {

            call.setLong(1, column.getId());
            call.setLong(2, column.getHelperTableDataTypeId());
            call.setLong(3, column.getHelperTableId());
            call.setLong(4, column.getForeignKeyHelperTableId());
            call.setString(5,  column.getName());
            call.setBoolean(6,column.isForeignKey());
            call.setString(7,column.getDescription());

            call.execute();
        } catch (SQLException e) {
            logger.error("Error al actualizar columna:" + column, e);
        }

        return column;

    }


    @Override
    public List<HelperTableDataType> getAllDataTypes(){

        ConnectionBD connectionBD = new ConnectionBD();
        String selectRecord = "{call semantikos.get_helper_table_data_types()}";
        List<HelperTableDataType> recordFromJSON;
        try (Connection connection = connectionBD.getConnection();
             CallableStatement call = connection.prepareCall(selectRecord)) {

            /* Se prepara y realiza la consulta */
            call.execute();
            ResultSet rs = call.getResultSet();
            if (rs.next()) {
                recordFromJSON = this.helperTableRecordFactory.createHelperTablesDataTypesFromJSON(rs.getString(1));
            } else {
                throw new EJBException("Error imposible en HelperTableDAOImpl");
            }
            rs.close();
        } catch (SQLException e) {
            logger.error("Hubo un error al acceder a la base de datos.", e);
            throw new EJBException(e);
        } catch (IOException e) {
            logger.error("Hubo un error procesar los resultados con JSON.", e);
            throw new EJBException(e);
        }

        return recordFromJSON;
    }



    @Override
    public List<HelperTableRow> getTableRows(long tableId) {

        ConnectionBD connectionBD = new ConnectionBD();
        String selectRecord = "{call semantikos.get_helper_table_rows(?)}";
        List<HelperTableRow> recordFromJSON;
        try (Connection connection = connectionBD.getConnection();
             CallableStatement call = connection.prepareCall(selectRecord)) {

            call.setLong(1,tableId);
            /* Se prepara y realiza la consulta */
            call.execute();
            ResultSet rs = call.getResultSet();
            if (rs.next()) {

                String json = rs.getString(1);
                if(json==null)
                    return new ArrayList<>();

                recordFromJSON = this.helperTableRecordFactory.createHelperTableRowsFromJSON(json);

            } else {
                throw new EJBException("Error imposible en HelperTableDAOImpl");
            }
            rs.close();
        } catch (SQLException e) {
            logger.error("Hubo un error al acceder a la base de datos.", e);
            throw new EJBException(e);
        } catch (IOException e) {
            logger.error("Hubo un error procesar los resultados con JSON.", e);
            throw new EJBException(e);
        }

        return recordFromJSON;
    }

    @Override
    public List<HelperTableRow> getValidTableRows(long tableId) {

        ConnectionBD connectionBD = new ConnectionBD();
        String selectRecord = "{call semantikos.get_valid_helper_table_rows(?)}";
        List<HelperTableRow> recordFromJSON;
        try (Connection connection = connectionBD.getConnection();
             CallableStatement call = connection.prepareCall(selectRecord)) {

            call.setLong(1,tableId);
            /* Se prepara y realiza la consulta */
            call.execute();
            ResultSet rs = call.getResultSet();
            if (rs.next()) {

                String json = rs.getString(1);
                if(json==null)
                    return new ArrayList<>();

                recordFromJSON = this.helperTableRecordFactory.createHelperTableRowsFromJSON(json);

            } else {
                throw new EJBException("Error imposible en HelperTableDAOImpl");
            }
            rs.close();
        } catch (SQLException e) {
            logger.error("Hubo un error al acceder a la base de datos.", e);
            throw new EJBException(e);
        } catch (IOException e) {
            logger.error("Hubo un error procesar los resultados con JSON.", e);
            throw new EJBException(e);
        }

        return recordFromJSON;
    }

    /*
    crea solo el elemento de la fila sin las celdas
     */
    @Override
    public HelperTableRow createRow(HelperTableRow row) {

        ConnectionBD connect = new ConnectionBD();
        String UPDATE = "{call semantikos.create_helper_table_row(?,?,?,?,?,?,?,?)}";

        try (Connection connection = connect.getConnection();
             CallableStatement call = connection.prepareCall(UPDATE)) {


            call.setLong(1, row.getHelperTableId());
            call.setString(2, row.getDescription());
            call.setDate(3, new Date(row.getCreationDate().getTime()));
            call.setString(4, row.getCreationUsername());
            call.setDate(5, new Date(row.getLastEditDate().getTime()));
            call.setString(6, row.getLastEditUsername());
            call.setDate(7, row.getValidityUntil()!=null?new Date(row.getValidityUntil().getTime()):null);
            call.setBoolean(8, row.isValid());

            ResultSet rs = call.executeQuery();



            if (rs.next()) {
                row.setId(rs.getLong(1));
            } else {
                String errorMsg = "La columna no fue creada. Esta es una situación imposible. Contactar a Desarrollo";
                logger.error(errorMsg);
                throw new IllegalArgumentException(errorMsg);
            }

        } catch (SQLException e) {
            logger.error("Error al crear la row:" + row, e);
        }

        return row;
    }

    @Override
    public HelperTableData createData(HelperTableData cell) {


        ConnectionBD connect = new ConnectionBD();
        String UPDATE = "{call semantikos.create_helper_table_data(?,?,?,?,?,?,?,?)}";

        try (Connection connection = connect.getConnection();
             CallableStatement call = connection.prepareCall(UPDATE)) {

            call.setString(1, cell.getStringValue());
            call.setDate(2, cell.getDateValue()==null?null:new Date(cell.getDateValue().getTime()));


            if(cell.getFloatValue()==null)
                call.setNull(3, Types.NUMERIC);
            else
                call.setDouble(3, cell.getFloatValue());

            call.setLong(4, cell.getIntValue());
            call.setBoolean(5,cell.isBooleanValue());
            call.setLong(6, cell.getForeignKeyValue());
            call.setLong(7,cell.getRowId());
            call.setLong(8,cell.getColumnId());



            ResultSet rs = call.executeQuery();

            if (rs.next()) {
                cell.setId(rs.getLong(1));
            } else {
                String errorMsg = "La columna no fue creada. Esta es una situación imposible. Contactar a Desarrollo";
                logger.error(errorMsg);
                throw new IllegalArgumentException(errorMsg);
            }


        } catch (SQLException e) {
            logger.error("Error al crear la row:" + cell, e);
        }

        return cell;

    }


    private HelperTableData updateData(HelperTableData cell) {


        ConnectionBD connect = new ConnectionBD();
        String UPDATE = "{call semantikos.update_helper_table_data(?,?,?,?,?,?,?)}";

        try (Connection connection = connect.getConnection();
             CallableStatement call = connection.prepareCall(UPDATE)) {

            call.setLong(1, cell.getId());
            call.setString(2, cell.getStringValue());
            call.setDate(3, cell.getDateValue()==null?null:new Date(cell.getDateValue().getTime()));

            if(cell.getFloatValue()==null)
                call.setNull(4, Types.NUMERIC);
            else
                call.setDouble(4, cell.getFloatValue());

            call.setLong(5, cell.getIntValue());
            call.setBoolean(6,cell.isBooleanValue());
            call.setLong(7, cell.getForeignKeyValue());


            ResultSet rs = call.getResultSet();


        } catch (SQLException e) {
            logger.error("Error al crear la row:" + cell, e);
        }

        return cell;


    }


    @Override
    public HelperTableRow getRowById(long id) {
        ConnectionBD connectionBD = new ConnectionBD();
        String selectRecord = "{call semantikos.get_helper_table_row(?)}";
        List<HelperTableRow> recordFromJSON;
        try (Connection connection = connectionBD.getConnection();
             CallableStatement call = connection.prepareCall(selectRecord)) {

            call.setLong(1,id);
            /* Se prepara y realiza la consulta */
            call.execute();
            ResultSet rs = call.getResultSet();
            if (rs.next()) {

                String json = rs.getString(1);
                if(json==null)
                    return null;

                recordFromJSON = this.helperTableRecordFactory.createHelperTableRowsFromJSON(json);
                if(recordFromJSON==null)
                    throw new EJBException("Error imposible en HelperTableDAOImpl");
            } else {
                throw new EJBException("Error imposible en HelperTableDAOImpl");
            }
            rs.close();
        } catch (SQLException e) {
            logger.error("Hubo un error al acceder a la base de datos.", e);
            throw new EJBException(e);
        } catch (IOException e) {
            logger.error("Hubo un error procesar los resultados con JSON.", e);
            throw new EJBException(e);
        }

        return recordFromJSON.get(0);
    }

    /*
    actualiza una fila y sus celdas
     */
    @Override
    public HelperTableRow updateRow(HelperTableRow row) {


        for (HelperTableData cell: row.getCells() ) {
            updateData(cell);
        }

        ConnectionBD connect = new ConnectionBD();
        String UPDATE = "{call semantikos.update_helper_table_row(?,?,?,?,?,?,?,?,?)}";

        try (Connection connection = connect.getConnection();
             CallableStatement call = connection.prepareCall(UPDATE)) {

            call.setLong(1, row.getId());
            call.setLong(2, row.getHelperTableId());
            call.setString(3, row.getDescription());
            call.setDate(4, new Date(row.getCreationDate().getTime()));
            call.setString(5, row.getCreationUsername());
            call.setDate(6, new Date(row.getLastEditDate().getTime()));
            call.setString(7, row.getLastEditUsername());
            call.setDate(8, row.getValidityUntil()==null?null:new Date(row.getValidityUntil().getTime()));
            call.setBoolean(9, row.isValid());


            ResultSet rs = call.executeQuery();

        } catch (SQLException e) {
            logger.error("Error al crear la row:" + row, e);
        }

        return row;

    }

    @Override
    public HelperTable getHelperTableByID(long tableId) {
        ConnectionBD connectionBD = new ConnectionBD();
        String selectRecord = "{call semantikos.get_helper_table(?)}";
        List<HelperTable> recordFromJSON;
        try (Connection connection = connectionBD.getConnection();
             CallableStatement call = connection.prepareCall(selectRecord)) {

            /* Se prepara y realiza la consulta */

            call.setLong(1,tableId);
            call.execute();
            ResultSet rs = call.getResultSet();
            if (rs.next()) {
                recordFromJSON = this.helperTableRecordFactory.createHelperTablesFromJSON(rs.getString(1));
                for (HelperTable table: recordFromJSON) {
                    if(table.getColumns()==null)
                        table.setColumns(new ArrayList<HelperTableColumn>());
                }
            } else {
                throw new EJBException("Error imposible en HelperTableDAOImpl");
            }
            rs.close();
        } catch (SQLException e) {
            logger.error("Hubo un error al acceder a la base de datos.", e);
            throw new EJBException(e);
        } catch (IOException e) {
            logger.error("Hubo un error procesar los resultados con JSON.", e);
            throw new EJBException(e);
        }

        return recordFromJSON.get(0);
    }

    @Override
    public List<HelperTableRow> searchRecords(HelperTable helperTable, String pattern) {
        ConnectionBD connectionBD = new ConnectionBD();
        String selectRecord = "{call semantikos.get_helper_table_rows(?,?)}";
        List<HelperTableRow> recordFromJSON;
        try (Connection connection = connectionBD.getConnection();
             CallableStatement call = connection.prepareCall(selectRecord)) {

            call.setLong(1,helperTable.getId());
            call.setString(2,pattern);

            /* Se prepara y realiza la consulta */
            call.execute();
            ResultSet rs = call.getResultSet();
            if (rs.next()) {

                String json = rs.getString(1);
                if(json==null)
                    return new ArrayList<>();

                recordFromJSON = this.helperTableRecordFactory.createHelperTableRowsFromJSON(json);

            } else {
                throw new EJBException("Error imposible en HelperTableDAOImpl");
            }
            rs.close();
        } catch (SQLException e) {
            logger.error("Hubo un error al acceder a la base de datos.", e);
            throw new EJBException(e);
        } catch (IOException e) {
            logger.error("Hubo un error procesar los resultados con JSON.", e);
            throw new EJBException(e);
        }

        return recordFromJSON;
    }
}