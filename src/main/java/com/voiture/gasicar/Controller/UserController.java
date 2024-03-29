package com.voiture.gasicar.Controller;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.gasicar.Model.User;
import com.voiture.gasicar.Security.JwtUtils;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/log")
public class UserController {
    @Autowired
    JwtUtils utils;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(HttpServletRequest request) {
        try {
            User user = new User();
            user.setNom(request.getParameter("nom"));
            user.setPrenom(request.getParameter("prenom"));
            user.setEmail(request.getParameter("email"));
            user.setRole("USER");
            user.setPassword(request.getParameter("password"));
            Integer i = user.getUserByMail(request.getParameter("email"), request.getParameter("password"));
            if (i == 0) {
                user.insert(null);
            } else {
                return ResponseEntity.badRequest().body("Cet email est déjà utilisé.");
            }
            System.out.println("ETOOOO");
            String token = utils.generateJwtToken(user);
            String responseJson = "{\"token\":\"" + token + "\"}";

            return ResponseEntity.ok(responseJson);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Une erreur s'est produite lors de l'inscription");
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/voir")
    public Vector<User> getAllUser() throws Exception{
        User u = new User();
        Vector<User> all = u.select(null);
        return all;
    }

    @PostMapping("/signin")
    public ResponseEntity<String> singin(@RequestParam("email") String email, @RequestParam("password") String password) throws Exception {
        User user = new User();
        user = user.login(email, password);
        if (user != null) {
            String token = utils.generateJwtToken(user);
            String responseJson = "{\"token\":\"" + token + "\"}";

            return ResponseEntity.ok(responseJson);
            //return token
        } else {
            return ResponseEntity.status(401).body("Authentification échouée : Verifier votre email et mot de passe");
        }
    }

}
