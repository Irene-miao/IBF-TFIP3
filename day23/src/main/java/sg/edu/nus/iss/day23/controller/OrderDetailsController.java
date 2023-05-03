package sg.edu.nus.iss.day23.controller;


import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.day23.model.OrderDetails;
import sg.edu.nus.iss.day23.repository.OrderDetailsRepository;

@RestController
@RequestMapping(path="/order/total", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderDetailsController {
   
    OrderDetailsRepository repository;

    OrderDetailsController(OrderDetailsRepository repository){
        this.repository = repository;
    }

    @GetMapping(path="{orderId}")
    public ResponseEntity<String> getOrderDetailsInfo(@PathVariable Integer orderId){

        OrderDetails orderDetails = repository.getOrderDetailsWithDiscount(orderId);

        if (orderDetails == null){
            JsonObject obj = Json.createObjectBuilder()
            .add("error: ", "order details not found")
            .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj.toString());
        }


        return ResponseEntity
        .status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(orderDetails.toJson().toString());  // pass json string
        
    }
   
}
