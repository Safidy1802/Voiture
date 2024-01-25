package com.voiture.gasicar.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.gasicar.Model.Couleur;
import com.voiture.gasicar.Repository.CouleurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CouleurService {

    @Autowired
    private CouleurRepository couleurRepository;

    public List<Couleur> getAllCouleurs() {
        return couleurRepository.findAll();
    }

    public Optional<Couleur> getCouleurById(Integer id) {
        return couleurRepository.findById(id);
    }

    public Couleur createCouleur(Couleur couleur) {
        return couleurRepository.save(couleur);
    }

    public Couleur updateCouleur(Integer id, Couleur updatedCouleur) {
        if (couleurRepository.existsById(id)) {
            updatedCouleur.setId(id);
            return couleurRepository.save(updatedCouleur);
        } else {
            return null;
        }
    }

    public void deleteCouleur(Integer id) {
        couleurRepository.deleteById(id);
    }
}

