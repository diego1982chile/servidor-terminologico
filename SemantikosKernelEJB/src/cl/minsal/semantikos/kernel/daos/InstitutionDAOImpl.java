package cl.minsal.semantikos.kernel.daos;

import cl.minsal.semantikos.kernel.util.ConnectionBD;
import cl.minsal.semantikos.model.Institution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by des01c7 on 15-12-16.
 */
@Stateless
public class InstitutionDAOImpl implements InstitutionDAO {


    private static final Logger logger = LoggerFactory.getLogger(InstitutionDAOImpl.class);


    @Override
    public Institution getInstitutionBy(long id) {

        ConnectionBD connect = new ConnectionBD();
        String GET_INSTITUTION_BY_ID = "{call semantikos.get_institution_by_id(?)}";
        Institution institution= new Institution();
        try (Connection connection = connect.getConnection();
             CallableStatement call = connection.prepareCall(GET_INSTITUTION_BY_ID)) {
            call.setLong(1, id);
            call.execute();

            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                institution = createInstitutionFromResultSet(rs);
            }
        } catch (SQLException e) {
            logger.error("Error al al obtener los RefSets ", e);
        }

        return institution;
    }

    private Institution createInstitutionFromResultSet(ResultSet resultSet) {
        Institution institution = new Institution();
        try {
            institution.setId(resultSet.getLong("id"));
            institution.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return institution;
    }
}
