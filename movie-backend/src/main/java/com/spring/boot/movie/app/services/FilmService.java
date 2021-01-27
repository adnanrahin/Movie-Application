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

    /*
        select sakila.film.title, sakila.film.description, sakila.film.release_year
        from sakila.film_actor, sakila.film, sakila.actor
        where sakila.film_actor.actor_id = sakila.actor.actor_id and
        sakila.film_actor.film_id = sakila.film.film_id and sakila.actor.actor_id = 2*/
    /*select * from sakila.film
left join sakila.actor
on  sakila.actor.actor_id = 2*/

    List<Film> findFilmByActorName();
}
