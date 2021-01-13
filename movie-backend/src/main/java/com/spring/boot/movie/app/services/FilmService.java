package com.spring.boot.movie.app.services;

import com.spring.boot.movie.app.model.Film;

import java.util.List;

public interface FilmService {

    List<Film> findAll();

    Film findById(Long id);

    Film save(Film object);

    void delete(Film object);

    void deleteById(Long id);

}
