package com.voiture.gasicar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.gasicar.Model.Equipement;

public interface EquipementRepository extends JpaRepository<Equipement, Integer>{
    
}
