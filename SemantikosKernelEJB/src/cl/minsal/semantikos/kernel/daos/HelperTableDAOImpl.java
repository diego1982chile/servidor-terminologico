package cl.minsal.semantikos.kernel.daos;


import cl.minsal.semantikos.kernel.util.ConnectionBD;
import cl.minsal.semantikos.model.helpertables.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.io.Serializable;
import java.sql.*;
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
    public List<HelperTable> findAll() {

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
    public HelperTableColumn updateColumn(HelperTableColumn column) {

        // update_helper_table_column

        ConnectionBD connect = new ConnectionBD();
        String UPDATE = "{call semantikos.update_helper_table_column(?,?,?,?,?,?)}";

        try (Connection connection = connect.getConnection();
             CallableStatement call = connection.prepareCall(UPDATE)) {

            call.setLong(1, column.getId());
            call.setLong(2, column.getHelperTableDataTypeId());
            call.setLong(3, column.getHelperTableId());
            call.setLong(4, column.getForeignKeyHelperTableId());
            call.setString(5,  column.getName());
            call.setBoolean(6,column.isForeignKey());

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
    public HelperTableColumn createColumn(HelperTableColumn column) {
        // update_helper_table_column

        ConnectionBD connect = new ConnectionBD();
        String UPDATE = "{call semantikos.update_helper_table_column(?,?,?,?,?,?)}";

        try (Connection connection = connect.getConnection();
             CallableStatement call = connection.prepareCall(UPDATE)) {

            call.setLong(1, column.getId());
            call.setLong(2, column.getHelperTableDataTypeId());
            call.setLong(3, column.getHelperTableId());
            call.setLong(4, column.getForeignKeyHelperTableId());
            call.setString(5,  column.getName());
            call.setBoolean(6,column.isForeignKey());

            ResultSet rs = call.getResultSet();

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
    public List<HelperTableRow> getTableRows(long tableId) {

        ConnectionBD connectionBD = new ConnectionBD();
        String selectRecord = "{call semantikos.get_helper_table_rows(?)}";
        List<HelperTableRow> recordFromJSON;
        try (Connection connection = connectionBD.getConnection();
             CallableStatement call = connection.prepareCall(selectRecord)) {

            /* Se prepara y realiza la consulta */
            call.execute();
            ResultSet rs = call.getResultSet();
            if (rs.next()) {
                recordFromJSON = this.helperTableRecordFactory.createHelperTableRowsFromJSON(rs.getString(1));
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
    public HelperTableRow createRow(HelperTableRow newRow) {

       throw new NotImplementedException();
    }

    @Override
    public HelperTableData createData(HelperTableData data) {
        throw new NotImplementedException();

    }

    @Override
    public HelperTableRow getRowById(long id) {
        throw new NotImplementedException();
    }

    @Override
    public HelperTableRow updateRow(HelperTableRow row) {
        throw new NotImplementedException();
    }

    @Override
    public HelperTable getHelperTableByID(long tableId) {
        throw new NotImplementedException();
    }

    @Override
    public List<HelperTableRow> searchRecords(HelperTable helperTable, String pattern) {
        throw new NotImplementedException();
    }
}