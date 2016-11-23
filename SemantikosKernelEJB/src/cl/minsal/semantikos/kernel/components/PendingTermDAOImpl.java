package cl.minsal.semantikos.kernel.components;

import cl.minsal.semantikos.kernel.util.ConnectionBD;
import cl.minsal.semantikos.model.PendingTerm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import java.sql.*;

import static java.sql.Types.TIMESTAMP;

/**
 * @author Andrés Farías on 11/22/16.
 */
@Stateless
public class PendingTermDAOImpl implements PendingTermDAO {

    private static final Logger logger = LoggerFactory.getLogger(PendingTermDAOImpl.class);

    @Override
    public void persist(PendingTerm pendingTerm) {
        ConnectionBD connect = new ConnectionBD();
        /*
         * param1: ID
         * param 2: DesType ID
         * param 3: Term
         * param 4: case
         * param 5: auto-generado
         * param 6: validity until
         * param 7: published
         * param 8: estado
         * param 9: id user
         * param 10: id concepto
         */
        String sql = "{call semantikos.create_pending_term(?,?,?,?,?,?,?,?,?,?)}";
        try (Connection connection = connect.getConnection();
             CallableStatement call = connection.prepareCall(sql)) {

            call.setString(1, pendingTerm.getTerm());
            call.setTimestamp(2, new Timestamp(pendingTerm.getDate().getTime()));
            call.setBoolean(3, pendingTerm.isSensibility());
            call.setLong(4, pendingTerm.getCategory().getId());
            call.setString(5, pendingTerm.getNameProfessional());
            call.setString(6, pendingTerm.getProfession());
            call.setString(7, pendingTerm.getSpeciality());
            call.setString(8, pendingTerm.getSubspeciality());
            call.setString(9, pendingTerm.getMail());
            call.setString(10, pendingTerm.getObservation());

            call.execute();

            ResultSet rs = call.getResultSet();
            if (rs.next()) {
                pendingTerm.setId(rs.getLong(1));
            } else {
                String errorMsg = "El termino pendiente no fue creado. Contacte a Desarrollo";
                logger.error(errorMsg);
                throw new EJBException(errorMsg);
            }
            rs.close();
        } catch (SQLException e) {
            throw new EJBException(e);
        }
    }
}
