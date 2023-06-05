package revision.day38.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.S3ObjectSummary;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import revision.day38.repository.SpacesRepository;



@Controller
@RequestMapping
@CrossOrigin(origins="*")
public class UploadController {

	// HTTP POST FILE/IMAGE, INSERT FILE/IMAGE INTO AMAZON S3 BUCKET
	@Autowired
	private SpacesRepository spacesRepo;

	

	@PostMapping(path="/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ResponseEntity<String> postUpload(@RequestPart String title
			, @RequestPart MultipartFile myFile) {

		System.out.printf(">>> title: %s\n", title);
		System.out.printf(">>> filename: %s\n", myFile.getOriginalFilename());

		try {
			URL url = spacesRepo.upload(title, myFile);
			System.out.printf(">>>> URL: %s\n", url.toString());
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return ResponseEntity.ok("{}");
	}


	@GetMapping(path="/images")
	@ResponseBody
	public ResponseEntity<String> getImages() {
		List<String> list = new ArrayList<>();
		String json = null;
		try {
			
			list = spacesRepo.getKeys();
			System.out.println(list);
			JsonObjectBuilder obj = Json.createObjectBuilder();
			JsonArrayBuilder arr = Json.createArrayBuilder();
			for (String l : list) {
				arr.add(l);
			}
			json = obj.add("keys", arr).build().toString();
			

		}catch(Exception ex){
			ex.printStackTrace();
		}

		System.out.println(json);
		return ResponseEntity.ok(json);
	}

		
	@GetMapping(path="/images/{imageKey}")
	@ResponseBody
	public ResponseEntity<byte[]> getImage(@PathVariable String imageKey) throws IOException {
	
			
			return spacesRepo.getImage(imageKey);
		
	}

}
