package com.voiture.gasicar.Model;

import com.voiture.gasicar.Dao.Column;
import com.voiture.gasicar.Dao.DAO;
import com.voiture.gasicar.Dao.TableInfo;

@TableInfo(name = "voiture", user = "Safidimalala54", pass = "yqs1NltKOUn5", database = "gasycar")
public class Voiture extends DAO{
    @Column(isPrimary = true, name = "id")
    Integer id;
    @Column(name = "id_user")
    String iduser;
    @Column(name = "id_marque_model")
    Integer marque;
    @Column(name = "id_categorie")
    Integer categorie;
    @Column(name = "id_transmission")
    Integer transmission;
    @Column(name = "id_couleur")
    Integer couleur;
    @Column(name = "id_energie")
    Integer energie;
    @Column(name = "id_pays")
    Integer pays;
    @Column(name = "matricule")
    String matricule;
    @Column(name = "annee")
    Integer annee;
    @Column(name = "consommation")
    Float conso;
    @Column(name = "reservoir")
    Float reservoir;
    @Column(name = "nombre_place")
    Integer nbr_place;
    @Column(name = "kilometrage")
    Float kilometrage;
    
    public Voiture(Integer id, String iduser, Integer marque, Integer categorie, Integer transmission, Integer couleur,
            Integer energie, Integer pays, String matricule, Integer annee, Float conso, Float reservoir,
            Integer nbr_place, Float kilometrage) {
        this.id = id;
        this.iduser = iduser;
        this.marque = marque;
        this.categorie = categorie;
        this.transmission = transmission;
        this.couleur = couleur;
        this.energie = energie;
        this.pays = pays;
        this.matricule = matricule;
        this.annee = annee;
        this.conso = conso;
        this.reservoir = reservoir;
        this.nbr_place = nbr_place;
        this.kilometrage = kilometrage;
    }

    public Voiture() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public Integer getMarque() {
        return marque;
    }

    public void setMarque(Integer marque) {
        this.marque = marque;
    }

    public Integer getCategorie() {
        return categorie;
    }

    public void setCategorie(Integer categorie) {
        this.categorie = categorie;
    }

    public Integer getTransmission() {
        return transmission;
    }

    public void setTransmission(Integer transmission) {
        this.transmission = transmission;
    }

    public Integer getCouleur() {
        return couleur;
    }

    public void setCouleur(Integer couleur) {
        this.couleur = couleur;
    }

    public Integer getEnergie() {
        return energie;
    }

    public void setEnergie(Integer energie) {
        this.energie = energie;
    }

    public Integer getPays() {
        return pays;
    }

    public void setPays(Integer pays) {
        this.pays = pays;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Float getConso() {
        return conso;
    }

    public void setConso(Float conso) {
        this.conso = conso;
    }

    public Float getReservoir() {
        return reservoir;
    }

    public void setReservoir(Float reservoir) {
        this.reservoir = reservoir;
    }

    public Integer getNbr_place() {
        return nbr_place;
    }

    public void setNbr_place(Integer nbr_place) {
        this.nbr_place = nbr_place;
    }

    public Float getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Float kilometrage) {
        this.kilometrage = kilometrage;
    }
}