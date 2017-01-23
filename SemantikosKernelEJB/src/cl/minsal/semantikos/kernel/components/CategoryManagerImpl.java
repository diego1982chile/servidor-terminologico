package cl.minsal.semantikos.kernel.components;


import cl.minsal.semantikos.kernel.daos.CategoryDAO;
import cl.minsal.semantikos.kernel.daos.RelationshipDAO;
import cl.minsal.semantikos.model.Category;
import cl.minsal.semantikos.model.Description;
import cl.minsal.semantikos.model.User;
import cl.minsal.semantikos.model.businessrules.CategoryCreationBR;
import cl.minsal.semantikos.model.relationships.RelationshipDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.*;

import static java.lang.System.currentTimeMillis;

/**
 * Este Manager es responsable de gestionar las categorías. Como son muy pocas, y estáticas, es decir, no cambian en
 * el tiempo (o no con frecuencia), se implementa con dos Cachés: uno por su ID y otro por su Nombre.
 *
 * @author Andrés Farías on 27-05-16.
 */
@Stateless
public class CategoryManagerImpl implements CategoryManager {

    private static final Logger logger = LoggerFactory.getLogger(CategoryManagerImpl.class);

    /**
     * Un caché por ID
     */
    private Map<Long, Category> categoriesByIDCache;

    /**
     * Un caché por nombre
     */
    private Map<String, Category> categoriesByNameCache;

    /**
     * Un indicador de si el caché fue cargado o no
     */
    private boolean cacheLoaded;

    @EJB
    private CategoryDAO categoryDAO;

    @EJB
    private RelationshipDAO relationshipDAO;

    @EJB
    private DescriptionManager descriptionManager;

    public CategoryManagerImpl() {
        this.categoriesByIDCache = new HashMap<>();
        this.categoriesByNameCache = new HashMap<>();
        this.cacheLoaded = false;
    }

    @Override
    public List<RelationshipDefinition> getCategoryMetaData(int id) {
        return categoryDAO.getCategoryMetaData(id);
    }

    @Override
    public void addAttribute(RelationshipDefinition attributeCategory, int idCategory) {

    }

    @Override
    public Category createCategory(Category category, User user) {

        logger.debug("Persistiendo la categoría: " + category);

        /* Se validan las reglas de negocio */
        new CategoryCreationBR().applyRules(category, user);

        /* Se persiste la categoría */
        categoryDAO.persist(category);

        /* Se persisten sus definiciones de relaciones */
        for (RelationshipDefinition relationshipDefinition : category.getRelationshipDefinitions()) {
            relationshipDAO.persist(relationshipDefinition);
        }

        logger.debug("Categoría persistida: " + category);

        /* Se retorna */
        return category;
    }

    @Override
    public boolean categoryContains(Category category, String term) {

        List<Description> descriptions = descriptionManager.searchDescriptionsByTerm(term, Arrays.asList(category));

        /* Si la búsqueda resultó con al menos un término vigente, entonces si contiene */
        for (Description description : descriptions) {
            if (description.isValid()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Category getCategoryById(long id) {
        return categoryDAO.getCategoryById(id);
    }

    @Override
    public Category getCategoryByName(String name) {
        long init = currentTimeMillis();

        /* If the categories have not been cached yet, they are cached now */
        if (!cacheLoaded) { loadCaches(); }

        /* Se verifica si existe */
        if (!this.categoriesByNameCache.containsKey(name)){
            throw new IllegalArgumentException("No existe una categoría de nombre '" + name + "'.");
        }

        /* Se retorna desde el caché */
        Category categoryByName = this.categoriesByNameCache.get(name);
        logger.info("getCategoryByName(" + name + "): {}ms", (currentTimeMillis() - init));
        return categoryByName;
    }

    /**
     * Este método es responsable de cargar los cachés de categorías.
     */
    private void loadCaches() {

        long init = currentTimeMillis();
        logger.debug("loadCaches(): iniciando carga de categorías en cache.");

        List<Category> allCategories = categoryDAO.getAllCategories();
        this.categoriesByIDCache = new HashMap<>();
        this.categoriesByNameCache = new HashMap<>();
        for (Category category : allCategories) {
            categoriesByIDCache.put(category.getId(), category);
            categoriesByNameCache.put(category.getName(), category);
        }

        this.cacheLoaded = true;
        logger.info("loadCaches() ==> {} categorías en caché.", allCategories.size());
        logger.info("loadCaches(): {}ms", (currentTimeMillis() - init));
    }

    @Override
    public List<Category> getCategories() {

        long init = currentTimeMillis();
        logger.debug("getCategories(): Recuperando todas las categorías.");

        /* If the categories have not been cached yet, they are cached now */
        if (!cacheLoaded) { loadCaches(); }

        ArrayList<Category> categories = new ArrayList<>(this.categoriesByIDCache.values());
        logger.debug("getCategories(): {}ms", currentTimeMillis() - init);

        return categories;
    }

    @Override
    public List<Category> getRelatedCategories(Category category) {
        return categoryDAO.getRelatedCategories(category);
    }

    @Override
    public List<Category> findCategories(List<String> categoriesNames) {

        List<Category> res = new ArrayList<>();
        for (String categoryName : categoriesNames) {
            logger.debug("CategoryManager.findCategories: buscando '" + categoryName + "'");

            /* Las categorias de nombre NULL o vacias se ignoran simplemente, no generan error */
            if (categoryName == null || categoryName.trim().equals("")) {
                continue;
            }

            Category found = this.getCategoryByName(categoryName.trim());
            if (found != null) {
                res.add(found);
            } else {
                throw new IllegalArgumentException("Categoria no encontrada: " + categoryName);
            }
        }

        return res;
    }

}
