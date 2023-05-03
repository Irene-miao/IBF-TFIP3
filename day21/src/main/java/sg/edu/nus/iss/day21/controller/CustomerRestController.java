package sg.edu.nus.iss.day21.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import sg.edu.nus.iss.day21.model.Customer;
import sg.edu.nus.iss.day21.model.Order;
import sg.edu.nus.iss.day21.repository.CustomerRespository;

@RestController
@RequestMapping(path="/api/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerRestController {
    
   
    CustomerRespository customerRespository;

    public CustomerRestController(CustomerRespository customerRespository){
        this.customerRespository = customerRespository;
    }


    // http://localhost:8080/api/customers?limit=5&offset=0
    @GetMapping()
    public ResponseEntity<String> getAllCustomers(@RequestParam (required = false)
     String limit, @RequestParam (required= false) String offset ){

        if(Objects.isNull(limit)) limit = "5";
        if(Objects.isNull(offset)) limit = "0";

        List<Customer> customers = customerRespository.getAllCustomers(Integer.parseInt(offset), Integer.parseInt(limit));

        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        
        for (Customer c: customers){
            arrayBuilder.add(c.toJson());
        }

        JsonArray result = arrayBuilder.build();
        
        return ResponseEntity
        .status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(result.toString());
    }
    

    // http://localhost:8080/api/customers/2
    @GetMapping(path="{customerId}")
    public ResponseEntity<String> getCustomerById(@PathVariable Integer customerId){

        JsonObject result = null;

    try { 
    
        Customer customer = customerRespository.findCustomerById(customerId);
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("customer", customer.toJson());

        result = objectBuilder.build();
 
    } catch (IndexOutOfBoundsException e){
        return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .contentType(MediaType.APPLICATION_JSON)
        .body("{\"error_msg\": \"record not found \"}");
    
    }
        
        return ResponseEntity
        .status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(result.toString());
    }



    // http://localhost:8080/api/customers/2/orders
    @GetMapping(path="{customer_id}/orders")
    public ResponseEntity<String> getOrdersForCustomer(@PathVariable Integer customer_id ){
        List<Order> orders = new ArrayList<Order>();

        JsonArray result = null;

        
            orders = customerRespository.getCustomerOrders(customer_id);

            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

            for (Order o : orders) {
                arrayBuilder.add(o.toJson());
    }


    result = arrayBuilder.build();
    if (result.size() == 0)
    return ResponseEntity
    .status(HttpStatus.NOT_FOUND)
    .contentType(MediaType.APPLICATION_JSON)
    .body("{\"error_msg\": \"record not found \"}");

    return ResponseEntity
    .status(HttpStatus.OK)
    .contentType(MediaType.APPLICATION_JSON)
    .body(result.toString());
    }

}
