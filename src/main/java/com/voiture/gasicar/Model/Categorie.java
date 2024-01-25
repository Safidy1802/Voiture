package com.voiture.gasicar.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_categorie ;
    String nom_categorie ;
    
    

    public Categorie() {
    }



    public Categorie(int id_categorie, String nom_categorie) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
    }



    public int getId_categorie() {
        return id_categorie;
    }



    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }



    public String getNom_categorie() {
        return nom_categorie;
    }



    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }
    
}
