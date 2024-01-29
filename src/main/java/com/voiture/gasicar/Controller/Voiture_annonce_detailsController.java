package com.voiture.gasicar.Controller;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.voiture.gasicar.Model.Voiture_annonce_details;
import com.voiture.gasicar.Security.Authority;
import com.voiture.gasicar.Security.Role;
import com.voiture.gasicar.Service.Voiture_annonce_detailService;

@RestController
@RequestMapping("/api/annonce_details")
public class Voiture_annonce_detailsController {
    
    @Autowired
    private Voiture_annonce_detailService vaservice;

    @GetMapping("/voir")
    public Vector<Voiture_annonce_details> getAllVoitureAnnonce_details(){
        Vector<Voiture_annonce_details> vad = new Voiture_annonce_details().select(null);
        return vad;
    }
}
