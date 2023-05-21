package sg.edu.nus.iss.day35;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonReader;



@Controller
@RequestMapping(path="/api", produces=MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class RandomNumberController {
    

    private Random rand = new SecureRandom()



    @GetMapping(path="/random")
    @CrossOrigin(origins="*")
    @ResponseBody
    public ResponseEntity<String> getRandom(@RequestParam(defaultValue = '1')){

        List<Integer> nums = randSvc.getRandomNumbers(0, 1000, 10);
        JsonArrayBuilder  arrBuilder = Json.createArrayBuilder();

        

    }

    
    @PostMapping(path="/random", consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> postRandom(@RequestBody MultiValueMap<String,  String> form ){

       
    }

    



}
