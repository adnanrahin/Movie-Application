package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Language;
import com.spring.boot.movie.app.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(method = RequestMethod.GET, path = "/getAllLanguage")
    public ResponseEntity<List<Language>> getAllLanguage() {
        return ResponseEntity.ok((List<Language>) languageService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public ResponseEntity<?> saveLanguage(@RequestBody Language object) {
        return ResponseEntity.ok(languageService.save(object));
    }

}
