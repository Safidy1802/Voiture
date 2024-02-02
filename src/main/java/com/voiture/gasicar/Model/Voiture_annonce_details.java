package com.voiture.gasicar.Model;

import java.sql.Date;

import com.voiture.gasicar.Dao.Column;
import com.voiture.gasicar.Dao.DAO;
import com.voiture.gasicar.Dao.TableInfo;

@TableInfo(name = "v_voiture_annonce_details", user = "Safidimalala54", pass = "yqs1NltKOUn5", database = "gasycar")
public class Voiture_annonce_details extends DAO{
    @Column(name = "id_annonce")
    Integer id_annonce;
    @Column(name = "id")
    Integer id_voiture;
    @Column(name = "id_user")
    String id_user;
    @Column(name = "marque")
    String marque;
    @Column(name = "model")
    String model;
    @Column(name = "categorie")
    String categorie;
    @Column(name = "transmission")
    String transmission;
    @Column(name = "couleur")
    String couleur;
    @Column(name = "energie")
    String energie;
    @Column(name = "pays")
    String pays;
    @Column(name = "matricule")
    String matricule;
    @Column(name = "annee")
    Integer annee;
    @Column(name = "consommation")
    Float consommation;
    @Column(name = "reservoir")
    Float reservoir;
    @Column(name = "nombre_place")
    Integer place;
    @Column(name = "kilometrage")
    Float kilometrage;
    @Column(name = "prix")
    Float prix;
    @Column(name = "descriptions")
    String description;
    @Column(name = "date_annonce")
    Date date_annonce;
    @Column(name = "status")
    Integer status;
    @Column(name = "etat")
    Integer etat;

    public Integer getId_annonce() {
        return id_annonce;
    }
    public void setId_annonce(Integer id_annonce) {
        this.id_annonce = id_annonce;
    }
    public Integer getId_voiture() {
        return id_voiture;
    }
    public void setId_voiture(Integer id_voiture) {
        this.id_voiture = id_voiture;
    }
    public String getId_user() {
        return id_user;
    }
    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public String getTransmission() {
        return transmission;
    }
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    public String getEnergie() {
        return energie;
    }
    public void setEnergie(String energie) {
        this.energie = energie;
    }
    public String getPays() {
        return pays;
    }
    public void setPays(String pays) {
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
    public Float getConsommation() {
        return consommation;
    }
    public void setConsommation(Float consommation) {
        this.consommation = consommation;
    }
    public Float getReservoir() {
        return reservoir;
    }
    public void setReservoir(Float reservoir) {
        this.reservoir = reservoir;
    }
    public Integer getPlace() {
        return place;
    }
    public void setPlace(Integer place) {
        this.place = place;
    }
    public Float getKilometrage() {
        return kilometrage;
    }
    public void setKilometrage(Float kilometrage) {
        this.kilometrage = kilometrage;
    }
    public Float getPrix() {
        return prix;
    }
    public void setPrix(Float prix) {
        this.prix = prix;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDate_annonce() {
        return date_annonce;
    }
    public void setDate_annonce(Date date_annonce) {
        this.date_annonce = date_annonce;
    }
    public Integer getEtat() {
        return etat;
    }
    public void setEtat(Integer etat) {
        this.etat = etat;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
}
