package com.voiture.gasicar.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.gasicar.Model.Transmission;
import com.voiture.gasicar.Repository.TransmissionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransmissionService {

    @Autowired
    private TransmissionRepository transmissionRepository;

    public List<Transmission> getAllTransmissions() {
        return transmissionRepository.findAll();
    }

    public Optional<Transmission> getTransmissionById(Integer id) {
        return transmissionRepository.findById(id);
    }

    public Transmission createTransmission(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }

    public Transmission updateTransmission(Integer id, Transmission updatedTransmission) {
        if (transmissionRepository.existsById(id)) {
            updatedTransmission.setId(id);
            return transmissionRepository.save(updatedTransmission);
        } else {
            // Gérer le cas où la transmission n'existe pas
            return null;
        }
    }

    public void deleteTransmission(Integer id) {
        transmissionRepository.deleteById(id);
    }
}

