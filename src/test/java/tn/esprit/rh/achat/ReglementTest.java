package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.ReglementServiceImpl;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest
@Transactional
public class ReglementTest {

    @Autowired
    private ReglementRepository reglementRepository;

    @Autowired
    private ReglementServiceImpl reglementService;

    @Test
    public void testRetrieveAllReglements() {
        // Prepare test data: Save some Reglement objects
        Reglement reglement1 = new Reglement(/* initialize with data */);
        Reglement reglement2 = new Reglement(/* initialize with data */);
        reglementRepository.save(reglement1);
        reglementRepository.save(reglement2);

        // Test
        List<Reglement> result = reglementService.retrieveAllReglements();
        assertEquals(2, result.size());
    }

    @Test
    public void testAddReglement() {
        // Create a new Reglement object
        Reglement reglement = new Reglement(/* initialize with data */);

        // Test
        Reglement addedReglement = reglementService.addReglement(reglement);
        assertNotNull(addedReglement.getIdReglement());
    }

    @Test
    public void testRetrieveReglement() {
        // Create and save a Reglement
        Reglement reglement = new Reglement(/* initialize with data */);
        reglementRepository.save(reglement);

        // Test
        Reglement retrievedReglement = reglementService.retrieveReglement(reglement.getIdReglement());
        assertNotNull(retrievedReglement);
        assertEquals(reglement.getIdReglement(), retrievedReglement.getIdReglement());
    }

}
