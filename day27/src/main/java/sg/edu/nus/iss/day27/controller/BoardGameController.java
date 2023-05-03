package sg.edu.nus.iss.day27.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.day27.exception.GameNotFoundException;
import sg.edu.nus.iss.day27.model.EditedComment;
import sg.edu.nus.iss.day27.model.Review;
import sg.edu.nus.iss.day27.service.BoardGameService;

@RestController
@RequestMapping(path="/")
public class BoardGameController {


    @Autowired
    private BoardGameService bgSvc;
    

    // http://localhost:8080/review body: x-www-form-urlencoded {username, rating, comment, gid, cid}
    @PostMapping(path="/review", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> postReview(@ModelAttribute Review review) {
        System.out.println(review.toString());

        Review insertReview = null;

        try {
            insertReview = this.bgSvc.insertReview(review);
           
        } catch (GameNotFoundException e){
            
            return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .contentType(MediaType.APPLICATION_JSON)
            .body("");
            }
            
       
        return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(insertReview.toJson().toString());

    }

    // http://localhost:8080/review/3 
    @PutMapping(path="/review/{reviewId}")
    public ResponseEntity<Long> updateReview(@RequestBody EditedComment editedReview, @PathVariable String reviewId){

        editedReview.setCid(reviewId);
        long modifiedRecord = this.bgSvc.updateComment(editedReview);
        return ResponseEntity.ok(modifiedRecord);  // return number of documents modified
    }


    // http://localhost:8080/review/3 
    @GetMapping(path="/review/{reviewId}")
    public ResponseEntity<String> getReview (@PathVariable String reviewId){
        Review r = this.bgSvc.getReviewById(reviewId);
        return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(r.toJsonEdited().toString());
    }


    // http://localhost:8080/review/3/history
    @GetMapping(path="/review/{reviewId}/history")
    public ResponseEntity<String> getReviewHistory(@PathVariable String reviewId){
        Review r = this.bgSvc.getReviewById(reviewId);

        return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(r.toJsonEditedWithList().toString());
    }

    
}
