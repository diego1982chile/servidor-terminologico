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

    /** Fecha <em>hasta</em> de vigencia */

    private Timestamp validityUntil;

    /** Usuario que creo la terminología */
    private User creator;

    public Timestamp getValidityUntil() {
        return validityUntil;
    }

    public void setValidityUntil(Timestamp validityUntil) {
        this.validityUntil = validityUntil;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviatedName() {
        return abbreviatedName;
    }

    public void setAbbreviatedName(String abbreviatedName) {
        this.abbreviatedName = abbreviatedName;
    }

    public long getIdCrossmapSet() {
        return idCrossmapSet;
    }

    public void setIdCrossmapSet(long idCrossmapSet) {
        this.idCrossmapSet = idCrossmapSet;
    }


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
