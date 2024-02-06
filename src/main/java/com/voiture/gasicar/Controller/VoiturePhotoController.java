package com.voiture.gasicar.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.voiture.gasicar.Service.VoiturePhotoService;

@RestController
@RequestMapping("/api/voiture-photos")
public class VoiturePhotoController {
    @Autowired
    private VoiturePhotoService voiturePhotoService;

    @PostMapping("/{idVoiture}")
    public ResponseEntity<?> uploadPhoto(@PathVariable Integer idVoiture, @RequestParam("file") MultipartFile file) {
        try {
            voiturePhotoService.saveVoiturePhoto(idVoiture, file);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload photo");
        }
    }

    @GetMapping("/voiture-photo/{idVoiture}")
    public ResponseEntity<String> getPhotoByIdVoiture(@PathVariable("idVoiture") Integer idVoiture) {
        String photoBase64 = voiturePhotoService.getPhotoByIdVoiture(idVoiture);
        if (photoBase64 != null) {
            return ResponseEntity.ok().body(photoBase64);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

