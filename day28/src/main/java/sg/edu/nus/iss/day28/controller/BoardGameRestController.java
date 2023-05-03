package sg.edu.nus.iss.day28.controller;

import java.util.List;
import java.util.Optional;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import sg.edu.nus.iss.day28.model.Game;
import sg.edu.nus.iss.day28.model.Review;
import sg.edu.nus.iss.day28.model.ReviewResult;
import sg.edu.nus.iss.day28.service.BoardGameService;


@RestController
@RequestMapping(path="/games")
public class BoardGameRestController {
    
    @Autowired
    private BoardGameService svc;

    // http://localhost:8080/games/3/reviews
    @GetMapping("{gameId}/reviews")
    public ResponseEntity getGameReviewsHistoricalDt(@PathVariable String gameId){
        JsonObject result =null;
        Optional<Game> r = this.svc.aggregrateGameReviews(gameId);
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("reviews", r.get().toJSON());
        result = builder.build();
      
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
    }


    // http://localhost:8080/games/highest?username=garyj&limit=5
    @GetMapping("/highest")
    public ResponseEntity<String> getHighestRatedGames(@RequestParam String username,
        @RequestParam Integer limit){
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(getResultFromRatedComment
                        (limit, username, "highest").toString());
    }

    // http://localhost:8080/games/lowest?username=garyj&limit=5
    @GetMapping("/lowest")
    public ResponseEntity<String> getLowestRatedGames(@RequestParam String username,
        @RequestParam Integer limit){
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(getResultFromRatedComment
                        (limit, username, "lowest").toString());
    }

    
    private JsonObject getResultFromRatedComment(Integer limit, String username, 
            String rating){
        JsonObject result = null;
        List<Review> rs= svc.aggregateMinMaxGameReviews(limit, username, rating);
        JsonObjectBuilder b = Json.createObjectBuilder();
        ReviewResult rr = new ReviewResult();
        rr.setRating(String.valueOf(rating));
        rr.setTimestamp(LocalDateTime.now().toString());
        rr.setGames(rs);
        b.add("result", rr.toJSON());
        result = b.build();
        return result;
    }

}
