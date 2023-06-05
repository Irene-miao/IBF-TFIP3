package revision.day37.controller;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import revision.day37.model.Photo;
import revision.day37.service.PhotoService;


@Controller
@RequestMapping
public class UploadController {
    
    @Autowired
    private PhotoService photoSvc;

        
        @PostMapping(path="/upload", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
        public String postUpload(@RequestPart String title, @RequestPart MultipartFile mypic, Model model){

            boolean result = photoSvc.upload(title, mypic);
            model.addAttribute("filename", mypic.getOriginalFilename());
            model.addAttribute("size", mypic.getSize());
            model.addAttribute("contentType", mypic.getContentType());
           //model.addAttribute("uploaded", m_id);

            return "upload";


        }
        

       
    
    
}
