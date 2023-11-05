package com.tekup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tekup.models.Enseignant;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {
    
}
