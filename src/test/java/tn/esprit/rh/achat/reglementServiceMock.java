package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.ReglementServiceImpl;

@ExtendWith(MockitoExtension.class)
public class reglementServiceMock {

    @Mock
    private  ReglementRepository reglementRepository ;

    @InjectMocks
    private ReglementServiceImpl reglementService;










}
