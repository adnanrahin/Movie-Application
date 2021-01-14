package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Address;
import com.spring.boot.movie.app.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/getAllAddress")
    public List<Address> getAllAddress() {
        return (List<Address>) addressService.findAll();
    }

    @PostMapping("/save")
    public void saveAddress(@RequestBody Address object) {
        addressService.save(object);
    }
}
