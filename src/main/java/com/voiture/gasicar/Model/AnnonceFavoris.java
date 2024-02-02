package com.voiture.gasicar.Model;

import java.sql.Date;

import com.voiture.gasicar.Dao.Column;
import com.voiture.gasicar.Dao.DAO;
import com.voiture.gasicar.Dao.TableInfo;

@TableInfo(name = "users", user = "Safidimalala54", pass = "yqs1NltKOUn5", database = "gasycar")
public class AnnonceFavoris extends DAO{
    @Column(isPrimary = true, name = "id")
    Integer id;
    @Column(name = "id_user")
    String id_user;
    @Column(name = "id_annonce")
    Integer id_annonce;
    @Column(name = "date_ajout")
    Date date_ajout;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getId_user() {
        return id_user;
    }
    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
    public Integer getId_annonce() {
        return id_annonce;
    }
    public void setId_annonce(Integer id_annonce) {
        this.id_annonce = id_annonce;
    }
    public Date getDate_ajout() {
        return date_ajout;
    }
    public void setDate_ajout(Date date_ajout) {
        this.date_ajout = date_ajout;
    }
}
