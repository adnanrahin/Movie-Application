package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Customer;
import com.spring.boot.movie.app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllCustomer")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return ResponseEntity.ok((List<Customer>) customerService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer object) {
        return ResponseEntity.ok(customerService.save(object));
    }

}
