package sg.edu.nus.iss.day27.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day27.exception.GameNotFoundException;
import sg.edu.nus.iss.day27.model.EditedComment;
import sg.edu.nus.iss.day27.model.Game;
import sg.edu.nus.iss.day27.model.Review;
import sg.edu.nus.iss.day27.repository.BoardGameRepository;

@Service
public class BoardGameService {
    
    @Autowired
    private BoardGameRepository bgRepo;

    public Game getBoardGameById(Integer gameId){
        return this.bgRepo.getBoardGameById(gameId);
    }


    public Review insertReview(Review r) throws GameNotFoundException{
       

        Game g = this.getBoardGameById(r.getGid());

        if (g == null){
            throw new GameNotFoundException("Game not found");
        }

        r.setName(g.getName());
        r.setPosted(LocalDateTime.now());
        return this.bgRepo.insertComment(r);
    }


    public long updateComment(EditedComment r){
        // check for any reviews
        Review result = this.bgRepo.getReviewById(r.getCid());
        List<EditedComment> ll = result.getEditedComment();
        System.out.println("r comment : " + r.getComment());
        System.out.println("result comment :" + result.getComment());
        // no reviews set new arraylist in review pojo
        if(result.getEditedComment() == null){
            ll = new ArrayList<>();
            result.setEditedComment(ll);
        }
        // save review's comment/rating/postedDate in editcomment
        // add the comment in review's list of comments
        EditedComment e = new EditedComment();
        e.setComment(result.getComment());
        e.setRating(result.getRating());
        e.setPosted(result.getPosted());
        result.getEditedComment().add(e);
        
        result.setComment(r.getComment());
        result.setRating(r.getRating());
        result.setPosted(LocalDateTime.now());
        return this.bgRepo.updateComment(result);
    }


    public Review getReviewById(String reviewId){
        return this.bgRepo.getReviewById(reviewId);
    }


}
