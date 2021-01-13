package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Film;
import com.spring.boot.movie.app.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http//:localhost:4200")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public List<Film> getListOfFilm(){
        return (List<Film>) filmService.findAll();
    }

}
