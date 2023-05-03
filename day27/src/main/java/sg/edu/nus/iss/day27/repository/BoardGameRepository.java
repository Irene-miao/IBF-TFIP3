package sg.edu.nus.iss.day27.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.UpdateResult;

import sg.edu.nus.iss.day27.model.Game;
import sg.edu.nus.iss.day27.model.Review;

@Repository
public class BoardGameRepository {
    
    @Autowired
    MongoTemplate mongoTemplate;



    public Game getBoardGameById(Integer gameId){
        Query query = new Query();
        query.addCriteria(Criteria.where("gid").is(gameId));

        return mongoTemplate.findOne(query, Game.class, "games");
    }


    public Review getReviewById(String reviewId){
        Query query = new Query();
        query.addCriteria(Criteria.where("cid").is(reviewId));

        return mongoTemplate.findOne(query, Review.class, "reviews");
    }



    public Review insertComment(Review r){
        Review review = mongoTemplate.insert(r, "reviews");
        System.out.println(review);
        return review;
    }


    public long updateComment(Review r){
        Query query = Query.query(Criteria.where("cid").is(r.getCid()));

        Update update = new Update()
        .set("ratings", r.getRating())
        .set("comment", r.getComment())
        .set("posted", r.getPosted())
        .set("edited", r.getEditedComment());

        UpdateResult result = mongoTemplate.updateMulti(query, update, Review.class, "reviews");
        return result.getModifiedCount();

    }
}
