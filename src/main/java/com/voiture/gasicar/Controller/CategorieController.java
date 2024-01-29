package com.voiture.gasicar.Controller;

import com.voiture.gasicar.Model.Categorie;
import com.voiture.gasicar.Security.Authority;
import com.voiture.gasicar.Security.Role;
import com.voiture.gasicar.Service.CategorieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/categorie")
public class CategorieController {

    
    @Autowired
    private CategorieService CategorieService;

    @GetMapping("/voir")
    @Authority(role = Role.ADMIN)
    public List<Categorie> getAllCategories() {
        return CategorieService.getAllCategories();
    }

    @GetMapping("/voir/{id}")
    public Categorie getCategorieById(@PathVariable int id) {
        return CategorieService.getCategorieById(id);
    }

    @CrossOrigin(origins = "https://profound-cucurucho-3462bb.netlify.app") //this is the origin
    @PostMapping("/insert")
    @Authority(role = Role.ADMIN)
    public Categorie saveCategorie(@RequestParam("nom_categorie") String nomCategorie) {
        Categorie categorie = new Categorie();
        categorie.setNom_categorie(nomCategorie);
        return CategorieService.saveCategorie(categorie);
    }

    @DeleteMapping("/delete/{id}")
    @Authority(role = Role.ADMIN)
    public void deleteCategorie(@PathVariable int id) {
        CategorieService.deleteCategorie(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire

}
