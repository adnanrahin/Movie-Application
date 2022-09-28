package com.spring.boot.movie.app.services.implementaions;

import com.spring.boot.movie.app.model.Film;
import com.spring.boot.movie.app.model.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FilmServiceImplTest {


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAll() {

        Film film = new Film();
        film.setFilmId(1L);
        film.setDescription("This is our film.");
        film.setLanguage(new Language());
        film.setActors(new HashSet<>());
        film.setLastUpdate(new Timestamp(56266L));
        film.setOriginalLanguageId(1L);
        film.setTitle("Leader Ashche");

        List<Film> filmList = Collections.singletonList(film);

        FilmServiceImpl filmService = mock(FilmServiceImpl.class);
        when(filmService.findAll()).thenReturn(filmList);

        assertEquals(filmList, filmService.findAll());

    }

    @Test
    void findById() {

        Film film = new Film();
        film.setFilmId(1L);
        film.setDescription("This is our film.");
        film.setLanguage(new Language());
        film.setActors(new HashSet<>());
        film.setLastUpdate(new Timestamp(56266L));
        film.setOriginalLanguageId(1L);
        film.setTitle("Leader Ashche");

        FilmServiceImpl filmService = mock(FilmServiceImpl.class);
        when(filmService.findById(1L)).thenReturn(film);

        assertEquals(film, filmService.findById(1L));

    }

}