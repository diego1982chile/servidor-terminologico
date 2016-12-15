package cl.minsal.semantikos.kernel.daos;

import cl.minsal.semantikos.model.Institution;

import javax.ejb.Local;

/**
 * Created by des01c7 on 15-12-16.
 */
@Local
public interface InstitutionDAO {

    public Institution getInstitutionBy(long id);

}
