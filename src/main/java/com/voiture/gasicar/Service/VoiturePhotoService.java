package com.voiture.gasicar.Service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.voiture.gasicar.Model.VoiturePhoto;
import com.voiture.gasicar.Repository.VoiturePhotoRepository;

@Service
public class VoiturePhotoService {
    @Autowired
    private VoiturePhotoRepository voiturePhotoRepository;

    public void saveVoiturePhoto(Integer idVoiture, MultipartFile file) throws IOException {
        VoiturePhoto voiturePhoto = new VoiturePhoto();
        voiturePhoto.setIdVoiture(idVoiture);
        voiturePhoto.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
        voiturePhotoRepository.save(voiturePhoto);
    }
}
