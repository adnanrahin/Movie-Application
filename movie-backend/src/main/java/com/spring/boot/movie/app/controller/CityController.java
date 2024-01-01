package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.City;
import com.spring.boot.movie.app.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllCity")
    public ResponseEntity<List<City>> getAllCity() {
        return ResponseEntity.ok((List<City>) cityService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public ResponseEntity<?> saveCity(@RequestBody City object) {
        return ResponseEntity.ok(cityService.save(object));
    }

}
