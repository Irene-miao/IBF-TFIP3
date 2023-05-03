package sg.edu.nus.iss.day22.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.day22.model.RSVP;
import sg.edu.nus.iss.day22.respository.RSVPRespository;

@RestController
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RSVPRestController {
    
    RSVPRespository respository;

    RSVPRestController(RSVPRespository respository){
        this.respository = respository;
    }

    //fetch all rsvps
    @GetMapping(path="/rsvps")
    public ResponseEntity<String> getAllRsvps() {
        List<RSVP> rsvps = respository.getAllRSVP();

        JsonArrayBuilder arrayBuilder =Json.createArrayBuilder();
        for (RSVP r : rsvps){
            arrayBuilder.add(r.toJson());
        }
        JsonArray result = arrayBuilder.build();

        return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(result.toString());
    }


    // fetch rsvp by name
    // http://localhost:8080/api/rsvp?name=Tom M
    @GetMapping(path="/rsvp")
    public ResponseEntity<String> getRSVPByName(@RequestParam String name){
        
        List<RSVP> rsvp = respository.getRSVPByName(name);

        JsonArrayBuilder arrayBuilder =Json.createArrayBuilder();
        for (RSVP r : rsvp){
            arrayBuilder.add(r.toJson());
        }
        JsonArray result = arrayBuilder.build();

        // return error message if rsvp is empty
        if (rsvp.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .contentType(MediaType.APPLICATION_JSON)
        .body("{'error_code' : " + HttpStatus.NOT_FOUND + " '}");


        return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(result.toString());
    }

        // update existing rsvp or create new one
        @PostMapping(path="/rsvp")
        public ResponseEntity<String> insertUpdateRSVP(@RequestBody String json){
           
            RSVP rsvp = null;
            JsonObject jsonObject = null;
            try {
                rsvp = RSVP.create(json); //convert json to POJO
            }catch (Exception e){
                e.printStackTrace();
                jsonObject = Json.createObjectBuilder().add("error", e.getMessage()).build();
                return ResponseEntity.badRequest().body(jsonObject.toString());
            }
           
            RSVP result = respository.createRsvp(rsvp);

             jsonObject = Json.createObjectBuilder()
            .add("rsvpID", result.getId())
            .build();

            return ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(jsonObject.toString());

        }

        // get rsvp by email
        @PutMapping(path="/rsvp", consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> putRSVPByEmail (@RequestBody String json){
          RSVP rsvp = null;
          boolean rsvpResult = false;
          JsonObject resp;

          try {
            rsvp = RSVP.create(json);
          }catch (Exception e){
            e.printStackTrace();
            resp = Json.createObjectBuilder()
            .add("error: ", e.getMessage())
            .build();
            return ResponseEntity.badRequest().body(resp.toString());
          }

          rsvpResult = respository.updateRSVP(rsvp);
          resp = Json.createObjectBuilder()
          .add("updated", rsvpResult)
          .build();

          return ResponseEntity
          .status(HttpStatus.OK)
          .contentType(MediaType.APPLICATION_JSON)
          .body(resp.toString());
        }

        @GetMapping(path="/rsvp/count")
        public ResponseEntity<String> getTotalRSVPCounts(){
            JsonObject resp;
            Long total_rsvps = respository.getTotalRSVPCount();

            resp = Json.createObjectBuilder()
            .add("total_count", total_rsvps)
            .build();

            return ResponseEntity
            .status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(resp.toString());
        }
} 
