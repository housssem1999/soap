package com.tekup.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tekup.models.Etudiant;
import com.tekup.repository.etudiantrepository;

@Service 
public class etudiantserviceimpl implements etudiantservice {
    @Autowired
    etudiantrepository er ;
    
    @Override
    @Transactional
    public List<Etudiant> getAll() {
        return er.findAll();
    }

    @Override
    @Transactional
    public List<Etudiant> getByfirstname(String firstname) {
        return er.findByFirstname(firstname);
    }

    @Override
    @Transactional
    public List<Etudiant> getBylastname(String lastname) {
        return er.findByLastname(lastname);
    }
 
    @Override
    @Transactional
    public List<Etudiant> getByFirstNameAndLastname(String firstName, String lastname) {
        return er.findByFirstnameAndLastname(firstName, lastname);
    }
    


    @Override
    @Transactional
    public List<Etudiant> getByEmail(String email) {
        return er.findByEmail(email);
    }

    @Override
    @Transactional
    public List<Etudiant> getByPhone(String phone) {
        return er.findByPhone(phone);
    }

    @Override
    @Transactional
    public void add(Etudiant e) {
        if(e!=null){
            er.save(e);
        }
    }

    /*public Groupe addNewGroupe(String nomGroupe , boolean isActive ) throws GroupeNameExistException, GroupeNameNotFoundException {
    	validateNewGroupeName( null  , nomGroupe ) ;
    	Groupe groupe = new Groupe() ;
    	groupe.setNomGroupe(nomGroupe);
		groupe.setDateCreation(new Date());
		groupe.setIsActive(isActive);
		groupeRepository.save(groupe);
		return groupe ;
	}*/

    @Override
    @Transactional
    public void update(Etudiant e) {
        if(er.findById(e.getId()).isEmpty()==false){
            er.save(e);
        }
    }

    @Override
    @Transactional
    public void delete(Etudiant e) {
        if(er.findById(e.getId()).isEmpty()==false){
            er.delete(e);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if(er.findById(id).isEmpty()==false){
            er.deleteById(id);
        }
    }

    @Override
    @Transactional
    public float TauxReussit() {
        int nbrEtudiantReussi=0;
        float tauxReussit = 0;
        
        List<Etudiant> etudiants = er.findAll();
        int nbrAllStudents = etudiants.size(); 

        for(Etudiant e : etudiants){           
            if (e.getMoy()>=10) {
                nbrEtudiantReussi=nbrEtudiantReussi+1;
            }
        }

        tauxReussit=((float) nbrEtudiantReussi / (float) nbrAllStudents)*100.0f;//nbrEtudiantReussi/nbrAllStudents;
        return tauxReussit;
    }

}
