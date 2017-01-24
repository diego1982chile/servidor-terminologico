package cl.minsal.semantikos.beans.helpertables;

import cl.minsal.semantikos.designer_modeler.auth.AuthenticationBean;
import cl.minsal.semantikos.kernel.components.HelperTablesManager;
import cl.minsal.semantikos.model.helpertables.*;
import org.primefaces.event.RowEditEvent;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Blueprints on 1/27/2016.
 */
@ManagedBean(name="helperTableBean")
@ViewScoped
public class HelperTableBean implements Serializable{

    private static final long serialVersionUID = 1L;


    Map<Long,List<HelperTableRow>> tableRowsMap;

    @EJB
    HelperTablesManager manager;


    @ManagedProperty(value = "#{authenticationBean}")
    private AuthenticationBean authenticationBean;

    public AuthenticationBean getAuthenticationBean() {
        return authenticationBean;
    }

    public void setAuthenticationBean(AuthenticationBean authenticationBean) {
        this.authenticationBean = authenticationBean;
    }

    public HelperTablesManager getHelperTablesManager(){
        return manager;
    }



    public List<HelperTable> getAllHelperTables(){
        return manager.findAll();
    }

    public List<HelperTable> getAdministrableTables(){

        List<HelperTable> administrableTables = new ArrayList<>();

        for (HelperTable table : manager.findAll()) {
            if(table.getId()<=17)
                administrableTables.add(table);
        }

        return administrableTables;
    }



    public void onColumnEdit(RowEditEvent event) {

        HelperTableColumn column = (HelperTableColumn) event.getObject();

        HelperTableColumn newcolumn = manager.updateColumn(column);
        column.setForeignKeyHelperTable(newcolumn.getForeignKeyHelperTable());
        column.setForeignKeyHelperTableId(newcolumn.getForeignKeyHelperTableId());
        column.setHelperTableDataType(newcolumn.getHelperTableDataType());
        column.setHelperTableDataTypeId(newcolumn.getHelperTableDataTypeId());
        column.setId(newcolumn.getId());
    }

    public void onColumnEditCancel(RowEditEvent event) {
    }


    public void onRowEdit(RowEditEvent event) {
        HelperTableRow row = (HelperTableRow) event.getObject();
        HelperTableRow updatedRow = manager.updateRow(row,this.authenticationBean.getUsername());
    }

    public void onRowEditCancel(RowEditEvent event) {

    }



    public List<HelperTableDataType> getAllDataTypes(){

        return manager.getAllDataTypes();
    }



    public void addRow(Long tableId){

        HelperTableRow newRow = manager.createRow(tableId,authenticationBean.getUsername());
        tableRowsMap.remove(newRow.getHelperTableId());
    }



    public List<HelperTableRow> getAllTableRows(long tableId) {


        if(tableRowsMap == null)
            tableRowsMap = new HashMap<>();


        if(!tableRowsMap.containsKey(tableId))
             tableRowsMap.put(tableId,manager.getTableRows(tableId));

        return tableRowsMap.get(tableId);


    }

    protected void showInfo(String title, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, title, message));
    }

    protected void showError(String title, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, message));
    }


    public List<HelperTableRow> getValidTableRows(HelperTable table){
        return manager.getValidTableRows(table.getId());
    }
}
