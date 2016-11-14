package cl.minsal.semantikos.model.helpertables;

import cl.minsal.semantikos.model.User;

import java.sql.Timestamp;

/**
 * @author Andrés Farías on 11/14/16.
 */
public class HelperTableImportReport {

    private final Timestamp startTime;

    /** El usuario que realizó la carga */
    private User user;

    /* Status de la carga */
    private LoadStatus status;

    /* La tabla destino de la carga */
    private HelperTable helperTable;

    public HelperTableImportReport(HelperTable helperTable, User user) {
        this.helperTable = helperTable;
        this.startTime = new Timestamp(System.currentTimeMillis());
        this.user = user;
    }

    public void setStatus(LoadStatus status) {
        this.status = status;
    }

    public LoadStatus getStatus() {
        return status;
    }
}
