package com.voiture.gasicar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voiture.gasicar.Model.Categorie;



@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Integer>{
    
}