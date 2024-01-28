package com.voiture.gasicar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.voiture.gasicar.Model.Pays;
import com.voiture.gasicar.Security.Authority;
import com.voiture.gasicar.Security.Role;
import com.voiture.gasicar.Service.PaysService;

import java.util.List;

@RestController
@RequestMapping("/api/pays")
public class PaysController {

    @Autowired
    private PaysService paysService;

    @GetMapping("/voir")
    public List<Pays> getAllPays() {
        return paysService.getAllPays();
    }

    @GetMapping("/voir/{id}")
    public ResponseEntity<Pays> getPaysById(@PathVariable Integer id) {
        return paysService.getPaysById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/insert")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Pays> createPays(@RequestParam("nom") String pays) {
        Pays createdPays = new Pays();
        createdPays.setNom(pays);
        paysService.createPays(createdPays);
        return ResponseEntity.ok(createdPays);
    }

    @PutMapping("/{id}")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Pays> updatePays(@PathVariable Integer id, @RequestBody Pays updatedPays) {
        Pays updated = paysService.updatePays(id, updatedPays);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Void> deletePays(@PathVariable Integer id) {
        paysService.deletePays(id);
        return ResponseEntity.noContent().build();
    }
}

