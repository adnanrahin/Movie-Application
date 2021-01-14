package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Customer;
import com.spring.boot.movie.app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerService.findAll();
    }

    @PostMapping("/save")
    public void saveCustomer(@RequestBody Customer object) {
        customerService.save(object);
    }

}
