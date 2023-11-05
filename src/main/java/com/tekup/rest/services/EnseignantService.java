package com.tekup.rest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tekup.models.Enseignant;
import com.tekup.repository.EnseignantRepository;

@Service
public class EnseignantService {
    @Autowired
    private EnseignantRepository repository;

    public Enseignant saveEnseignant(Enseignant enseignant) {
        return repository.save(enseignant);
    }

    public List<Enseignant> saveEnseignants(List<Enseignant> enseignants) {
        return repository.saveAll(enseignants);
    }

    public List<Enseignant> getEnseignants() {
        return repository.findAll();
    }

    public Enseignant getEnseignantById(int id) {
        // Use Optional to handle the result
        return repository.findById(id).orElse(null);
    }

    public String deleteEnseignant(int id) {
        repository.deleteById(id);
        return "Enseignant removed !! " + id;
    }

    public Enseignant updateEnseignant(Enseignant enseignant) {
        // Use Optional to handle the result
        Enseignant existingEnseignant = repository.findById(enseignant.getId()).orElse(null);

        if (existingEnseignant != null) {
            // Update the existing Enseignant
            existingEnseignant.setFirstname(enseignant.getFirstname());
            existingEnseignant.setLastname(enseignant.getLastname());
            existingEnseignant.setEmail(enseignant.getEmail());
            existingEnseignant.setPhone(enseignant.getPhone());

            return repository.save(existingEnseignant);
        } else {
            // Handle the case where the Enseignant with the specified ID was not found.
            return null;
        }
    }
}
