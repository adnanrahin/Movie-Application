package com.spring.boot.movie.app.services;

import com.spring.boot.movie.app.model.Film;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FilmService {

    List<Film> findAll();

    Film findById(Long id);

    Film save(Film object);

    void delete(Film object);

    void deleteById(Long id);

    List<Film> findByTitleContaining(@RequestParam("title") String title);

    List<Film> findFilmByCategoryId(@Param("categoryId") Long categoryId);

    List<Film> findFilmByActorName(@Param("actorId") Long actorId);
}
