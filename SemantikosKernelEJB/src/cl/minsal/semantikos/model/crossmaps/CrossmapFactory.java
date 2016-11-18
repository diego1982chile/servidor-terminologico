package cl.minsal.semantikos.model.crossmaps;

import cl.minsal.semantikos.kernel.daos.CrossmapsDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by des01c7 on 18-11-16.
 */
@Singleton
public class CrossmapFactory {

    /**
     * El logger para esta clase
     */
    private static final Logger logger = LoggerFactory.getLogger(CrossmapFactory.class);


    @EJB
    private CrossmapsDAO crossmapsDAO;

    /**
     * Este método crea un CrossmapSetMember con un Resulset
     *
     * @param resultSet
     * @return
     */
    public CrossmapSetMember createFromRS(ResultSet resultSet) throws SQLException {

        logger.debug("creando CrossmapSetMember de ResultSet: ", resultSet);

        long id = resultSet.getLong("id");
        resultSet.getLong("id_cross_map_set");
        CrossmapSet crossmapSet = null;
        String code = resultSet.getString("code");
        String gloss = resultSet.getString("gloss");

        CrossmapSetMember crossmapSetMember = new CrossmapSetMember(id, crossmapSet, code, gloss);

        return crossmapSetMember;
    }


    /**
     * Este método es responsable de crear un objeto <code>DirectCrossmap</code> a partir de un ResultSet.
     *
     * @param rs El ResultSet a partir del cual se crea el crossmap.
     * @return Un Crossmap Directo creado a partir del result set.
     */
    public CrossmapSetMember createCrossmapSetMemberFromResultSet(ResultSet rs, CrossmapSet crossmapSet) throws SQLException {
        // id bigint, id_concept bigint, id_crossmapset bigint, id_user bigint, id_validity_until timestamp
        long id = rs.getLong("id");
        String code = rs.getString("code");
        String gloss = rs.getString("gloss");

        return new CrossmapSetMember(id, crossmapSet, code, gloss);
    }

}
