package cl.minsal.semantikos.kernel.components;

import cl.minsal.semantikos.kernel.daos.HelperTableDAO;
import cl.minsal.semantikos.model.User;
import cl.minsal.semantikos.model.businessrules.HelperTableSearchBR;
import cl.minsal.semantikos.model.helpertables.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * Este manager es responsable de proveer acceso a las distintas tablas auxiliares.
 * <p>
 * Las tablas auxiliares se han implementado de manera estática, es decir, se maneja una lista estática de las tablas
 * auxiliares.
 * </p>
 *
 * @author Andrés Farías
 * @see HelperTableManager
 */
@Stateless
public class HelperTableManagerImpl implements HelperTableManager {

    private static final Logger logger = LoggerFactory.getLogger(HelperTableManagerImpl.class);

    @EJB
    private HelperTableDAO helperTableDAO;

    @Override
    public Collection<HelperTable> getHelperTables() {

        /* Esto se resuelve con delegación sobre el Factory, mientras las tablas estén en duro */
        return helperTableDAO.getHelperTables();
    }

    @Override
    public List<HelperTableRecord> getAllRecords(HelperTable helperTable, List<String> columnNames) {

        List<HelperTableRecord> allRecords = helperTableDAO.getAllRecords(helperTable);
        Collections.sort(allRecords);
        logger.debug("Se recuperan " + allRecords.size() + " registros de la tabla " + helperTable);

        return allRecords;
    }

    @Override
    public List<HelperTableRecord> getAllRecords(HelperTable helperTable) {

        /* Como no se especifican las columnas a recuperar, se retornan todas las visibles y las de sistema */
        List<String> returnableColumns = helperTable.getShowableColumnsNames();
        for (HelperTableColumn systemColumn : HelperTable.getSystemColumns()) {
            returnableColumns.add(systemColumn.getColumnName());
        }

        /* Se delega en el método único para recuperar registros desde las tablas auxiliares */
        return getAllRecords(helperTable, returnableColumns);
    }

    @Override
    public List<HelperTableRecord> searchRecords(HelperTable helperTable, String columnName, String pattern, boolean validity) {

        /* Se validan las pre-condiciones de búsqueda */
        new HelperTableSearchBR().validatePreConditions(helperTable, columnName, pattern);

        /* Se delega la búsqueda al DAO, ya que pasaron las pre-condiciones */
        return helperTableDAO.findRecordsByPattern(helperTable, columnName, pattern, validity);
    }

    @Override
    public HelperTableRecord getRecord(long recordId) {
        return helperTableDAO.getHelperTableRecordFromId(recordId);
    }

    @Override
    public HelperTable findHelperTableByID(long id) {
        return helperTableDAO.getHelperTableByID(id);
    }

    @Override
    public HelperTableImportReport loadFromFile(long helperTableID, LoadMode mode, Reader in, User user) {

        HelperTableImportReport helperTableReport = new HelperTableImportReport(user);
        Iterable<CSVRecord> records;
        try {
            records = CSVFormat.EXCEL.parse(in);
        } catch (IOException e) {
            logger.error("Error al procesar archivo CSV para importación de tabla auxiliar.", e);
            helperTableReport.setStatus(LoadStatus.CANCELED);

            return helperTableReport;
        }

        // TODO: Terminar esto.
        for (CSVRecord record : records) {
            String cctnu_concepto_id = record.get("CCTNU_CONCEPTO_ID");
            logger.info("CCTNU_CONCEPTO_ID=" + cctnu_concepto_id);
        }

        return helperTableReport;
    }
}
