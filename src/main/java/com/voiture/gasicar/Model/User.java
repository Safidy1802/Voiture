package com.voiture.gasicar.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.voiture.gasicar.Dao.Column;
import com.voiture.gasicar.Dao.Connector;
import com.voiture.gasicar.Dao.DAO;
import com.voiture.gasicar.Dao.TableInfo;

@TableInfo(name = "users", user = "postgres", pass = "postgres", database = "gasycar")
public class User extends DAO {
    @Column(isPrimary = true, name = "id")
    String id;
    @Column(name = "nom")
    String nom;
    @Column(name = "prenom")
    String prenom;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;
    @Column(name = "role")
    String role;

    public Integer getUserByMail(String email, String password) throws Exception {
        Integer i = null;
        Connection co = null;
        boolean nisokatra = false;
        if (co == null) {
            co = new Connector().postgresql("postgres", "postgres", "gasycar");
            nisokatra = true;
        }
        String sql = "Select count(*) as isa from users where email = '" + email + "' and password = '" + password
                + "'";
        Statement state = co.createStatement();
        ResultSet res = state.executeQuery(sql);
        if (res.next()) {
            i = res.getInt("isa");
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

    public User login(String email, String mdp) throws Exception {
        User user = new User();
        Connection co = null;
        boolean nisokatra = false;
        if (co == null) {
            co = new Connector().postgresql("postgres", "postgres", "gasycar");
            nisokatra = true;
        }
        String sql = "Select * from users where email = '" + email + "' and password = '" + mdp + "'";
        Statement state = co.createStatement();
        ResultSet res = state.executeQuery(sql);
        if (res.next()) {
            user.setId(res.getString("id"));
            user.setNom(res.getString("nom"));
            user.setPrenom(res.getString("prenom"));
            user.setPassword(res.getString("password"));
            user.setEmail(res.getString("email"));
            user.setRole(res.getString("role"));
        }
        if (nisokatra) {
            co.close();
        }
        return user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
