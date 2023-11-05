package com.tekup.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tekup.models.Etudiant;
@Repository
public interface etudiantrepository extends JpaRepository<Etudiant,Long> {
    List<Etudiant> findByFirstname(String firstname);
    List<Etudiant> findByLastname(String lastname);
    List<Etudiant> findByFirstnameAndLastname(String firstname, String lastname);
    List<Etudiant> findByEmail(String email);
    List<Etudiant> findByPhone(String phone);


}
