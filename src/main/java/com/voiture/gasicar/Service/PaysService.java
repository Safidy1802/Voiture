package com.voiture.gasicar.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.gasicar.Model.Pays;
import com.voiture.gasicar.Repository.PaysRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaysService {

    @Autowired
    private PaysRepository paysRepository;

    public List<Pays> getAllPays() {
        return paysRepository.findAll();
    }

    public Optional<Pays> getPaysById(Integer id) {
        return paysRepository.findById(id);
    }

    public Pays createPays(Pays pays) {
        return paysRepository.save(pays);
    }

    public Pays updatePays(Integer id, Pays updatedPays) {
        if (paysRepository.existsById(id)) {
            updatedPays.setId(id);
            return paysRepository.save(updatedPays);
        } else {
            // Gérer le cas où le pays n'existe pas
            return null;
        }
    }

    public void deletePays(Integer id) {
        paysRepository.deleteById(id);
    }
}

