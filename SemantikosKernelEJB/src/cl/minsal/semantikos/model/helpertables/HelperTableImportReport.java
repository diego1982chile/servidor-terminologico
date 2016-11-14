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

    private LoadStatus status;

    public HelperTableImportReport(User user) {
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
