package cl.minsal.semantikos.designer_modeler.designer;

import cl.minsal.semantikos.beans.concept.ConceptBean;
import cl.minsal.semantikos.beans.helpertables.HelperTableBean;
import cl.minsal.semantikos.designer_modeler.auth.AuthenticationBean;
import cl.minsal.semantikos.kernel.auth.UserManager;
import cl.minsal.semantikos.kernel.components.HelperTablesManager;
import cl.minsal.semantikos.kernel.components.RelationshipManager;
import cl.minsal.semantikos.kernel.components.ispfetcher.ISPFetcher;
import cl.minsal.semantikos.model.helpertables.*;
import cl.minsal.semantikos.model.relationships.Relationship;
import cl.minsal.semantikos.model.relationships.RelationshipDefinition;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.util.*;

/**
 * Created by BluePrints Developer on 16-11-2016.
 */
@ManagedBean(name="ispbean")
@ViewScoped
public class ISPBean {


    static private final long ISP_TABLE_ID=9;

    private Boolean existe;
    private String regnum;
    private Integer ano = null;

    private HelperTable ht;


    private Map<String,String> fetchedData;

    private HelperTableRow ispRecord = null;

    public Map<String, String> getFetchedData() {
        return fetchedData;
    }

    public void setFetchedData(Map<String, String> fetchedData) {
        this.fetchedData = fetchedData;
    }

    @EJB
    ISPFetcher ispFetcher;

    @EJB
    HelperTablesManager helperTablesManager;

    @EJB
    UserManager userManager;

    @EJB
    RelationshipManager relationshipManager;

    @EJB
    HelperTableRecordFactory helperTableRecordFactory;

    @ManagedProperty(value = "#{helperTableBean}")
    private HelperTableBean helperTableBean;

    @ManagedProperty(value = "#{authenticationBean}")
    private AuthenticationBean authenticationBean;

    @ManagedProperty(value = "#{conceptBean}")
    private ConceptBean conceptBean;


    @PostConstruct
    public void init() {
        // Se setea en duro la opcionalidad de la relación, esta debería ser opcional.
        for (RelationshipDefinition rd : conceptBean.getCategory().getRelationshipDefinitions()) {
            if(rd.isISP()) {
                rd.getMultiplicity().setLowerBoundary(0);
                if(conceptBean.getConcept().isPersistent()){
                    List<Relationship> relationshipList =conceptBean.getConcept().getRelationshipsByRelationDefinition(rd);
                    if(relationshipList.size()>0){
                        existe=true;
                    }
                }
            }
        }

    }


    public AuthenticationBean getAuthenticationBean() {
        return authenticationBean;
    }


    public void setAuthenticationBean(AuthenticationBean authenticationBean) {
        this.authenticationBean = authenticationBean;
    }

    public ConceptBean getConceptBean() {
        return conceptBean;
    }

    public void setConceptBean(ConceptBean conceptBean) {
        this.conceptBean = conceptBean;
    }

    public Boolean getExiste() {
        return existe;
    }

    public void setExiste(Boolean existe) {
        this.existe = existe;
    }

    public String getRegnum() {
        return regnum;
    }

    public void setRegnum(String regnum) {
        this.regnum = regnum;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void fetchData(){

        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext fContext = FacesContext.getCurrentInstance();

        RelationshipDefinition relationshipDefinition = (RelationshipDefinition) UIComponent.getCurrentComponent(fContext).getAttributes().get("relationshipDefinition");

        //fetchedData = helperTablesManager.searchRows(getISPHelperTable(),"description",regnum+"/"+ano,true).get(0).getFields();
        if(regnum.trim().equals("") || ano == null || ano == 0) {
            conceptBean.getMessageBean().messageError("Debe ingresar un valor para el dato 'RegNum' y 'RegAño'");
            return;
        }

        ispRecord = null;

        /**
         * Primero se busca un registro isp local
         */
        for (HelperTableRow helperTableRecord : helperTablesManager.searchRows(getISPHelperTable(),regnum+"/"+ano)) {
            ispRecord = helperTableRecord;
            break;
        }

        /**
         * Si no existe, se va a buscar a la página del registro isp
         */
        if(ispRecord==null) {
            //fetchedData = ispFetcher.getISPData(regnum+"/"+ano);

            fetchedData = ispFetcher.getISPData(regnum + "/" + ano);


        }
        else {
        /**
         * Si se encuentra, se verifica que no exista actualmente una relación con este destino
         */
            if(!relationshipManager.getRelationshipsLike(relationshipDefinition,ispRecord).isEmpty()) {
                conceptBean.getMessageBean().messageError("Este registro ISP está siendo actuálmente utilizado por un Producto Comercial");
                return;
            }
        }

        context.execute("PF('ispfetcheddialog').show();");
    }


    public void updateOptionality(RelationshipDefinition relationshipDefinition){
        if(existe)
            relationshipDefinition.getMultiplicity().setLowerBoundary(1);
        else
            relationshipDefinition.getMultiplicity().setLowerBoundary(0);
    }


    public List<String> getMapKeys(){

        if (fetchedData == null )
            return new ArrayList<String>();


        List<String> result = new ArrayList<>();
        result.addAll(fetchedData.keySet());

        return result;
    }


    public void agregarISP(RelationshipDefinition relationshipDefinition){


        if(fetchedData != null){
            HelperTable ispHT = getISPHelperTable();

            ispRecord = helperTablesManager.createRow(ispHT,authenticationBean.getUsername());


            mapFetchedData(ispRecord,fetchedData);

            HelperTableRow inserted = helperTablesManager.updateRow(ispRecord,authenticationBean.getUsername());
            ispRecord = inserted;
        }

        conceptBean.setSelectedHelperTableRecord(ispRecord);
        conceptBean.addRelationship(relationshipDefinition,ispRecord);

        clean();

    }

    private void clean() {
       existe = true;
       regnum = "";
       ano = null;
       ispRecord = null;
    }

    private void mapFetchedData(HelperTableRow row, Map<String, String> fetchedData) {
        Map<String, String> ret = new HashMap<String, String>();


        for (HelperTableData cell: row.getCells()) {
            if(cell.getColumn().getName().equals("Registro")) cell.setStringValue(fetchedData.get("Registro"));
            if(cell.getColumn().getName().equals("Nombre")) cell.setStringValue(fetchedData.get("Nombre"));
            if(cell.getColumn().getName().equals("Referencia de Tramite")) cell.setStringValue(fetchedData.get("Referencia de Tramite"));
            if(cell.getColumn().getName().equals("Equivalencia Terapéutica")) cell.setStringValue(fetchedData.get("Equivalencia Terapéutica"));
            if(cell.getColumn().getName().equals("Titular")) cell.setStringValue(fetchedData.get("Titular"));
            if(cell.getColumn().getName().equals("Estado del Registro")) cell.setStringValue(fetchedData.get("Estado del Registro"));
            if(cell.getColumn().getName().equals("Resolución Inscríbase")) cell.setStringValue(fetchedData.get("Resolución Inscríbase"));
            if(cell.getColumn().getName().equals("Fecha Inscríbase")) cell.setStringValue(fetchedData.get("Fecha Inscríbase"));
            if(cell.getColumn().getName().equals("Ultima Renovación")) cell.setStringValue(fetchedData.get("Ultima Renovación"));
            if(cell.getColumn().getName().equals("Fecha Próxima renovación")) cell.setStringValue(fetchedData.get("Fecha Próxima renovación"));
            if(cell.getColumn().getName().equals("Régimen")) cell.setStringValue(fetchedData.get("Régimen"));
            if(cell.getColumn().getName().equals("Vía Administración")) cell.setStringValue(fetchedData.get("Vía Administración"));
            if(cell.getColumn().getName().equals("Condición de Venta")) cell.setStringValue(fetchedData.get("Condición de Venta"));
            if(cell.getColumn().getName().equals("Expende tipo establecimiento")) cell.setStringValue(fetchedData.get("Expende tipo establecimiento"));
            if(cell.getColumn().getName().equals("Indicación")) cell.setStringValue(fetchedData.get("Indicación"));


            row.setValid(true);
            row.setDescription(fetchedData.get("Registro"));

        }

    }

    public HelperTable getISPHelperTable(){

        if(ht == null) {


            List<HelperTable> tablas = helperTablesManager.findAll();


            for (HelperTable ht1 : tablas) {
                if (ht1.getId()==ISP_TABLE_ID) {
                    ht = ht1;
                    break;
                }
            }
        }

        return ht;
    }

    public HelperTableRow getIspRecord() {
        return ispRecord;
    }

    public void setIspRecord(HelperTableRow ispRecord) {
        this.ispRecord = ispRecord;
    }


    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public RelationshipManager getRelationshipManager() {
        return relationshipManager;
    }

    public void setRelationshipManager(RelationshipManager relationshipManager) {
        this.relationshipManager = relationshipManager;
    }


    public HelperTableBean getHelperTableBean() {
        return helperTableBean;
    }

    public void setHelperTableBean(HelperTableBean helperTableBean) {
        this.helperTableBean = helperTableBean;
    }


    /*
verifica si el registro ya existe en la base de datos
 */
    public boolean getExisteRegistroISP(){
        if(ispRecord==null )
            return false;

        List<HelperTableRow> records = helperTablesManager.searchRows(getISPHelperTable(),regnum+"/"+ano);

        return  records.size() >0;
    }


}
