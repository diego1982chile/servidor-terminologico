package cl.minsal.semantikos.model.businessrules;

import cl.minsal.semantikos.model.exceptions.BusinessRuleException;
import cl.minsal.semantikos.model.helpertables.HelperTable;
import cl.minsal.semantikos.model.helpertables.HelperTableColumn;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class HelperTableSearchBRTest {

    private HelperTableSearchBR helperTableSearchBR = new HelperTableSearchBR();

    public static final String A_SEARCHABLE_COLUMN_NAME = "A_SEARCHABLE_COLUMN_NAME";
    public static final String A_NON_SEARCHABLE_COLUMN_NAME = "A_NON_SEARCHABLE_COLUMN_NAME";

    /**
     * Este test valida que no se pueda buscar en tablas que no tienen la columna dada.
     *
     * @throws cl.minsal.semantikos.model.exceptions.BusinessRuleException La excepción esperada.
     */
    @Test(expected = BusinessRuleException.class)
    public void testPrecondition01() throws Exception {

        Collection<HelperTableColumn> columns = dummyHelperTable();

        HelperTable helperTable = new HelperTable("HT Dummy", "Dummy", "dummy", columns);
        helperTableSearchBR.precondition01(helperTable, "NON_EXISTENT_COLUMN_NAME");
    }

    /**
     * Este método es responsable de crear una tabla auxiliar con columnas básicas.
     *
     * @return Un objeto Tabla Auxiliar no persistido.
     */
    private Collection<HelperTableColumn> dummyHelperTable() {
        Collection<HelperTableColumn> columns = new ArrayList<>();
        columns.add(new HelperTableColumn(A_SEARCHABLE_COLUMN_NAME, false, true, false));
        columns.add(new HelperTableColumn(A_NON_SEARCHABLE_COLUMN_NAME, false, false, false));
        return columns;
    }
}