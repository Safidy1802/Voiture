package com.voiture.gasicar.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.voiture.gasicar.Dao.Column;
import com.voiture.gasicar.Dao.Connector;
import com.voiture.gasicar.Dao.DAO;
import com.voiture.gasicar.Dao.TableInfo;

@TableInfo(name = "annonce", user = "Safidimalala54", pass = "yqs1NltKOUn5", database = "gasycar")
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

    public Integer getNbrAnnonceParEtat(Connection co, Integer etat) throws Exception {
        Integer isa = null;
        boolean nisokatra = false;
        if (co == null) {
            co = new Connector().postgresql("Safidimalala54", "yqs1NltKOUn5", "gasycar");
            nisokatra = true;
        }
        String sql = "select count(*) as isa from annonce where etat = "+etat+"";
        Statement state = co.createStatement();
        ResultSet res = state.executeQuery(sql);
        if (res.next()) {
            isa = res.getInt("isa");
        }
        if (nisokatra) {
            try {
                co.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isa;
    }

    public List<Annonce> getAllAnnonceParEtat(Connection co, Integer etat) throws Exception{
        List<Annonce> list = new ArrayList<>();
        boolean nisokatra = false;
        if (co == null) {
            co = new Connector().postgresql("Safidimalala54", "yqs1NltKOUn5", "gasycar");
            nisokatra = true;
        }
        String sql = "select * from annonce where etat="+etat+"";
        Statement state = co.createStatement();
        ResultSet res = state.executeQuery(sql);
        while (res.next()) {
            Annonce ano = new Annonce();
            ano.setId(res.getInt("id"));
            ano.setVoiture(res.getInt("id_voiture"));
            ano.setDescription(res.getString("descriptions"));
            ano.setPrix(res.getFloat("prix"));
            ano.setDate_annonce(res.getDate("date_annonce"));
            list.add(ano);
        }
        if (nisokatra) {
            try {
                co.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public Integer getIdLastVoiture(Connection co) throws Exception {
        Integer i = null;
        boolean nisokatra = false;
        if (co == null) {
            co = new Connector().postgresql("Safidimalala54", "yqs1NltKOUn5", "gasycar");
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
            co = new Connector().postgresql("Safidimalala54", "yqs1NltKOUn5", "gasycar");
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
            co = new Connector().postgresql("Safidimalala54", "yqs1NltKOUn5", "gasycar");
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
            co = new Connector().postgresql("Safidimalala54", "yqs1NltKOUn5", "gasycar");
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
