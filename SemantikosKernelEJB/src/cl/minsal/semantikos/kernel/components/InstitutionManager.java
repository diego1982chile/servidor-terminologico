package cl.minsal.semantikos.kernel.components;

import cl.minsal.semantikos.model.Institution;
import cl.minsal.semantikos.model.User;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by des01c7 on 16-12-16.
 */
@Local
public interface InstitutionManager {
    public List<Institution> getInstitutionsBy(User user);
}

