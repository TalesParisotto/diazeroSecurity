package diazeroSecurity.demo.service;

import diazeroSecurity.demo.entity.Incident;
import diazeroSecurity.demo.repository.IncidentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IncidentServiceTest {

    @InjectMocks
    private IncidentService incidentService;

    @Mock
    private IncidentRepository repository;

    @Test
    void saveIncident() {
        Incident incident = new Incident();
        incident.setName("Tales");

        when(repository.save(any())).thenReturn(incident);

        Incident incidentReturn = incidentService.saveIncident(incident);

        assertEquals(incident.getName(), incidentReturn.getName());
    }

    @Test
    void getIncidentById() {

        Optional<Incident> incident = Optional.of(new Incident());
        incident.get().setId(1);

        doReturn(incident).when(repository).findById(1);

        Incident incidentReturn = incidentService.getIncidentById(1);

        assertEquals(incident.get().getId(), incidentReturn.getId());
    }
}