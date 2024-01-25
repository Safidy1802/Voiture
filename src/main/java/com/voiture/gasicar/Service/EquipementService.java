package com.voiture.gasicar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.gasicar.Model.Equipement;
import com.voiture.gasicar.Repository.EquipementRepository;

@Service
public class EquipementService {
    @Autowired
    private EquipementRepository EquipementRepository;

    public List<Equipement> getAllEquipements() {
        return EquipementRepository.findAll();
    }

    public Optional<Equipement> getEquipementById(Integer id) {
        return EquipementRepository.findById(id);
    }

    public Equipement createEquipement(Equipement Equipement) {
        return EquipementRepository.save(Equipement);
    }

    public Equipement updateEquipement(Integer id, Equipement updatedEquipement) {
        if (EquipementRepository.existsById(id)) {
            updatedEquipement.setId(id);
            return EquipementRepository.save(updatedEquipement);
        } else {
            return null;
        }
    }

    public void deleteEquipement(Integer id) {
        EquipementRepository.deleteById(id);
    }
}
