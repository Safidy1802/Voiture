package com.voiture.gasicar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.gasicar.Model.Marque;

public interface MarqueRepository extends JpaRepository<Marque, Integer> {
    
}

