package com.voiture.gasicar.Model;

import java.sql.Date;

import com.voiture.gasicar.Dao.Column;
import com.voiture.gasicar.Dao.DAO;
import com.voiture.gasicar.Dao.TableInfo;

@TableInfo(name = "voiture", user = "Safidimalala54", pass = "yqs1NltKOUn5", database = "gasycar")
public class Vente extends DAO{
    @Column(name = "id", isPrimary = true)
    Integer id;
    @Column(name = "id_annonce")
    Integer id_annonce;
    @Column(name = "vendeur")
    String vendeur;
    @Column(name = "acheteur")
    String acheteur;
    @Column(name = "prix")
    Float prix;
    @Column(name = "date_vente")
    Date date_vente;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId_annonce() {
        return id_annonce;
    }
    public void setId_annonce(Integer id_annonce) {
        this.id_annonce = id_annonce;
    }
    public String getVendeur() {
        return vendeur;
    }
    public void setVendeur(String vendeur) {
        this.vendeur = vendeur;
    }
    public String getAcheteur() {
        return acheteur;
    }
    public void setAcheteur(String acheteur) {
        this.acheteur = acheteur;
    }
    public Float getPrix() {
        return prix;
    }
    public void setPrix(Float prix) {
        this.prix = prix;
    }
    public Date getDate_vente() {
        return date_vente;
    }
    public void setDate_vente(Date date_vente) {
        this.date_vente = date_vente;
    }

}
