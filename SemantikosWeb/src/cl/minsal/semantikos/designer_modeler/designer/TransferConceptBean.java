package cl.minsal.semantikos.designer_modeler.designer;

import javax.faces.bean.ManagedBean;

/**
 * @author Andrés Farías on 11/24/16.
 */

@ManagedBean(name = "transferConceptBean")
public class TransferConceptBean {

    /** El ID de la categoría destino */
    private long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTransferConcept() {
        //TODO: Implement me!
        return null;
    }
}
