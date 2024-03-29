package com.voiture.gasicar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.voiture.gasicar.Model.MarqueModel;
import com.voiture.gasicar.Security.Authority;
import com.voiture.gasicar.Security.Role;
import com.voiture.gasicar.Service.MarqueModelService;

import java.util.List;

@RestController
@RequestMapping("/api/marque-models")
public class MarqueModelController {

    @Autowired
    private MarqueModelService marqueModelService;

    @GetMapping("/voir")
    public List<MarqueModel> getAllMarqueModels() {
        return marqueModelService.getAllMarqueModels();
    }

    @GetMapping("/voir/{id}")
    public ResponseEntity<MarqueModel> getMarqueModelById(@PathVariable Integer id) {
        return marqueModelService.getMarqueModelById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<MarqueModel> createMarqueModel(@RequestParam("id_marque") Integer marque, @RequestParam("nom_model") String model) {
        MarqueModel createdMarqueModel = new MarqueModel();
        createdMarqueModel.setMarque(marque);
        createdMarqueModel.setNomModel(model);
        marqueModelService.createMarqueModel(createdMarqueModel);
        return ResponseEntity.ok(createdMarqueModel);
    }

    @PutMapping("/{id}")
    @Authority(role = Role.ADMIN)
    public ResponseEntity<MarqueModel> updateMarqueModel(@PathVariable Integer id, @RequestBody MarqueModel updatedMarqueModel) {
        MarqueModel updated = marqueModelService.updateMarqueModel(id, updatedMarqueModel);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    
}

