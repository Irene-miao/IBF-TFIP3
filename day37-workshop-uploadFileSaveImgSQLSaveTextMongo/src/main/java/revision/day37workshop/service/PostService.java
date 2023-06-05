package revision.day37workshop.service;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import revision.day37workshop.model.Photo;
import revision.day37workshop.repository.ImageRepository;
import revision.day37workshop.repository.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepo;

    @Autowired
    private ImageRepository imageRepo;

    public Optional<Photo> getImageById(String imageId) {
        return imageRepo.getImage(imageId);
    }
 

    @Transactional(rollbackFor = IOException.class)
    public String post(String title, String content, MultipartFile image) throws IOException {

        String postId = UUID.randomUUID().toString().substring(0, 8);

        // MySQL will rollback if MongoDB operation throws an exeption
        imageRepo.saveImage(postId, image.getContentType(), image.getBytes());

        // MongoDB
        postRepo.insertPost(postId, title, content);

        System.out.println(postId);
        return postId;
    }
}
