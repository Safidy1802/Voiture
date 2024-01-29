package com.voiture.gasicar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voiture.gasicar.Model.Voiture_annonce_details;

@Repository
public interface Voiture_annonce_detailRepository extends JpaRepository<Voiture_annonce_details, Integer>{
    
}
