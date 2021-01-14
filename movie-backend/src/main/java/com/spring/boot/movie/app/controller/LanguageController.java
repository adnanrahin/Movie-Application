package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Language;
import com.spring.boot.movie.app.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/language")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getAllLanguage")
    public List<Language> getAllLanguage() {
        return (List<Language>) languageService.findAll();
    }

    @PostMapping("/save")
    public void saveLanguage( @RequestBody Language object) {
        languageService.save(object);
    }

}
