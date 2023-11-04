package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class SecteurActiviteTestMock {

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @InjectMocks
    private SecteurActiviteServiceImpl secteurActiviteService;

    @Test
    public void testRetrieveAllSecteurActivite() {
        SecteurActivite secteur1 = new SecteurActivite(1L, "Code1", "Libelle1", null);
        SecteurActivite secteur2 = new SecteurActivite(2L, "Code2", "Libelle2", null);
        List<SecteurActivite> secteurList = Arrays.asList(secteur1, secteur2);

        when(secteurActiviteRepository.findAll()).thenReturn(secteurList);

        List<SecteurActivite> result = secteurActiviteService.retrieveAllSecteurActivite();

        verify(secteurActiviteRepository, times(1)).findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testAddSecteurActivite() {
        SecteurActivite secteur = new SecteurActivite(3L, "Code3", "Libelle3", null);

        when(secteurActiviteRepository.save(secteur)).thenReturn(secteur);

        SecteurActivite addedSecteur = secteurActiviteService.addSecteurActivite(secteur);

        verify(secteurActiviteRepository, times(1)).save(secteur);
        assertEquals(secteur, addedSecteur);
    }

    @Test
    public void testDeleteSecteurActivite() {
        long idToDelete = 1L;

        secteurActiviteService.deleteSecteurActivite(idToDelete);

        verify(secteurActiviteRepository, times(1)).deleteById(idToDelete);
    }

    @Test
    public void testUpdateSecteurActivite() {
        SecteurActivite existingSecteur = new SecteurActivite(1L, "Code1", "Libelle1", null);

        when(secteurActiviteRepository.save(existingSecteur)).thenReturn(existingSecteur);

        SecteurActivite updatedSecteur = secteurActiviteService.updateSecteurActivite(existingSecteur);

        verify(secteurActiviteRepository, times(1)).save(existingSecteur);
        assertEquals(existingSecteur, updatedSecteur);
    }

    @Test
    public void testRetrieveSecteurActiviteById() {
        long idToRetrieve = 1L;
        SecteurActivite secteur = new SecteurActivite(idToRetrieve, "Code1", "Libelle1", null);

        when(secteurActiviteRepository.findById(idToRetrieve)).thenReturn(Optional.of(secteur));

        SecteurActivite retrievedSecteur = secteurActiviteService.retrieveSecteurActivite(idToRetrieve);

        verify(secteurActiviteRepository, times(1)).findById(idToRetrieve);
        assertEquals(secteur, retrievedSecteur);
    }

}
