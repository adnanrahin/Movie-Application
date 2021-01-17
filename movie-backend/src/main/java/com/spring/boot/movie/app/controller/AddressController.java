package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Address;
import com.spring.boot.movie.app.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Address>> getAllAddress() {
        return ResponseEntity.ok((List<Address>) addressService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveAddress(@RequestBody Address object) {
        return ResponseEntity.ok(addressService.save(object));
    }
}
