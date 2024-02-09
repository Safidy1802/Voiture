package com.voiture.gasicar.Model;

import java.util.List;

import com.voiture.gasicar.Dao.Column;
import com.voiture.gasicar.Dao.DAO;
import com.voiture.gasicar.Dao.TableInfo;

@TableInfo(name = "voiture_photo", user = "Safidimalala54", pass = "yqs1NltKOUn5", database = "gasycar")
public class VoiturePhoto extends DAO{
    @Column(name = "id", isPrimary = true)
    private Integer id;

    @Column(name = "id_voiture")
    Integer idVoiture;
    @Column(name = "photo")
    String photo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(Integer idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    // Getters and setters
}
