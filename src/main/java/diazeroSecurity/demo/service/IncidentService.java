package diazeroSecurity.demo.service;

import diazeroSecurity.demo.entity.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import diazeroSecurity.demo.repository.IncidentRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository repository;

    public Incident saveIncident(Incident incident) {
        incident.setCreatedAt(LocalDateTime.now());
        return repository.save(incident);
    }

    public List<Incident> getIncidents() {
        return repository.findAll();
    }

    public Incident getIncidentById(int id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteIncident(int id) {
        repository.deleteById(id);
        return "Incident removed !! " + id;
    }

    public Incident updateIncident(Incident incident) {
        Incident existingIncident = repository.findById(incident.getId()).orElse(null);
        existingIncident.setName(incident.getName());
        existingIncident.setDescription(incident.getDescription());
        existingIncident.setUpdatedAt(LocalDateTime.now());
        return repository.save(existingIncident);
    }


}
