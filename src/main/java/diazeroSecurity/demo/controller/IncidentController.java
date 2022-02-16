package diazeroSecurity.demo.controller;

import diazeroSecurity.demo.entity.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import diazeroSecurity.demo.service.IncidentService;

import java.util.List;

@RestController
public class IncidentController {

    @Autowired
    private IncidentService service;

    @PostMapping("/addIncidents")
    public Incident addIncident(@RequestBody Incident incident) {
        return service.saveIncident(incident);
    }

    @GetMapping("/incidents")
    public List<Incident> findAllIncidents() {
        return service.getIncidents();
    }

    @GetMapping("/incidentById/{id}")
    public Incident findIncidentById(@PathVariable int id) {
        return service.getIncidentById(id);
    }


    @PutMapping("/update")
    public Incident updateIncident(@RequestBody Incident incident) {
        return service.updateIncident(incident);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteIncident(@PathVariable int id) {
        return service.deleteIncident(id);
    }
}
