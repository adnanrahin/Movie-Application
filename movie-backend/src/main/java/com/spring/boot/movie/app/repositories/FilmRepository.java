package com.spring.boot.movie.app.repositories;

import com.spring.boot.movie.app.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByTitleContaining(@RequestParam("title") String title);

    @Query(value = "SELECT * FROM sakila.film, sakila.category, sakila.film_category\n" +
            "where sakila.film.film_id = sakila.film_category.film_id and sakila.category.category_id = sakila.film_category.category_id \n" +
            "and category.category_id = :categoryId", nativeQuery = true)
    List<Film> findFilmByCategoryId(@Param("categoryId") Long categoryId);

    @Query(
            value = "select film.*\n" +
                    "        from sakila.film\n" +
                    "        left join sakila.film_actor on (sakila.film.film_id = sakila.film_actor.film_id)\n" +
                    "        left join sakila.actor on (sakila.actor.actor_id = sakila.film_actor.actor_id)\n" +
                    "        where sakila.actor.actor_id = :actorId", nativeQuery = true)
    List<Film> findFilmByActorsId(@Param("actorId") Long actorId);

}
