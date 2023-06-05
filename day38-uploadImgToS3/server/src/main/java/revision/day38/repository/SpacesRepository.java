package revision.day38.repository;

import java.util.Map;
import java.util.UUID;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@Repository
public class SpacesRepository {

   @Autowired
   private AmazonS3 s3;

   public URL upload(String title, MultipartFile file) throws IOException {

      // Add custom metadata
      Map<String, String> userData = new HashMap<>();
      userData.put("title", title);
      userData.put("filename", file.getOriginalFilename());
      userData.put("upload-date", (new Date()).toString());

      // Add object's metadata 
      ObjectMetadata metadata = new ObjectMetadata();
      metadata.setContentType(file.getContentType());
      metadata.setContentLength(file.getSize());
      metadata.setUserMetadata(userData);

      // Generate a random key name
      String key = "images/%s".formatted(UUID.randomUUID().toString().substring(0, 8));

      // acme - bucket name
      // key - key
      // file bytes
      // metadata
      PutObjectRequest putReq = new PutObjectRequest("revision-tfip", key, 
            file.getInputStream(), metadata);
      // Make the file publically accessible
      putReq = putReq.withCannedAcl(CannedAccessControlList.PublicRead);

      PutObjectResult result = s3.putObject(putReq);
      System.out.printf(">>> result: %s\n", result);

      return s3.getUrl("revision-tfip", key);
   }
   


   public List<String> getKeys(){
      List<String> list= new ArrayList<>();

      try {
         ObjectListing objectList = s3.listObjects("revision-tfip");
    for (S3ObjectSummary os : objectList.getObjectSummaries()) {
       list.add(os.getKey());
    }
    System.out.println(list);
      }catch(AmazonS3Exception ex) {
         ex.printStackTrace();
      }
    
    return list;
   }

   public ResponseEntity<byte[]> getImage(String imageKey) throws IOException {
      S3Object result = null;
      ObjectMetadata metadata = null;
      byte[] buffer = null;
      Map<String, String> userData = null;

      try{
         GetObjectRequest getReq = new GetObjectRequest("revision-tfip", "images"+"/"+imageKey);
          result = s3.getObject(getReq);
         metadata = result.getObjectMetadata();
        userData = metadata.getUserMetadata();
          
         try (S3ObjectInputStream is = result.getObjectContent()) {
            buffer = is.readAllBytes();
         }
      }catch(IOException ex) {
         ex.printStackTrace();
      }

      return ResponseEntity.status(HttpStatus.OK)
            .contentLength(metadata.getContentLength())
            .contentType(MediaType.parseMediaType(metadata.getContentType()))
            .header("X-name", userData.get("name"))
            .body(buffer);
   }
}