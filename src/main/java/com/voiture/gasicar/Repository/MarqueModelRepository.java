package com.voiture.gasicar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.gasicar.Model.MarqueModel;

public interface MarqueModelRepository extends JpaRepository<MarqueModel, Integer> {
    
}
