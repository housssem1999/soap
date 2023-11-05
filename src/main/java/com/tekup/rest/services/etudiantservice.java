package com.tekup.rest.services;
import java.util.List;
import com.tekup.models.Etudiant;

public interface etudiantservice {
    
	List<Etudiant> getAll ();

	List<Etudiant> getByfirstname (String firstname);
	List<Etudiant> getBylastname (String lastname);
	List<Etudiant> getByFirstNameAndLastname(String firstName, String lastname);
	List<Etudiant> getByEmail (String Email);
	List<Etudiant> getByPhone (String phone);

	void add (Etudiant e);

	void update (Etudiant e);

	void delete (Etudiant e);
	void deleteById (Long id);

	float TauxReussit ();
}
