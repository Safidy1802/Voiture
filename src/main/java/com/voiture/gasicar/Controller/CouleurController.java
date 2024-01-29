package com.voiture.gasicar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.voiture.gasicar.Model.Couleur;
import com.voiture.gasicar.Security.Authority;
import com.voiture.gasicar.Security.Role;
import com.voiture.gasicar.Service.CouleurService;

import java.util.List;

@RestController
@RequestMapping("/api/couleurs")
public class CouleurController {

    @Autowired
    private CouleurService couleurService;

    @GetMapping("/voir")
    public List<Couleur> getAllCouleurs() {
        return couleurService.getAllCouleurs();
    }

    @GetMapping("/voir/{id}")
    public ResponseEntity<Couleur> getCouleurById(@PathVariable Integer id) {
        return couleurService.getCouleurById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "https://profound-cucurucho-3462bb.netlify.app")
    @PostMapping("/insert")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Couleur> createCouleur(@RequestParam("nom") String couleur) {
        Couleur createdCouleur = new Couleur();
        createdCouleur.setNom(couleur);
        couleurService.createCouleur(createdCouleur);
        return ResponseEntity.ok(createdCouleur);
    }

    @PutMapping("/{id}")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Couleur> updateCouleur(@PathVariable Integer id, @RequestBody Couleur updatedCouleur) {
        Couleur updated = couleurService.updateCouleur(id, updatedCouleur);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Void> deleteCouleur(@PathVariable Integer id) {
        couleurService.deleteCouleur(id);
        return ResponseEntity.noContent().build();
    }
}

