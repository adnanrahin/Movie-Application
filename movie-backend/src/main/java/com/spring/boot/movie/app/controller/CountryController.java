package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Country;
import com.spring.boot.movie.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllCountry")
    public ResponseEntity<List<Country>> getAllCountry() {
        return ResponseEntity.ok((List<Country>) countryService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public ResponseEntity<?> saveCountry(@RequestBody Country object) {
        return ResponseEntity.ok(countryService.save(object));
    }

}
