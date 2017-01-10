package cl.minsal.semantikos.model.helpertables;

import javax.persistence.*;

/**
 * Created by BluePrints Developer on 14-12-2016.
 */
public class HelperTableColumn {
    private long id;
    private String name;
    private long helperTableId;
    private long helperTableDataTypeId;
    private long foreignKeyHelperTableId;
    private HelperTable helperTable;
    private HelperTable foreignKeyHelperTable;
    private HelperTableDataType helperTableDataType;
    private boolean foreignKey;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHelperTableId() {
        return helperTableId;
    }

    public void setHelperTableId(long helperTableId) {
        this.helperTableId = helperTableId;
    }

    public HelperTable getHelperTable() {
        return helperTable;
    }

    public void setHelperTable(HelperTable helperTable) {
        this.helperTable = helperTable;
    }

    public HelperTable getForeignKeyHelperTable() {
        return foreignKeyHelperTable;
    }

    public void setForeignKeyHelperTable(HelperTable foreignKeyHelperTable) {
        this.foreignKeyHelperTable = foreignKeyHelperTable;
    }

    public long getHelperTableDataTypeId() {
        return helperTableDataTypeId;
    }

    public void setHelperTableDataTypeId(long helperTableDataTypeId) {
        this.helperTableDataTypeId = helperTableDataTypeId;
    }


    public HelperTableDataType getHelperTableDataType() {
        return helperTableDataType;
    }

    public void setHelperTableDataType(HelperTableDataType helperTableDataType) {
        this.helperTableDataType = helperTableDataType;
    }

    public long getForeignKeyHelperTableId() {
        return foreignKeyHelperTableId;
    }

    public void setForeignKeyHelperTableId(long foreignKeyTableId) {
        this.foreignKeyHelperTableId = foreignKeyTableId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HelperTableColumn that = (HelperTableColumn) o;

        if (id != that.id) return false;
        if (helperTableId != that.helperTableId) return false;
        if (helperTableDataTypeId != that.helperTableDataTypeId) return false;
        if (foreignKeyHelperTableId != that.foreignKeyHelperTableId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (helperTableId ^ (helperTableId >>> 32));
        result = 31 * result + (int) (helperTableDataTypeId ^ (helperTableDataTypeId >>> 32));
        result = 31 * result + (int) (foreignKeyHelperTableId ^ (foreignKeyHelperTableId >>> 32));
        return result;
    }

    public boolean isForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(boolean foreignKey) {
        this.foreignKey = foreignKey;
    }
}
