package cl.minsal.semantikos.kernel.daos;

import cl.minsal.semantikos.model.Institution;
import cl.minsal.semantikos.model.User;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by des01c7 on 15-12-16.
 */
@Local
public interface InstitutionDAO {

    /**
     * Método encargado de obtener una institución por ID
     * @param id
     * @return
     */
    public Institution getInstitutionBy(long id);

    /**
     * Método encargado de obtener las instituciones asociadas a un usuario
     * @param user
     * @return
     */
    public List<Institution> getInstitutionBy(User user);


}
