package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Country;
import com.spring.boot.movie.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/getAllCountry")
    public List<Country> getAllCountry() {
        return (List<Country>) countryService.findAll();
    }

    @PostMapping("/save")
    public void saveCountry(@RequestBody Country object) {
        countryService.save(object);
    }

}
