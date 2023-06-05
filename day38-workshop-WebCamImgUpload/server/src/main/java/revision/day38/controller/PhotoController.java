package revision.day38.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping
public class PhotoController {
    
    @PostMapping(path="/upload", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ResponseEntity<String> getIndex(@RequestPart MultipartFile file, @RequestPart String comments) {
        System.out.printf("filename: ", file.getOriginalFilename());
        System.out.printf("comments; ", comments);
        
        return ResponseEntity.ok("{}");
    }
}
