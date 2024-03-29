package com.voiture.gasicar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.voiture.gasicar.Model.Energie;
import com.voiture.gasicar.Security.Authority;
import com.voiture.gasicar.Security.Role;
import com.voiture.gasicar.Service.EnergieService;

import java.util.List;

@RestController
@RequestMapping("/api/energies")
public class EnergieController {

    @Autowired
    private EnergieService energieService;

    @GetMapping("/voir")
    public List<Energie> getAllEnergies() {
        return energieService.getAllEnergies();
    }

    @GetMapping("/voir/{id}")
    public ResponseEntity<Energie> getEnergieById(@PathVariable Integer id) {
        return energieService.getEnergieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Energie> createEnergie(@RequestParam("nom") String energie) {
        Energie createdEnergie = new Energie();
        createdEnergie.setNom(energie);
        energieService.createEnergie(createdEnergie);
        return ResponseEntity.ok(createdEnergie);
    }

    @PutMapping("/{id}")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Energie> updateEnergie(@PathVariable Integer id, @RequestBody Energie updatedEnergie) {
        Energie updated = energieService.updateEnergie(id, updatedEnergie);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

}

