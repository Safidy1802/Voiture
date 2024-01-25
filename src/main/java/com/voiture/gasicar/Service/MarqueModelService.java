package com.voiture.gasicar.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.gasicar.Model.MarqueModel;
import com.voiture.gasicar.Repository.MarqueModelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MarqueModelService {

    @Autowired
    private MarqueModelRepository marqueModelRepository;

    public List<MarqueModel> getAllMarqueModels() {
        return marqueModelRepository.findAll();
    }

    public Optional<MarqueModel> getMarqueModelById(Integer id) {
        return marqueModelRepository.findById(id);
    }

    public MarqueModel createMarqueModel(MarqueModel marqueModel) {
        return marqueModelRepository.save(marqueModel);
    }

    public MarqueModel updateMarqueModel(Integer id, MarqueModel updatedMarqueModel) {
        if (marqueModelRepository.existsById(id)) {
            updatedMarqueModel.setId(id);
            return marqueModelRepository.save(updatedMarqueModel);
        } else {
            return null;
        }
    }

    public void deleteMarqueModel(Integer id) {
        marqueModelRepository.deleteById(id);
    }
}

