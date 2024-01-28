package com.voiture.gasicar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.voiture.gasicar.Model.Transmission;
import com.voiture.gasicar.Security.Authority;
import com.voiture.gasicar.Security.Role;
import com.voiture.gasicar.Service.TransmissionService;

import java.util.List;

@RestController
@RequestMapping("/api/transmission")
public class TransmissionController {

    @Autowired
    private TransmissionService transmissionService;

    @GetMapping("/voir")
    public List<Transmission> getAllTransmissions() {
        return transmissionService.getAllTransmissions();
    }

    @GetMapping("/voir/{id}")
    public ResponseEntity<Transmission> getTransmissionById(@PathVariable Integer id) {
        return transmissionService.getTransmissionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/insert")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Transmission> createTransmission(@RequestParam("nom") String transmission) {
        Transmission createdTransmission = new Transmission();
        createdTransmission.setNom(transmission);
        transmissionService.createTransmission(createdTransmission);
        return ResponseEntity.ok(createdTransmission);
    }

    @PutMapping("/{id}")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Transmission> updateTransmission(@PathVariable Integer id, @RequestBody Transmission updatedTransmission) {
        Transmission updated = transmissionService.updateTransmission(id, updatedTransmission);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<Void> deleteTransmission(@PathVariable Integer id) {
        transmissionService.deleteTransmission(id);
        return ResponseEntity.noContent().build();
    }
}

