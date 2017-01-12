package cl.minsal.semantikos.model.helpertables;

import cl.minsal.semantikos.model.relationships.Target;
import cl.minsal.semantikos.model.relationships.TargetType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by BluePrints Developer on 14-12-2016.
 */

public class HelperTableRow implements Target{
    private long id;
    private Date creationDate;
    private Date lastEditDate;
    private boolean valid;
    private Date validityUntil;
    private String description;
    private String creationUsername;
    private String lastEditUsername;
    private List<HelperTableData> cells;
    private long helperTableId;


    public HelperTableRow(){
        super();
    }

    /*
    crea fila placeholder a partir de la tabla
     */
    public HelperTableRow(HelperTable helperTable) {
        this.id=-1;
        this.helperTableId=helperTable.getId();
    }


    public long getId() {
        return id;
    }

    @Override
    public TargetType getTargetType() {
        return TargetType.HelperTable;
    }



    @Override
    public String getRepresentation() {
        return description;
    }

    @Override
    public Target copy() {
        HelperTableRow copy = new HelperTableRow();

        copy.setId(id);
        copy.setDescription(description);
        copy.setLastEditUsername(lastEditUsername);
        copy.setCells(cells);
        copy.setHelperTableId(helperTableId);
        copy.setValid(valid);
        copy.setCreationDate(creationDate);
        copy.setLastEditDate(lastEditDate);
        copy.setValid (valid);
        copy.setValidityUntil (validityUntil);
        copy.setCreationUsername (creationUsername);
        copy.setHelperTableId (helperTableId);

        return copy;

    }



    public void setId(long id) {
        this.id = id;
    }


    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }


    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Date getValidityUntil() {
        return validityUntil;
    }

    public void setValidityUntil(Date validityUntil) {
        this.validityUntil = validityUntil;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<HelperTableData> getCells() {
        return cells;
    }

    public void setCells(List<HelperTableData> cells) {
        this.cells = cells;
    }

    public String getCreationUsername() {
        return creationUsername;
    }

    public void setCreationUsername(String creationUsername) {
        this.creationUsername = creationUsername;
    }

    public long getHelperTableId() {

        return helperTableId;
    }


    public String getLastEditUsername() {
        return lastEditUsername;
    }

    public void setLastEditUsername(String lastEditUsername) {
        this.lastEditUsername = lastEditUsername;
    }

    public void setHelperTableId(long helperTableId) {
        this.helperTableId = helperTableId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HelperTableRow that = (HelperTableRow) o;

        if (id != that.id) return false;
        if (valid != that.valid) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (lastEditDate != null ? !lastEditDate.equals(that.lastEditDate) : that.lastEditDate != null) return false;
        if (validityUntil != null ? !validityUntil.equals(that.validityUntil) : that.validityUntil != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastEditDate != null ? lastEditDate.hashCode() : 0);
        result = 31 * result + (valid ? 1 : 0);
        result = 31 * result + (validityUntil != null ? validityUntil.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public boolean isPersistent() {
        return id != -1;
    }
}
