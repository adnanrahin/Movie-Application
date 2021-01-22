package com.spring.boot.movie.app.repositories;

import com.spring.boot.movie.app.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByTitleContaining(@RequestParam("title") String title);
    Page<Film> findByTitleContaining(@RequestParam("title") String title, Pageable page);
}
