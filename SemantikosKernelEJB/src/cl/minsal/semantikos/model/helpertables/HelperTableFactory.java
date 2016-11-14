package cl.minsal.semantikos.model.helpertables;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJBException;
import java.io.IOException;
import java.util.*;

import static cl.minsal.semantikos.kernel.util.StringUtils.underScoreToCamelCaseJSON;

/**
 * Esta enumeración almacena todas las tablas auxiliares existentes.
 */
public class HelperTableFactory {

    private static final Logger logger = LoggerFactory.getLogger(HelperTableFactory.class);

    /**
     * Este método es responsable de crear una lista de relaciones a partir de un arreglo json de relaciones.
     * <code>
     * "{""tableName"":""smtk_helper_table_atc"",""records"":[{""id"":2,""description"":""A01AB16""},
     * {""id"":3,""description"":""A01AB17""},
     * {""id"":4,""description"":""A01AB18""},
     * {""id"":5,""description"":""A01AB19""},
     * {""id"":6,""description"":""A01AB21""},
     * {""id"":7,""description"":""A01AB22""},
     * {""id"":8,""description"":""A01AB23""},
     * {""id"":9,""description"":""A01AB15""},
     * {""id"":22,""description"":""A01AB14""},
     * {""id"":27,""description"":""A01AB02""},
     * {""id"":28,""description"":""A01AB03""},
     * {""id"":29,""description"":""A01AB04""},
     * {""id"":30,""description"":""A01AB11""},
     * {""id"":31,""description"":""A01AB06""},
     * {""id"":32,""description"":""A01AB07""},
     * {""id"":33,""description"":""A01AB08""},
     * {""id"":34,""description"":""A01AB09""},
     * {""id"":35,""description"":""A01AB10""},
     * {""id"":36,""description"":""A01AB13""},
     * {""id"":37,""description"":""A01AB12""},
     * {""id"":38,""description"":""A01AB05""}]}"
     * </code>
     *
     * @param jsonExpression La expresión que contiene un arreglo JSON de RD_DTO.
     * @param helperTable    La tabla auxiliar a la que pertenecen los registros.
     *
     * @return Una lista de <code>HelperTableRecord</code>.
     */
    public List<HelperTableRecord> createHelperTableRecordsFromJSON(HelperTable helperTable, String jsonExpression) {

        ObjectMapper mapper = new ObjectMapper();
        HelperTableRecordDTO[] dtoRecords;
        try {

            dtoRecords = mapper.readValue(underScoreToCamelCaseJSON(jsonExpression), HelperTableRecordDTO[].class);
        } catch (IOException e) {
            String errorMsg = "No se pudo parsear el RelationshipDefinition desde un JSON.";
            logger.error(errorMsg);
            throw new EJBException(errorMsg, e);
        }

        List<HelperTableRecord> helperTableRecords = new ArrayList<>();
        for (HelperTableRecordDTO dtoRecord : dtoRecords) {
            helperTableRecords.add(new HelperTableRecord(helperTable, dtoRecord.getFields()));
        }

        return helperTableRecords;
    }

    /**
     * Este método es responsable de crear una simple Tabla Auxiliar, no persistida.
     *
     * @return Un instancia fresca de una tabla auxiliar dummy.
     */
    public HelperTable createDummyHelperTable() {

        Collection<HelperTableColumn> columns = new ArrayList<>();
        columns.add(new HelperTableColumn("DESCRIPTION", false, true, false));
        columns.add(new HelperTableColumn("ID", false, false, false));

        return new HelperTable("HT Dummy", "Dummy", "dummy", columns);
    }

    private class HelperTableRecordDTO {

        private String tableName;

        private String[][] records;

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public String[][] getRecords() {
            return records;
        }

        public void setRecords(String[][] records) {
            this.records = records;
        }

        public Map<String, String> getFields() {

            HashMap<String, String> records = new HashMap<>();
            for (String[] record : this.records) {
                records.put(record[0], record[1]);
            }

            return records;
        }
    }
}