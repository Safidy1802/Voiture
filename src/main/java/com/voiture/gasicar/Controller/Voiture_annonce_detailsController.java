package com.voiture.gasicar.Controller;

import java.util.List;

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
    public List<Voiture_annonce_details> getAllVoitureAnnonce_details(){
        return vaservice.getAllAnnonce_details();
    }
}
