package com.voiture.gasicar.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "couleur")
public class Couleur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getters and setters
}

