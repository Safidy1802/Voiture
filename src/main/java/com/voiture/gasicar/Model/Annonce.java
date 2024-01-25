package com.voiture.gasicar.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.voiture.gasicar.Dao.Column;
import com.voiture.gasicar.Dao.Connector;
import com.voiture.gasicar.Dao.DAO;
import com.voiture.gasicar.Dao.TableInfo;

@TableInfo(name = "annonce", user = "postgres", pass = "postgres", database = "gasycar")
public class Annonce extends DAO{
    @Column(isPrimary = true, name = "id")
    Integer id;
    @Column(name = "id_voiture")
    Integer voiture;
    @Column(name = "prix")
    Float prix;
    @Column(name = "descriptions")
    String description;
    @Column(name = "date_annonce")
    Date date_annonce;
    @Column(name = "etat")
    Integer etat;
    
    public Annonce() {
    }

    public Integer getIdLastVoiture(Connection co) throws Exception {
        Integer i = null;
        boolean nisokatra = false;
        if (co == null) {
            co = new Connector().postgresql("postgres", "postgres", "gasycar");
            nisokatra = true;
        }
        String sql = "Select id as id_voiture from voiture order by id desc limit 1";
        Statement state = co.createStatement();
        ResultSet res = state.executeQuery(sql);
        if (res.next()) {
            i = res.getInt("id_voiture");
        }
        if (nisokatra) {
            try {
                co.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    public Integer getEtatAnnonce(Connection co, Integer id_annonce) throws Exception{
        Integer i = null;
        boolean nisokatra = false;
        if (co == null) {
            co = new Connector().postgresql("postgres", "postgres", "gasycar");
            nisokatra = true;
        }
        String sql = "Select etat from annonce where id='"+id_annonce+"'";
        Statement state = co.createStatement();
        ResultSet res = state.executeQuery(sql);
        if (res.next()) {
            i = res.getInt("etat");
        }
        if (nisokatra) {
            try {
                co.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    public void validateAnnonce(Connection co, Integer id_annonce) throws Exception {
        boolean nisokatra = false;
        if (co == null) {
            co = new Connector().postgresql("postgres", "postgres", "gasycar");
            nisokatra = true;
        }
        String sql = "update annonce set etat = 10 where id='"+id_annonce+"'";
        Statement state = co.createStatement();
        state.execute(sql);
        co.commit();
        if (nisokatra) {
            try {
                co.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void refuserAnnonce(Connection co, Integer id_annonce) throws Exception{
        boolean nisokatra = false;
        if (co == null) {
            co = new Connector().postgresql("postgres", "postgres", "gasycar");
            nisokatra = true;
        }
        String sql = "update annonce set etat = 5 where id='"+id_annonce+"'";
        Statement state = co.createStatement();
        state.execute(sql);
        co.commit();
        if (nisokatra) {
            try {
                co.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } 
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getVoiture() {
        return voiture;
    }
    public void setVoiture(Integer voiture) {
        this.voiture = voiture;
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
    
}
