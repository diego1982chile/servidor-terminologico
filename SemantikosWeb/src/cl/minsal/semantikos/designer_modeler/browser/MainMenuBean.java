package cl.minsal.semantikos.designer_modeler.browser;

import cl.minsal.semantikos.kernel.components.*;
import cl.minsal.semantikos.model.Category;
import cl.minsal.semantikos.model.ConceptSMTK;
import cl.minsal.semantikos.model.Description;
import cl.minsal.semantikos.model.Tag;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * Created by diego on 26/06/2016.
 */

@ManagedBean(name = "mainMenuBean")
@ViewScoped
public class MainMenuBean implements Serializable {

    static final Logger logger = LoggerFactory.getLogger(MainMenuBean.class);

    private List<Category> categories = new ArrayList<>();

    private List<SelectItem> others = new ArrayList<>();

    @EJB
    private CategoryManager categoryManager;

    @PostConstruct
    public void init() {

        categories = categoryManager.getCategories();

        others.add(new SelectItem("descriptionBrowser","Descripciones"));
        others.add(new SelectItem("drugsBrowser","Fármacos"));
        others.add(new SelectItem("noValidBrowser","Pendientes"));
        others.add(new SelectItem("noValidBrowser","No Válidos"));

    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<SelectItem> getOthers() {
        return others;
    }

}

