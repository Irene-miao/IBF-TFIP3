package sg.edu.nus.iss.boardgames.controller;

import java.time.LocalDate;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import sg.edu.nus.iss.boardgames.model.Game;
import sg.edu.nus.iss.boardgames.model.Games;
import sg.edu.nus.iss.boardgames.repository.BoardGamesRepository;

@RestController
public class BoardGamesController {
    
    BoardGamesRepository boardgamesRepo;

    BoardGamesController(BoardGamesRepository boardgamesRepo){
        this.boardgamesRepo = boardgamesRepo;
    }

    // http://localhost:8080/games?limit=5&offset=0
    @GetMapping(path="/games")
    public ResponseEntity<String> getAllBoardGames(@RequestParam Integer limit, @RequestParam Integer offset){

        List<Game>listGames = boardgamesRepo.getAllGames(limit, offset);
        // create POJO
        Games games = new Games();
        games.setGameList(listGames);
        games.setOffset(offset);
        games.setLimit(limit);
        games.setTotal(listGames.size());
        games.setTimeStamp(LocalDate.now());

        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("boardgames", games.toJson());
        JsonObject result = null;
         result = objectBuilder.build();
        

         return ResponseEntity
         .status(HttpStatus.OK)
         .contentType(MediaType.APPLICATION_JSON)
         .body(result.toString());
    }


    // http://localhost:8080/games/rank?limit=5&offset=0
    @GetMapping(path = "/games/rank")
    public ResponseEntity<String> getSortedBooardGames(@RequestParam Integer limit, @RequestParam Integer offset) {
        
        List<Game> listGames = boardgamesRepo.getSortedBoardGames(limit, offset);
        // create POJO
        Games games = new Games();
        games.setGameList(listGames);
        games.setOffset(offset);
        games.setLimit(limit);
        games.setTotal(listGames.size());
        games.setTimeStamp(LocalDate.now());
        
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();

        objectBuilder.add("boardgames", games.toJson());
        JsonObject result = null;
        result = objectBuilder.build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
    }



    // http://localhost:8080/games/20
    // get Boardgames by gameId
    @GetMapping(path="/games/{gameId}")
    public ResponseEntity<String> getBoardGameById(@PathVariable Integer gameId) {
        
        Game game = boardgamesRepo.getBoardGameById(gameId);

        if (null == game) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Json.createObjectBuilder()
            .add("error", "Game not found")
            .build().toString());
        }

        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("game", game.toJson());

        JsonObject result = objectBuilder.build();


        return ResponseEntity
        .status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(result.toString());
    }

    

}
