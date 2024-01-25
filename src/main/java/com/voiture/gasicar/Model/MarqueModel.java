package com.voiture.gasicar.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "marque_model")
public class MarqueModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_marque", nullable = false)
    private Marque marque;

    private String nomModel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
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

