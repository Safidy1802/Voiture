package com.voiture.gasicar.Dao;

import java.sql.Date;

@TableInfo(user = "postgres",pass = "root",database = "test")
public class Personne extends DAO{
    @Column(name = "id",isPrimary = true)
    Integer id;
    @Column(name = "nom")
    String name;
    @Column(name = "birth")
    Date birth;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirth() {
        return birth;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    
}
