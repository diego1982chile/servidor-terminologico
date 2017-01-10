package cl.minsal.semantikos.model.helpertables;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by BluePrints Developer on 14-12-2016.
 */

public class HelperTableData {
    private long id;
    private long intValue;
    private Double floatValue;
    private String stringValue;
    private Date dateValue;
    private boolean booleanValue;
    private long foreignKeyValue;
    private long rowId;
    private long columnId;
    private HelperTableRow row;
    private HelperTableColumn column;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIntValue() {
        return intValue;
    }

    public void setIntValue(long intValue) {
        this.intValue = intValue;
    }

    public Double getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(Double floatValue) {
        this.floatValue = floatValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public long getForeignKeyValue() {
        return foreignKeyValue;
    }

    public void setForeignKeyValue(long foreignKeyValue) {
        this.foreignKeyValue = foreignKeyValue;
    }

    public HelperTableRow getRow() {
        return row;
    }

    public void setRow(HelperTableRow row) {
        this.row = row;
    }

    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }


    public long getColumnId() {
        return columnId;
    }

    public void setColumnId(long columnId) {
        this.columnId = columnId;
    }

    public HelperTableColumn getColumn() {
        return column;
    }

    public void setColumn(HelperTableColumn column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HelperTableData that = (HelperTableData) o;

        if (id != that.id) return false;
        if (intValue != that.intValue) return false;
        if (booleanValue != that.booleanValue) return false;
        if (foreignKeyValue != that.foreignKeyValue) return false;
        if (floatValue != null ? !floatValue.equals(that.floatValue) : that.floatValue != null) return false;
        if (stringValue != null ? !stringValue.equals(that.stringValue) : that.stringValue != null) return false;
        if (dateValue != null ? !dateValue.equals(that.dateValue) : that.dateValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (intValue ^ (intValue >>> 32));
        result = 31 * result + (floatValue != null ? floatValue.hashCode() : 0);
        result = 31 * result + (stringValue != null ? stringValue.hashCode() : 0);
        result = 31 * result + (dateValue != null ? dateValue.hashCode() : 0);
        result = 31 * result + (booleanValue ? 1 : 0);
        result = 31 * result + (int) (foreignKeyValue ^ (foreignKeyValue >>> 32));
        return result;
    }


}
