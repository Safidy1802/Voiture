package com.voiture.gasicar.Service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.voiture.gasicar.Model.VoiturePhoto;
import com.voiture.gasicar.Repository.VoiturePhotoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
@Transactional
public class VoiturePhotoService {
    @Autowired
    private VoiturePhotoRepository voiturePhotoRepository;

    public void saveVoiturePhoto(Integer idVoiture, MultipartFile file) throws IOException {
        VoiturePhoto voiturePhoto = new VoiturePhoto();
        voiturePhoto.setIdVoiture(idVoiture);
        voiturePhoto.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
        voiturePhotoRepository.save(voiturePhoto);
    }

    @PersistenceContext
    private EntityManager entityManager;

    public String getPhotoByIdVoiture(Integer idVoiture) {
        Query query = entityManager.createQuery("SELECT vp.photo FROM VoiturePhoto vp WHERE vp.idVoiture = :idVoiture");
        query.setParameter("idVoiture", idVoiture);
        try {
            return (String) query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Return null if no photo found for the given voiture ID
        }
    }
}
