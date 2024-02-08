package com.voiture.gasicar.Controller;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.gasicar.Model.Annonce;
import com.voiture.gasicar.Model.AnnonceFavoris;
import com.voiture.gasicar.Model.User;
import com.voiture.gasicar.Model.Voiture;
import com.voiture.gasicar.Model.VoiturePhoto;
import com.voiture.gasicar.Model.Voiture_annonce_details;
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
            VoiturePhoto vp = new VoiturePhoto();
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
                annonce.setStatus(20);
                annonce.setEtat(0);
                annonce.insert(null);
                vp.setIdVoiture(id_voiture);
                vp.setPhoto(request.getParameter("image"));
                vp.insert(null);
                System.out.println("photo vitaaa");
                return ResponseEntity.ok().body("Votre annonce est bien enregistrer!!");
            } else {
                return ResponseEntity.badRequest()
                        .body("Votre voiture ne peut pas etre enregistrer, Veuillez vous connecter.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Une erreur s'est produite");
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/validation/{id}")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<String> validationAnnonce(@PathVariable Integer id) {
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

    @CrossOrigin(origins = "*")
    @PostMapping("/refus/{id}")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<String> refusAnnonce(@PathVariable Integer id) {
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

    @PostMapping("/favoris/{id}")
    @Authority(role = Role.USER)
    public ResponseEntity<String> ajoutFavoris(@PathVariable Integer id) {
        try {
            AnnonceFavoris favoris = new AnnonceFavoris();
            User user = MyContext.getUser();
            if (user != null) {
                favoris.setId_user(user.getId());
                favoris.setId_annonce(id);
                favoris.insert(null);
                return ResponseEntity.ok().body("Annonce ajouter dans votre liste de favoris");
            } else {
                return ResponseEntity.badRequest().body("Une erreur est survenu, veillez vous reconnecter");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Une erreur s'est produite");
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/status/{id}")
    @Authority(role = Role.USER)
    public ResponseEntity<String> statusannonce(@PathVariable Integer id) {
        try {
            Annonce annonce = new Annonce();
            annonce.modificationStatusVendu(null, id);
            return ResponseEntity.ok().body("Voiture vendu");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Une erreur s'est produit");
        }

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/annonceValider")
    public Vector<Annonce> getAllValidated() throws Exception {
        Voiture_annonce_details voiture = new Voiture_annonce_details();
        voiture.setEtat(10);
        Vector<Annonce> liste = voiture.select(null);
        return liste;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/annonceValider/{id_voiture}")
    public Vector<Voiture_annonce_details> getAllDetails(@PathVariable Integer id_voiture) throws Exception {
        Voiture_annonce_details voiture = new Voiture_annonce_details();
        voiture.setId_voiture(id_voiture);
        Vector<Voiture_annonce_details> liste = voiture.select(null);
        return liste;
    }

    @GetMapping("/annonceRefuser")
    @Authority(role = Role.ADMIN)
    public List<Annonce> getAllRefused() throws Exception {
        Annonce annonce = new Annonce();
        Integer etat = 5;
        List<Annonce> refus = annonce.getAllAnnonceParEtat(null, etat);
        return refus;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/listeannonce")
    @Authority(role = Role.USER)
    public Vector<Voiture_annonce_details> getAllAnnonceUser() throws Exception {
        Voiture_annonce_details voiture = new Voiture_annonce_details();
        User user = MyContext.getUser();
        if (user != null) {
            voiture.setId_user(user.getId());
            Vector<Voiture_annonce_details> all = voiture.select(null);
            return all;
        } else {
            return null;
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/listeannonce/{id_voiture}")
    @Authority(role = Role.USER)
    public Vector<Voiture_annonce_details> getAllAnnonceUserByIdVoiture(@PathVariable Integer id_voiture) throws Exception {
        Voiture_annonce_details voiture = new Voiture_annonce_details();
        User user = MyContext.getUser();
        if (user != null) {
            voiture.setId_voiture(id_voiture);
            Vector<Voiture_annonce_details> all = voiture.select(null);
            return all;
        } else {
            return null;
        }
    }

    @PostMapping("/insertPhoto")
    public ResponseEntity<String> insertPhotoVoiture(HttpServletRequest request){
        try {
            VoiturePhoto vp = new  VoiturePhoto();
            vp.setIdVoiture(2);
            vp.setPhoto(request.getParameter("image"));
            vp.insert(null);
            return ResponseEntity.ok().body("Voiture photo");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Une erreur s'est produit");
        }
        
    }

    @GetMapping("/recherche")
    public Vector<Voiture_annonce_details> getResultsRecherche(HttpServletRequest req) throws Exception {
        Voiture_annonce_details voiture = new Voiture_annonce_details();
        Vector<Voiture_annonce_details> result = voiture.annonceAvancer(null, req.getParameter("marque"),
                req.getParameter("model"), req.getParameter("categorie"), req.getParameter("transmission"),
                req.getParameter("couleur"), req.getParameter("energie"), req.getParameter("pays"),
                req.getParameter("annee"), req.getParameter("consommation"), req.getParameter("reservoir"),
                req.getParameter("place"), req.getParameter("kmmax"), req.getParameter("prixmax"),
                req.getParameter("date_annonce"));
                System.out.println("Atoo!");
                System.out.println(req.getParameter("marque"));
                return result;
    }

}
