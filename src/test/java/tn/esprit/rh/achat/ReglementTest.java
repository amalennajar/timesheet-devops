package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sun.security.krb5.internal.ccache.MemoryCredentialsCache;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.ReglementServiceImpl;

import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest
@Transactional
public class ReglementTest {

    @Autowired
    private ReglementRepository reglementRepository;

    @Autowired
    private FactureRepository factureRepository;
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

    @Test
    public void testRetrieveReglementByFacture() {
        // Create a Facture and associate Reglements
        Facture facture = new Facture(/* initialize with data */);
        MemoryCredentialsCache factureRepository;
        factureRepository.save(facture);

        Reglement reglement1 = new Reglement(/* initialize with data */);
        Reglement reglement2 = new Reglement(/* initialize with data */);
        reglement1.setFacture(facture);
        reglement2.setFacture(facture);
        reglementRepository.save(reglement1);
        reglementRepository.save(reglement2);

        // Test
        List<Reglement> result = reglementService.retrieveReglementByFacture(facture.getIdFacture());
        assertEquals(2, result.size());
    }

    @Test
    public void testGetChiffreAffaireEntreDeuxDate() {
        // Create Reglements with dates in the given range
        Reglement reglement1 = new Reglement(/* initialize with a date in the range */);
        Reglement reglement2 = new Reglement(/* initialize with a date in the range */);
        Reglement reglement3 = new Reglement(/* initialize with a date not in the range */);
        reglementRepository.save(reglement1);
        reglementRepository.save(reglement2);
        reglementRepository.save(reglement3);

        // Test
        Date startDate = /* set start date */;
        Date endDate = /* set end date */;
        float result = reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate);
        // Perform assertions based on known values in the range
    }
}
