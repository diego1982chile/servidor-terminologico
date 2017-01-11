package cl.minsal.semantikos.ws.component;

import cl.minsal.semantikos.kernel.components.CategoryManager;
import cl.minsal.semantikos.model.Category;
import cl.minsal.semantikos.ws.fault.NotFoundFault;
import cl.minsal.semantikos.ws.response.CategoryResponse;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Development on 2016-11-18.
 */
@Stateless
public class CategoryController {

    @EJB
    private CategoryManager categoryManager;

    /**
     * Este método es responsable de recuperar los objetos de negocio que representan a las categorías dadas por sus
     * nombres en las palabras.
     *
     * @param categoriesNames Los nombres de las categorías que se desea buscar. Si la lista está vacía, se
     *                        interpreta como todas las categorías.
     * @return Una lista de todas las categorías.
     * @throws NotFoundFault Arrojado si uno de los nombres no tiene una representación en objetos.
     */
    public List<Category> findCategories(List<String> categoriesNames) throws NotFoundFault {

        /* Si no se indican categorías, se retornan todas */
        if (categoriesNames == null || categoriesNames.isEmpty()) {
            return this.categoryManager.getCategories();
        }

        /* Si no, se delega al Manager */
        try {
            return this.categoryManager.findCategories(categoriesNames);
        } catch (Exception e) {
            throw new NotFoundFault(e.getMessage());
        }
    }

    public List<CategoryResponse> categoryList() throws NotFoundFault {
        List<CategoryResponse> res = new ArrayList<>();
        List<Category> categories = this.categoryManager.getCategories();
        if (categories != null) {
            for (Category category : categories) {
                res.add(this.getResponse(category));
            }
        }
        return res;
    }

    public CategoryResponse getResponse(Category category) throws NotFoundFault {
        if (category == null) {
            throw new NotFoundFault("Categoria no encontrada");
        }
        return new CategoryResponse(category);
    }

}
