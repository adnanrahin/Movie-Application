package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.City;
import com.spring.boot.movie.app.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getAllCity")
    public ResponseEntity<List<City>> getAllCity() {
        return ResponseEntity.ok((List<City>) cityService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCity(@RequestBody City object) {
        return ResponseEntity.ok(cityService.save(object));
    }

}
