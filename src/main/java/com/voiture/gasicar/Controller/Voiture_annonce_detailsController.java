package com.voiture.gasicar.Controller;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.voiture.gasicar.Model.Voiture_annonce_details;
import com.voiture.gasicar.Security.Authority;
import com.voiture.gasicar.Security.Role;

@RestController
@RequestMapping("/api/annonce_details")
public class Voiture_annonce_detailsController {
    
    @GetMapping("/voir")
    public Vector<Voiture_annonce_details> getAllVoitureAnnonce_details() throws Exception{
        Vector<Voiture_annonce_details> vad = new Voiture_annonce_details().select(null);
        return vad;
    }

    @GetMapping("/valide")
    public Vector<Voiture_annonce_details> getAllVoitureAnnonceValider() throws Exception{
        Voiture_annonce_details vaa = new Voiture_annonce_details();
        vaa.setEtat(10);
        Vector<Voiture_annonce_details> vad = vaa.select(null);
        return vad;
    }
}
