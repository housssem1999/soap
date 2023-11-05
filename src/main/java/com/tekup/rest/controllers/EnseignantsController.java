package com.tekup.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tekup.models.Enseignant;
import com.tekup.rest.services.EnseignantService;

@RestController // to indicate that it's a Spring MVC controller
@RequestMapping("/enseignants") // the base path for the controller
public class EnseignantsController {
     @Autowired
    private EnseignantService service;

    @PostMapping("/addEnseignant")
    public Enseignant addEnseignant(@RequestBody Enseignant Enseignant) {
        return service.saveEnseignant(Enseignant);
    }

    @PostMapping("/addEnseignants")
    public List<Enseignant> addEnseignants(@RequestBody List<Enseignant> Enseignants) {
        return service.saveEnseignants(Enseignants);
    }

    @GetMapping("/Enseignants")
    public List<Enseignant> findAllEnseignants() {
        return service.getEnseignants();
    }

    @GetMapping("/EnseignantById/{id}")
    public Enseignant findEnseignantById(@PathVariable int id) {
        return service.getEnseignantById(id);
    }

    @PutMapping("/updateEnseignant")
    public Enseignant updateEnseignant(@RequestBody Enseignant Enseignant) {
        return service.updateEnseignant(Enseignant);
    }

    @DeleteMapping("/deleteEnseignant/{id}")
    public String deleteEnseignant(@PathVariable int id) {
        return service.deleteEnseignant(id);
    }
}
