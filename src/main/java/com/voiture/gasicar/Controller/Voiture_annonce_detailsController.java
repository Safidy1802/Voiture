package com.voiture.gasicar.Controller;

import java.util.List;
import java.util.Vector;

import org.springframework.web.bind.annotation.*;

import com.voiture.gasicar.Model.User;
import com.voiture.gasicar.Model.Voiture_annonce_details;
import com.voiture.gasicar.Model.Voiture_annonce_favoris;
import com.voiture.gasicar.Security.Authority;
import com.voiture.gasicar.Security.MyContext;
import com.voiture.gasicar.Security.Role;

@RestController
@RequestMapping("/api/annonce_details")
public class Voiture_annonce_detailsController {
    
    @GetMapping("/voir")
    public Vector<Voiture_annonce_details> getAllVoitureAnnonce_details() throws Exception{
        Vector<Voiture_annonce_details> vad = new Voiture_annonce_details().select(null);
        return vad;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/valide")
    public Vector<Voiture_annonce_details> getAllVoitureAnnonceValider() throws Exception{
        Voiture_annonce_details vaa = new Voiture_annonce_details();
        vaa.setEtat(10);
        Vector<Voiture_annonce_details> vad = vaa.select(null);
        return vad;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/annonceNonValide")
    public Vector<Voiture_annonce_details> getAllVoitureAnnonceNonValider() throws Exception{
        Voiture_annonce_details vaa = new Voiture_annonce_details();
        vaa.setEtat(0);
        Vector<Voiture_annonce_details> vad = vaa.select(null);
        return vad;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/listefavoris")
    @Authority(role = Role.USER)
    public Vector<Voiture_annonce_favoris> getAllAnnonceFavorisUser() throws Exception {
        Voiture_annonce_favoris voiture = new Voiture_annonce_favoris();
        User user = MyContext.getUser();
        if (user != null) {
            voiture.setId_user(user.getId());
            Vector<Voiture_annonce_favoris> all = voiture.select(null);
            return all;
        } else {
            return null;
        }
    }
}
