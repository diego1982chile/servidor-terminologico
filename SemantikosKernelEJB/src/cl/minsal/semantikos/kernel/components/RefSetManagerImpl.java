package cl.minsal.semantikos.kernel.components;

import cl.minsal.semantikos.kernel.daos.RefSetDAO;
import cl.minsal.semantikos.kernel.util.StringUtils;
import cl.minsal.semantikos.model.*;
import cl.minsal.semantikos.model.businessrules.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Timestamp;
import java.util.*;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.in;
import static java.lang.System.load;

/**
 * @author Andrés Farías on 9/20/16.
 */
@Stateless
public class RefSetManagerImpl implements RefSetManager {

    private static final Logger logger = LoggerFactory.getLogger(RefSetManagerImpl.class);

    @EJB
    private RefSetDAO refsetDAO;

    @EJB
    private AuditManager auditManager;

    /**
     * Indica si el caché fue cargado
     */
    private boolean cacheReady = false;

    /**
     * Un caché para los Refsets por su nombre
     */
    private Map<Long, RefSet> refsetCacheByID = new HashMap<>();

    /**
     * Un caché para los Refsets por su ID
     */
    private Map<String, RefSet> refsetCacheByName = new HashMap<>();

    @Override
    public RefSet createRefSet(RefSet refSet, User user) {
        RefSet refsetPersist = createRefSet(refSet.getName(), refSet.getInstitution(), user);

        /* Se guardan los conceptos asignados al refset*/
        for (ConceptSMTK concept : refSet.getConcepts()) {
            bindConceptToRefSet(concept, refsetPersist, user);
            refsetPersist.bindConceptTo(concept);
        }

        /* Se agrega al cache */
        addToCache(refsetPersist);

        return refsetPersist;
    }

    /**
     * Este método es responsable de agregar un nuevo refset a los caché.
     *
     * @param refSet El RefSet que se desea agregar.
     */
    private void addToCache(RefSet refSet) {
        if (!cacheReady) {
            loadCache();
        }

        refsetCacheByID.put(refSet.getId(), refSet);
        refsetCacheByName.put(refSet.getName(), refSet);
    }

    @Override
    public RefSet createRefSet(String name, Institution institution, User user) {

        /* Se validan las pre-condiciones */
        new RefSetCreationBR().validatePreConditions(institution, user);

        /* Se crea el RefSet y se persiste */
        RefSet refSet = new RefSet(name, institution, new Timestamp(currentTimeMillis()));
        refsetDAO.persist(refSet);

        /* Se almacena en el cache */
        addToCache(refSet);

        /* Se registra la creación */
        auditManager.recordRefSetCreation(refSet, user);
        return refSet;
    }

    @Override
    public RefSet updateRefSet(RefSet refSet, User user) {

        /* Se validan las pre-condiciones */
        new RefSetUpdateBR().validatePreConditions(refSet, user);

        /* Se crea el RefSet y se persiste */
        refsetDAO.update(refSet);
        addToCache(refSet);

        /* Se registra la creación */
        auditManager.recordRefSetUpdate(refSet, user);


        /* Se registra la creación del RefSet */
        return refSet;
    }

    @Override
    public void bindConceptToRefSet(ConceptSMTK conceptSMTK, RefSet refSet, User user) {

        /* Se validan las pre-condiciones */
        new RefSetBindingBR().validatePreConditions();

        /* Se asocia la descripción al RefSet */
        refsetDAO.bind(conceptSMTK, refSet);

        /* Se registra la creación */
        auditManager.recordRefSetBinding(refSet, conceptSMTK, user);
    }

    @Override
    public void unbindConceptToRefSet(ConceptSMTK conceptSMTK, RefSet refSet, User user) {

        /* Se validan las pre-condiciones */
        new RefSetUnbindingBR().validatePreConditions();

        /* Se asocia la descripción al RefSet */
        refsetDAO.unbind(conceptSMTK, refSet);

        /* Se registra la creación */
        auditManager.recordRefSetUnbinding(refSet, conceptSMTK, user);
    }

    @Override
    public void invalidate(RefSet refSet, User user) {

        /* Se validan las pre-condiciones */
        new RefSetInvalidationBR().validatePreConditions();

        /* Se asocia la descripción al RefSet */
        refSet.setValidityUntil(new Timestamp(currentTimeMillis()));
        refsetDAO.update(refSet);

        /* Se registra la creación */
        auditManager.recordRefSetInvalidate(refSet, user);
    }

    @Override
    public List<RefSet> getAllRefSets() {

        if (cacheReady){
            return new ArrayList<>(refsetCacheByID.values());
        }

        return refsetDAO.getReftsets();
    }

    @Override
    public List<RefSet> getValidRefSets() {
        return refsetDAO.getValidRefsets();
    }

    @Override
    public List<RefSet> getRefsetByInstitution(Institution institution) {
        if (institution.getId() == -1) {
            return Collections.emptyList();
        } else {
            return refsetDAO.getRefsetBy(institution);
        }

    }

    @Override
    public List<RefSet> getRefsetsBy(ConceptSMTK conceptSMTK) {
        return refsetDAO.getRefsetsBy(conceptSMTK);
    }

    @Override
    public List<RefSet> getRefsetsBy(List<Long> categories, String pattern) {
        // TODO: Terminar lo que sea que haga esto
        return null;
    }

    @Override
    public List<RefSet> findRefsetsByName(String pattern) {
        return this.refsetDAO.findRefsetsByName(StringUtils.toSQLLikePattern(pattern));
    }

    @Override
    public RefSet getRefsetByName(String pattern) {

        /* Se verifica si el caché ya fué cargado */
        if (!this.cacheReady) {
            loadCache();
        }

        /* Se verifica que exista tal RefSet */
        if (!this.refsetCacheByName.containsKey(pattern)) {
            throw new IllegalArgumentException("No existe un RefSet de nombre " + pattern);
        }

        /* Se retorna desde el caché */
        return refsetCacheByName.get(pattern);

    }

    /**
     * Este método es responsable de cargar los refsets en los cachés.
     */
    private void loadCache() {

        long init = currentTimeMillis();

        List<RefSet> allRefSets = getAllRefSets();
        for (RefSet aRefSet : allRefSets) {
            this.refsetCacheByName.put(aRefSet.getName(), aRefSet);
            this.refsetCacheByID.put(aRefSet.getId(), aRefSet);
        }

        logger.debug("loadCache(): {} refsets cargados", allRefSets.size());
        logger.debug("loadCache(): in {}ms", currentTimeMillis() - init);
    }

    @Override
    public List<RefSet> findRefSetsByName(List<String> refSetNames) {

        /* Logging */
        logger.debug("RefSetManager.findRefSetsByName(" + refSetNames + ")");

        /* Si se utilizó el método sin refsets se retorna de inmediato */
        if (refSetNames == null || refSetNames.isEmpty()) {
            logger.debug("RefSetManager.findRefSetsByName(" + refSetNames + ") --> emptyList()");
            return Collections.emptyList();
        }

        List<RefSet> res = new ArrayList<>();
        for (String refSetName : refSetNames) {

            /* Si por alguna razon el refset viene vacio se ignora */
            if (refSetName == null || refSetName.trim().equals("")) {
                logger.debug("RefSetManager.findRefSetsByName(" + refSetNames + ")[" + refSetName + "] --> ignored");
                continue;
            }

            RefSet found = this.getRefsetByName(refSetName);
            if (found != null) {
                res.add(found);
            } else {
                throw new NoSuchElementException("RefSet no encontrado: " + refSetName);
            }
        }
        return res;
    }

    @Override
    public void loadConceptRefSets(ConceptSMTK conceptSMTK) {
        if (conceptSMTK != null) {
            conceptSMTK.setRefsets(this.findByConcept(conceptSMTK));
        }
    }

    @Override
    public List<RefSet> findByConcept(ConceptSMTK conceptSMTK) {
        return this.refsetDAO.findByConcept(conceptSMTK);
    }

}
