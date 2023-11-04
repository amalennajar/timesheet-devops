package tn.esprit.rh.achat;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.services.IReglementService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@Transactional
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JunitreglementTest {
    @Autowired
    IReglementService reglementService;

    @Test
    @Order(1)

    void retrieveAllReglements() {
        List<Reglement> listReglement = reglementService.retrieveAllReglements();
        assertEquals(0,listReglement.size());

    }
    @Test
    @Order(2)
    void testAddAndRetrieveReglement() {
        Reglement reglement = new Reglement();
        // Set properties of the reglement for testing

        // Assuming addReglement method correctly saves the reglement
        Reglement addedReglement = reglementService.addReglement(reglement);

        assertNotNull(addedReglement);
        assertNotNull(addedReglement.getIdReglement()); // Assuming getId() provides the ID

        // Retrieve the added reglement from the service
        Reglement retrievedReglement = reglementService.retrieveReglement(addedReglement.getIdReglement());
        assertNotNull(retrievedReglement);
        assertEquals(addedReglement.getIdReglement(), retrievedReglement.getIdReglement());
        // Add more specific assertions based on properties of the reglement
    }
    @Test
    @Order(3)
    void testRetrieveReglementById() {
        Long id = 1L; // Provide the ID of the reglement saved in the database
        Reglement reglement = reglementService.retrieveReglement(id);
        // Check if reglement is not null
        // For example:
        assertNotNull(reglement);
        assertEquals(id, reglement.getIdReglement());
    }
    @Test
    @Order(4)
    void testRetrieveReglementByFacture() {
        // Test for retrieving reglements by facture ID
        Long factureId = 1L; // Provide a valid facture ID for testing
        List<Reglement> reglements = reglementService.retrieveReglementByFacture(factureId);

        assertNotNull(reglements);
        // Add assertions based on the expected reglements for the provided facture ID
    }

}

