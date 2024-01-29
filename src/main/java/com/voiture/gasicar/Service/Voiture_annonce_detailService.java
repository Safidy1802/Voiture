package com.voiture.gasicar.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.gasicar.Model.Voiture_annonce_details;
import com.voiture.gasicar.Repository.Voiture_annonce_detailRepository;

@Service
public class Voiture_annonce_detailService {
    @Autowired
    private Voiture_annonce_detailRepository voitureAnnonceDetailRepository;

    public List<Voiture_annonce_details> getAllAnnonce_details() {
        return voitureAnnonceDetailRepository.findAll();
    }
}
