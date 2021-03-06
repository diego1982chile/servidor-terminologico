package cl.minsal.semantikos.kernel.components;

import cl.minsal.semantikos.kernel.daos.SnomedCTDAO;
import cl.minsal.semantikos.model.snomedct.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

/**
 * @author Andrés Farías on 9/26/16.
 */
@Stateless
public class SnomedCTManagerImpl implements SnomedCTManager {

    @EJB
    private SnomedCTDAO snomedctDAO;

    @Override
    public SnapshotProcessingResult processSnapshot(SnomedCTSnapshot snomedCTSnapshot) {

        List<ConceptSCT> conceptSCTs = SnomedCTSnapshotFactory.getInstance().createConceptsSCTFromPath(snomedCTSnapshot.getConceptSnapshotPath());

        List<DescriptionSCT> descriptionSCTs = SnomedCTSnapshotFactory.getInstance().createDescriptionsSCTFromPath(snomedCTSnapshot.getDescriptionSnapshotPath());

        for (DescriptionSCT descriptionSCT : descriptionSCTs) {

        }

        return new SnapshotProcessingResult();
    }

    @Override
    public List<RelationshipSCT> getRelationshipsFrom(long idConceptSCT) {
        return emptyList();
    }

    @Override
    public List<ConceptSCT> findConceptsByPattern(String pattern) {
        return this.findConceptsByPattern(pattern, null);
    }

    @Override
    public List<ConceptSCT> findConceptsByPattern(String pattern, Integer group) {
        return snomedctDAO.findConceptsBy(pattern, group);
    }

    @Override
    public List<ConceptSCT> findConceptsByConceptID(long conceptIdPattern) {
        return this.findConceptsByConceptID(conceptIdPattern, null);
    }

    @Override
    public List<ConceptSCT> findConceptsByConceptID(long conceptIdPattern, Integer group) {
        return snomedctDAO.findConceptsByConceptID(conceptIdPattern, group);
    }

    @Override
    public Map<DescriptionSCT, ConceptSCT> findDescriptionsByPattern(String patternID) {
        return snomedctDAO.findDescriptionsByPattern(patternID);
    }

    @Override
    public ConceptSCT getConceptByID(long conceptID) {
        return snomedctDAO.getConceptByID(conceptID);
    }
}
