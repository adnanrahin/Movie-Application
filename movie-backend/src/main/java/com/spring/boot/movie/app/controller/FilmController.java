package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Film;
import com.spring.boot.movie.app.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @RequestMapping(method = RequestMethod.GET, path = "/findByTitle/{title}")
    public ResponseEntity<Page<Film>> findByTitle(@PathVariable String title, Pageable pageable) {
        return ResponseEntity.ok(filmService.findByTitleContaining(title, pageable));
    }

}
