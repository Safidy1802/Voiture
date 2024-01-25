package com.voiture.gasicar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.gasicar.Model.Pays;

public interface PaysRepository extends JpaRepository<Pays, Integer> {
    
}

