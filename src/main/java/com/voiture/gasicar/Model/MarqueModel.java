package com.voiture.gasicar.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "marque_model")
public class MarqueModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer marque;

    private String nomModel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMarque() {
        return marque;
    }

    public void setMarque(Integer marque) {
        this.marque = marque;
    }

    public String getNomModel() {
        return nomModel;
    }

    public void setNomModel(String nomModel) {
        this.nomModel = nomModel;
    }

    // Getters and setters
}

