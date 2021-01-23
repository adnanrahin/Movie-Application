package com.spring.boot.movie.app.services;

import com.spring.boot.movie.app.model.Film;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FilmService {

    List<Film> findAll();

    Film findById(Long id);

    Film save(Film object);

    void delete(Film object);

    void deleteById(Long id);

    List<Film> findByTitleContaining(@RequestParam("title") String title);

    List<Film> findFilmByCategories(@PathVariable String value);

}
