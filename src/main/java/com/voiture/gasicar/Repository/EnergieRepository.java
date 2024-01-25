package com.voiture.gasicar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.gasicar.Model.Energie;

public interface EnergieRepository extends JpaRepository<Energie, Integer> {
    
}

