package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Film;
import com.spring.boot.movie.app.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://loalhost:4200")
@RequestMapping("/api/film")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllFilm")
    public ResponseEntity<List<Film>> getAllFilm() {
        return ResponseEntity.ok((List<Film>) filmService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public ResponseEntity<?> saveFilm(@RequestBody Film object) {
        return ResponseEntity.ok(filmService.save(object));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/search/{title}")
    public ResponseEntity<List<Film>> findByTitle(@PathVariable String title) {
        return ResponseEntity.ok(filmService.findByTitleContaining(title));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/findFilmByCategories/{value}")
    public ResponseEntity<List<Film>> findFilmByCategoryId(@PathVariable Long value) {
        return ResponseEntity.ok(filmService.findFilmByCategoryId(value));
    }

}
