package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Film;
import com.spring.boot.movie.app.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://loalhost:8080")
@RequestMapping("/api/film")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/getAllFilm")
    public ResponseEntity<List<Film>> getAllFilm() {
        return ResponseEntity.ok((List<Film>) filmService.findAll());
    }

    @PostMapping("/save")
    public void saveFilm(@RequestBody Film object) {
        filmService.save(object);
    }
}
