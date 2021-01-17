package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Customer;
import com.spring.boot.movie.app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http//:localhost:4200")
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return ResponseEntity.ok((List<Customer>) customerService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer object) {
        System.out.println("Our Test Object");
        System.out.println(object);
        return ResponseEntity.ok(customerService.save(object));
    }

}
