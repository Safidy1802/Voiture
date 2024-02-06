package com.voiture.gasicar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.gasicar.Model.VoiturePhoto;

public interface VoiturePhotoRepository extends JpaRepository<VoiturePhoto, Integer>{
    
}
