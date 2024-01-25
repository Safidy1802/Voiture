package com.voiture.gasicar.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.gasicar.Model.Marque;
import com.voiture.gasicar.Repository.MarqueRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MarqueService {

    @Autowired
    private MarqueRepository marqueRepository;

    public List<Marque> getAllMarques() {
        return marqueRepository.findAll();
    }

    public Optional<Marque> getMarqueById(Integer id) {
        return marqueRepository.findById(id);
    }

    public Marque createMarque(Marque marque) {
        return marqueRepository.save(marque);
    }

    public Marque updateMarque(Integer id, Marque updatedMarque) {
        if (marqueRepository.existsById(id)) {
            updatedMarque.setId(id);
            return marqueRepository.save(updatedMarque);
        } else {
            return null;
        }
    }

    public void deleteMarque(Integer id) {
        marqueRepository.deleteById(id);
    }
}
