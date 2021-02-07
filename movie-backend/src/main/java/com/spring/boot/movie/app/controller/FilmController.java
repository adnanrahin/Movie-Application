package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Film;
import com.spring.boot.movie.app.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(method = RequestMethod.GET, path = "/category/{value}")
    public ResponseEntity<List<Film>> findFilmByCategoryId(@PathVariable Long value) {
        return ResponseEntity.ok(filmService.findFilmByCategoryId(value));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/movieDetails/{id}")
    public ResponseEntity<?> getFilmById(@PathVariable Long id) {
        Film film = filmService.findById(id);
        return film != null ?
                new ResponseEntity<>(film, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllFilmByActor/{id}")
    public ResponseEntity<List<Film>> getFilmByActorId(@PathVariable Long id) {
        List<Film> films = filmService.findFilmByActorId(id);
        return films != null ? new ResponseEntity<>(films, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
