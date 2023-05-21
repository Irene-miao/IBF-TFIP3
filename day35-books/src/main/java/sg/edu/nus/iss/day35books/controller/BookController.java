package sg.edu.nus.iss.day35books.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.day35books.repository.BookRepository;

@Controller
@CrossOrigin(origins ="*")
@RequestMapping(path="/api/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    
    @Autowired
    private BookRepository bookRepo;


     // GET /api/book/search?query=title
    @GetMapping(path="/search")
    @ResponseBody
    public ResponseEntity<String> search(@RequestParam String query) {
        
        List<JsonObject> books = bookRepo.findBooksByTitle(query)
        .stream()
        .map(bk -> Json.createObjectBuilder()
        .add("bookID", bk.bookID)
        .add("title", bk.title)
        .build()
        ).toList();

        JsonArray resp = Json.createArrayBuilder(books).build();
        
        return ResponseEntity.ok(resp.toString());
       
    }


}
