package revision.day37workshop.controller;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import revision.day37workshop.model.Photo;
import revision.day37workshop.service.PostService;

@Controller
@RequestMapping
public class PostController {
    

    @Autowired
    private PostService postSvc;

    // return html
    @GetMapping(path="/post/{postId}")
    public ModelAndView getPost(@PathVariable String postId) {
        Optional<Photo> opt = postSvc.getImageById(postId);

        Photo photo = opt.get();

        StringBuilder strB = new StringBuilder();
        strB.append("data:").append(photo.imageType()).append(";base64,");

        byte[] buffer = photo.content();
        String b64 = Base64.getEncoder().encodeToString(buffer);
        strB.append(b64);

        String imageData = strB.toString();

        System.out.printf("imageData: ", imageData);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("photo");
        mv.setStatus(HttpStatusCode.valueOf(200));
        mv.addObject("imageData", imageData);
        mv.addObject("postId", postId);

        return mv;
    }


    // return json
    @GetMapping(path="/post/image/{image}")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable String image) {
        
        Optional<Photo> opt = postSvc.getImageById(image);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Photo photo = opt.get();

        return ResponseEntity.status(200)
        .header("Content-Type", photo.imageType())
        .body(photo.content());
    }

    @PostMapping(path="/posts", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public ModelAndView postPost(@RequestPart String title, @RequestPart String content, @RequestPart MultipartFile image){
        
        ModelAndView mv = new ModelAndView();
        String postId = null;

        try {
            postId= postSvc.post(title, content, image);
        }catch(Exception ex){
            ex.printStackTrace();
            mv.setStatus(HttpStatusCode.valueOf(500));
            mv.addObject("error", ex.getMessage());
            mv.setViewName("error");
            return mv;
        }


        mv.setViewName("posts");
        mv.addObject("title", title);
        mv.addObject("content", content);
        mv.addObject("image", "/post/image/%s".formatted(postId));

        return mv;

    }
}
