package com.tekup.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Etudiant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="firstname", length = 50)
    private String firstname; // camelCase
    
    @Column(name="lastname", length = 50)
    private String lastname;
    
    @Column(name="email", length = 50)
    private String email;
    @Column(name="password")
    private String password;
    
    @Column(name="phone", length = 8)
    private String phone;

    //@Column(name="Moy", length = 50)
    private float moy;

}