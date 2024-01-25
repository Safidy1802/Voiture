package com.voiture.gasicar.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.gasicar.Model.Energie;
import com.voiture.gasicar.Repository.EnergieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnergieService {

    @Autowired
    private EnergieRepository energieRepository;

    public List<Energie> getAllEnergies() {
        return energieRepository.findAll();
    }

    public Optional<Energie> getEnergieById(Integer id) {
        return energieRepository.findById(id);
    }

    public Energie createEnergie(Energie energie) {
        return energieRepository.save(energie);
    }

    public Energie updateEnergie(Integer id, Energie updatedEnergie) {
        if (energieRepository.existsById(id)) {
            updatedEnergie.setId(id);
            return energieRepository.save(updatedEnergie);
        } else {
            // Gérer le cas où l'énergie n'existe pas
            return null;
        }
    }

    public void deleteEnergie(Integer id) {
        energieRepository.deleteById(id);
    }
}

