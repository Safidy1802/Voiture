package com.voiture.gasicar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.gasicar.Model.Couleur;

public interface CouleurRepository extends JpaRepository<Couleur, Integer> {
    
}

