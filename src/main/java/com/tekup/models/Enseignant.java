package com.tekup.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@AllArgsConstructor//generates a constructor with all fields as parameters.
@NoArgsConstructor
@Data//generates common methods such as getters, setters,
@Table(name = "Enseignants")//to specify the name of the database table that corresponds to the entity


public class Enseignant {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="FName")  
    private String firstname;
    @Column(name="LName")
    private String lastname;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="Phone")
    private Double phone;
   
}
