package cl.minsal.semantikos.model.helpertables;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelperTableFactoryTest {

    @Test
    public void testCreateHelperTableRecordsFromJSON() throws Exception {

        String json = "{\"\"tableName\"\":\"\"smtk_helper_table_atc\"\",\"\"records\"\":[{\"\"id\"\":2,\"\"description\"\":\"\"A01AB16\"\"},\n" +
                "     * {\"\"id\"\":3,\"\"description\"\":\"\"A01AB17\"\"},\n" +
                "     * {\"\"id\"\":4,\"\"description\"\":\"\"A01AB18\"\"},\n" +
                "     * {\"\"id\"\":5,\"\"description\"\":\"\"A01AB19\"\"},\n" +
                "     * {\"\"id\"\":6,\"\"description\"\":\"\"A01AB21\"\"},\n" +
                "     * {\"\"id\"\":7,\"\"description\"\":\"\"A01AB22\"\"},\n" +
                "     * {\"\"id\"\":8,\"\"description\"\":\"\"A01AB23\"\"},\n" +
                "     * {\"\"id\"\":9,\"\"description\"\":\"\"A01AB15\"\"},\n" +
                "     * {\"\"id\"\":22,\"\"description\"\":\"\"A01AB14\"\"},\n" +
                "     * {\"\"id\"\":27,\"\"description\"\":\"\"A01AB02\"\"},\n" +
                "     * {\"\"id\"\":28,\"\"description\"\":\"\"A01AB03\"\"},\n" +
                "     * {\"\"id\"\":29,\"\"description\"\":\"\"A01AB04\"\"},\n" +
                "     * {\"\"id\"\":30,\"\"description\"\":\"\"A01AB11\"\"},\n" +
                "     * {\"\"id\"\":31,\"\"description\"\":\"\"A01AB06\"\"},\n" +
                "     * {\"\"id\"\":32,\"\"description\"\":\"\"A01AB07\"\"},\n" +
                "     * {\"\"id\"\":33,\"\"description\"\":\"\"A01AB08\"\"},\n" +
                "     * {\"\"id\"\":34,\"\"description\"\":\"\"A01AB09\"\"},\n" +
                "     * {\"\"id\"\":35,\"\"description\"\":\"\"A01AB10\"\"},\n" +
                "     * {\"\"id\"\":36,\"\"description\"\":\"\"A01AB13\"\"},\n" +
                "     * {\"\"id\"\":37,\"\"description\"\":\"\"A01AB12\"\"},\n" +
                "     * {\"\"id\"\":38,\"\"description\"\":\"\"A01AB05\"\"}]}";


        HelperTableFactory helperTableFactory = new HelperTableFactory();
        HelperTable dummyHelperTable = helperTableFactory.createDummyHelperTable();
        helperTableFactory.createHelperTableRecordsFromJSON(dummyHelperTable, json);

        // TODO: ONGOING
    }
}