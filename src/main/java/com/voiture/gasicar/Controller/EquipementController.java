package com.voiture.gasicar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.gasicar.Model.Equipement;
import com.voiture.gasicar.Security.Authority;
import com.voiture.gasicar.Security.Role;
import com.voiture.gasicar.Service.EquipementService;

@RestController
@RequestMapping("api/equipement")
public class EquipementController {
    @Autowired
    private EquipementService EquipementService;

    @GetMapping("/voir")
    public List<Equipement> getAllEquipements() {
        return EquipementService.getAllEquipements();
    }

    @GetMapping("/voir/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Integer id) {
        return EquipementService.getEquipementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/insert")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Equipement> createEquipement(@RequestParam("nom") String Equipement) {
        Equipement createdEquipement = new Equipement();
        createdEquipement.setNom(Equipement);
        EquipementService.createEquipement(createdEquipement);
        return ResponseEntity.ok(createdEquipement);
    }

    @PutMapping("/{id}")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Equipement> updateEquipement(@PathVariable Integer id, @RequestBody Equipement updatedEquipement) {
        Equipement updated = EquipementService.updateEquipement(id, updatedEquipement);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Void> deleteEquipement(@PathVariable Integer id) {
        EquipementService.deleteEquipement(id);
        return ResponseEntity.noContent().build();
    }
}
