package com.voiture.gasicar.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.gasicar.Model.Categorie;
import com.voiture.gasicar.Repository.CategorieRepository;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository CategorieRepository;

    public List<Categorie> getAllCategories() {
        return CategorieRepository.findAll();
    }

    public Categorie getCategorieById(int id) {
        return CategorieRepository.findById(id).orElse(null);
    }

    public Categorie saveCategorie(Categorie Categorie) {
        return CategorieRepository.save(Categorie);
    }

    public void deleteCategorie(int id) {
        CategorieRepository.deleteById(id);
    }

    // Autres méthodes CRUD personnalisées si nécessaire
}
