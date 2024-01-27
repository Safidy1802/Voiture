package com.voiture.gasicar.Controller;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.gasicar.Model.Annonce;
import com.voiture.gasicar.Model.User;
import com.voiture.gasicar.Model.Voiture;
import com.voiture.gasicar.Security.Authority;
import com.voiture.gasicar.Security.JwtUtils;
import com.voiture.gasicar.Security.MyContext;
import com.voiture.gasicar.Security.Role;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/annonce")
public class AnnonceController {
    @Autowired
    JwtUtils utils;

    @PostMapping("/insert")
    @Authority(role = Role.USER)
    public ResponseEntity<String> voitureannonce(HttpServletRequest request) {
        try {
            Voiture car = new Voiture();
            Annonce annonce = new Annonce();
            User user = MyContext.getUser();
            if (user != null) {
                car.setIduser(user.getId());
                car.setMarque(Integer.valueOf(request.getParameter("marque")));
                car.setCategorie(Integer.valueOf(request.getParameter("categorie")));
                car.setTransmission(Integer.valueOf(request.getParameter("transmission")));
                car.setCouleur(Integer.valueOf(request.getParameter("couleur")));
                car.setEnergie(Integer.valueOf(request.getParameter("energie")));
                car.setPays(Integer.valueOf(request.getParameter("pays")));
                car.setMatricule(request.getParameter("matricule"));
                car.setAnnee(Integer.valueOf(request.getParameter("annee")));
                car.setConso(Float.valueOf(request.getParameter("conso")));
                car.setReservoir(Float.valueOf(request.getParameter("reservoir")));
                car.setNbr_place(Integer.valueOf(request.getParameter("nbr_place")));
                car.setKilometrage(Float.valueOf(request.getParameter("kilometrage")));
                car.insert(null);
                System.out.println("Voiture enregistrer");
                Integer id_voiture = annonce.getIdLastVoiture(null);
                annonce.setVoiture(id_voiture);
                annonce.setPrix(Float.valueOf(request.getParameter("prix")));
                annonce.setDescription(request.getParameter("description"));
                annonce.setEtat(0);
                annonce.insert(null);
                return ResponseEntity.ok().body("Votre annonce est bien enregistrer!!");
            } else {
                return ResponseEntity.badRequest().body("Votre voiture ne peut pas etre enregistrer, Veuillez vous connecter.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Une erreur s'est produite");
        }
    }

    @PostMapping("/validation/{id}")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<String> validationAnnonce(@PathVariable Integer id){
        try {
            Annonce annonce = new Annonce();
            Integer etat = annonce.getEtatAnnonce(null, id);
            if (etat == 0) {
                annonce.validateAnnonce(null, id);
                return ResponseEntity.ok().body("Validation annonce ok!");
            } else {
                return ResponseEntity.badRequest().body("Annonce déjà valider");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Une erreur s'est produite");
        }
    }

    @PostMapping("/refus/{id}")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<String> refusAnnonce(@PathVariable Integer id){
        try {
            Annonce annonce = new Annonce();
            Integer etat = annonce.getEtatAnnonce(null, id);
            if (etat == 0) {
                annonce.refuserAnnonce(null, id);
                return ResponseEntity.ok().body("Refus annonce ok!");
            } else {
                return ResponseEntity.badRequest().body("Annonce déjà valider");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Une erreur s'est produite");
        }
    }

    @GetMapping("/annonceValider")
    @Authority(role = Role.USER)
    public List<Annonce> getAllValidated() throws Exception{
        Annonce annonce = new Annonce();
        Integer etat = 10;
        List<Annonce> listeV = annonce.getAllAnnonceParEtat(null, etat);
        return listeV;
    }

    @GetMapping("/annonceRefuser")
    @Authority(role = {Role.USER,Role.ADMIN})
    public Vector<Annonce> getAllRefused() throws Exception{
        Annonce annonce = new Annonce();
        annonce.setEtat(5);
        Vector<Annonce> refus = annonce.select(null);
        return refus;
    }



}
