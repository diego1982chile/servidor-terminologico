package cl.minsal.semantikos.designer_modeler.designer;

import cl.minsal.semantikos.kernel.components.ispfetcher.ISPFetcher;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by BluePrints Developer on 16-11-2016.
 */
@ManagedBean(name="ispbean")
@ViewScoped
public class ISPBean {


    private Boolean existe;
    private String regnum;
    private int ano;


    private Map<String,String> fetchedData;


    public Map<String, String> getFetchedData() {
        return fetchedData;
    }

    public void setFetchedData(Map<String, String> fetchedData) {
        this.fetchedData = fetchedData;
    }

    @EJB
    ISPFetcher ispFetcher;

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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void fetchData(){
        fetchedData = ispFetcher.getISPData(regnum+"/"+ano);
    }


}
