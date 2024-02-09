package com.voiture.gasicar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.voiture.gasicar.Model.Marque;
import com.voiture.gasicar.Security.Authority;
import com.voiture.gasicar.Security.Role;
import com.voiture.gasicar.Service.MarqueService;

import java.util.List;

@RestController
@RequestMapping("/api/marques")
public class MarqueController {

    @Autowired
    private MarqueService marqueService;

    @GetMapping("/voir")
    public List<Marque> getAllMarques() {
        return marqueService.getAllMarques();
    }

    @GetMapping("/voir/{id}")
    public ResponseEntity<Marque> getMarqueById(@PathVariable Integer id) {
        return marqueService.getMarqueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Marque> createMarque(@RequestParam("nom") String marque) {
        Marque createdMarque = new Marque();
        createdMarque.setNom(marque);
        marqueService.createMarque(createdMarque);
        return ResponseEntity.ok(createdMarque);
    }

    @PutMapping("/{id}")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Marque> updateMarque(@PathVariable Integer id, @RequestBody Marque updatedMarque) {
        Marque updated = marqueService.updateMarque(id, updatedMarque);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

}

