package com.voiture.gasicar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.gasicar.Model.Transmission;

public interface TransmissionRepository extends JpaRepository<Transmission, Integer> {
    
}
