package com.tekup.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.models.Etudiant;
import com.tekup.rest.services.etudiantservice;


@RestController
@RequestMapping("/student")
public class etudiantcontroller {
    @Autowired
    etudiantservice es;

    @GetMapping("/")
    public List<Etudiant> getAllStudents() {
        return es.getAll();
    }
    
    @GetMapping("/getByFirstname/{firstname}")
    public List<Etudiant> getByfirstname(@PathVariable String firstname) {
        return es.getByfirstname(firstname);
    }

    @GetMapping("/getBylastname/{lastname}")
    public List<Etudiant> getBylastname(@PathVariable String lastname) {
        return es.getBylastname(lastname);
    }
/*
    @GetMapping("/getByFirstnameAndLastname/{firstname}/{lastname}")
    public List<Etudiant> getByfirstnameAndlastname(@PathVariable String firstname, @PathVariable String lastname) {
        return es.getByFirstNameAndLastname(firstname, lastname);
    }
*/
    @GetMapping("/getByEmail/{Email}")
    public List<Etudiant> getByEmail(@PathVariable String Email) {
        return es.getByEmail(Email);
    }

    @GetMapping("/getByPhone/{phone}")
    public List<Etudiant> getByPhone(@PathVariable String phone) {
        return es.getByPhone(phone);
    }

    @PostMapping("/add")
	public void addStudent(@RequestBody Etudiant e) {
        es.add(e);
    }

    @PostMapping("/update")
	public void updateStudent(@RequestBody Etudiant e) {
        es.update(e);
    }

    @DeleteMapping("/delete")
	public void deleteStudent(@RequestBody Etudiant e) {
        es.delete(e);
    }

    @DeleteMapping("/deleteById/{id}")
	public void deleteStudentById(@PathVariable Long id) {
        es.deleteById(id);
    }

    @GetMapping("/calculTauxReussite")
    public float MoyenneReussite (){
        return es.TauxReussit();
    }
}
