package com.voiture.gasicar.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.UUID;

@Service
public class VoiturePhotoService {

  private String uploadFile(File file, String fileName) throws IOException {
      BlobId blobId = BlobId.of("car-vente.appspot.com", fileName);
      BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
      InputStream inputStream = VoiturePhotoService.class.getClassLoader().getResourceAsStream("car-vente-firebase.json"); // change the file name with your one
      Credentials credentials = GoogleCredentials.fromStream(inputStream);
      Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
      storage.create(blobInfo, Files.readAllBytes(file.toPath()));

      String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/car-vente.appspot.com/o/%s?alt=media";
      return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName, StandardCharsets.UTF_8));
  }

  private String getExtension(String fileName) {
      return fileName.substring(fileName.lastIndexOf("."));
  }

  public String upload(Photo photo) throws Exception{            
        String filename = UUID.randomUUID().toString().concat(this.getExtension(photo.getFilename()));
        File file= photo.convertToFile();                  
        String URL = this.uploadFile(file, filename);                                   
        file.delete();
        return URL;
  }

  public String upload(String photos) throws Exception{
        String ima = null;
        System.out.println(photos);
        Photo photo = new Photo(photos,"image.jpg");
        photo.convertToFile();
        ima = this.upload(photo);
        return ima;
  }

}
