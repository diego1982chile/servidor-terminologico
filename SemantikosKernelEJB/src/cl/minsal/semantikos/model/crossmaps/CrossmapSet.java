package cl.minsal.semantikos.model.crossmaps;

import cl.minsal.semantikos.model.PersistentEntity;
import cl.minsal.semantikos.model.User;
import cl.minsal.semantikos.model.relationships.TargetDefinition;

import java.sql.Timestamp;

/**
 * Esta clase implementa el concepto de terminología externa
 * @author Andrés Farías on 11/3/16.
 */
public class CrossmapSet extends PersistentEntity implements TargetDefinition {

    /** Identificador de negocio */
    private long idCrossmapSet;

    private String abbreviatedName;

    private String name;

    /** Año de la versión */
    private int version;

    /** Fecha de creación */
    private Timestamp creationDate;

    /** Usuario que creo la terminología */
    private User creator;

    /** Fecha <em>hasta</em> de vigencia */
    private Timestamp validityUntil;

    @Override
    public boolean isBasicType() {
        return false;
    }

    @Override
    public boolean isSMTKType() {
        return false;
    }

    @Override
    public boolean isHelperTable() {
        return false;
    }

    @Override
    public boolean isSnomedCTType() {
        return false;
    }

    @Override
    public boolean isCrossMapType() {
        return true;
    }
}
