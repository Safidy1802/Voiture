package com.voiture.gasicar.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.voiture.gasicar.Dao.Column;
import com.voiture.gasicar.Dao.Connector;
import com.voiture.gasicar.Dao.DAO;
import com.voiture.gasicar.Dao.TableInfo;

@TableInfo(name = "v_voiture_annonce_details_photo", user = "Safidimalala54", pass = "yqs1NltKOUn5", database = "gasycar")
public class Voiture_annonce_details extends DAO {
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
    @Column(name = "photo")
    String photo;

    public Vector<Voiture_annonce_details> annonceAvancer(Connection co, String marque, String model, String categorie,
            String transmission, String couleur, String energie,
            String pays, String annee, String conso, String reservoir, String place, String kmmax, String prixmax,
            String date) throws Exception {
        Vector<Voiture_annonce_details> annonce = new Vector<>();
        boolean nisokatra = false;
        if (co == null) {
            co = new Connector().postgresql("Safidimalala54", "yqs1NltKOUn5", "gasycar");
            nisokatra = true;
        }
        Integer an = Integer.valueOf(annee);
        Float consommation = Float.valueOf(conso);
        Float reserve = Float.valueOf(reservoir);
        Integer plac = Integer.parseInt(place);
        Float km = Float.valueOf(kmmax);
        Float prix = Float.valueOf(prixmax);
        Date data_annonce = Date.valueOf(date);
        String sql = "SELECT * FROM v_voiture_annonce_detail " +
                "WHERE (date_annonce = '" + data_annonce + "' OR '" + data_annonce + "' IS NULL) " +
                "AND (categorie = '" + categorie + "' OR '" + categorie + "' IS NULL) " +
                "AND (marque = '" + marque + "' OR '" + marque + "' IS NULL) " +
                "AND (model = '" + model + "' OR '" + model + "' IS NULL) " +
                "AND (transmission = '" + transmission + "' OR '" + transmission + "' IS NULL) " +
                "AND (couleur = '" + couleur + "' OR '" + couleur + "' is null) " +
                "and (energie = '" + energie + "' or '" + energie + "' is null) " +
                "and (pays = '" + pays + "' or '" + pays + "' is null) " +
                "and (annee = " + an + " or " + an + " is null) " +
                "and (consommation = " + consommation + " or " + consommation + " is null) " +
                "and (reservoir = " + reserve + " or " + reserve + " is null) " +
                "and (nombre_place = " + plac + " or " + plac + " is null) " +
                "and (kilometrage <= " + km + " OR " + km + " IS NULL) " +
                "AND (prix <= " + prix + " OR " + prix + " IS NULL) ";
        System.out.println(sql);
        PreparedStatement state = co.prepareStatement(sql);
        ResultSet res = state.executeQuery();
        while (res.next()) {
            Voiture_annonce_details vad = new Voiture_annonce_details();
            vad.id_annonce = res.getInt("id_annonce");
            vad.id_voiture = res.getInt("id");
            vad.id_user = res.getString("id_user");
            vad.marque = res.getString("marque");
            vad.model = res.getString("model");
            vad.categorie = res.getString("categorie");
            vad.transmission = res.getString("transmission");
            vad.couleur = res.getString("couleur");
            vad.energie = res.getString("energie");
            vad.pays = res.getString("pays");
            vad.matricule = res.getString("matricule");
            vad.annee = res.getInt("annee");
            vad.consommation = res.getFloat("consommation");
            vad.reservoir = res.getFloat("reservoir");
            vad.place = res.getInt("nombre_place");
            vad.kilometrage = res.getFloat("kilometrage");
            vad.prix = res.getFloat("prix");
            vad.description = res.getString("descriptions");
            vad.date_annonce = res.getDate("date_annonce");
            vad.status = res.getInt("status");
            vad.etat = res.getInt("etat");
            annonce.add(vad);
        }
        if (nisokatra) {
            try {
                co.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return annonce;
    }

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
