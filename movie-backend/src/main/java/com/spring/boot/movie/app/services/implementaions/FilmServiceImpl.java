package com.spring.boot.movie.app.services.implementaions;

import com.spring.boot.movie.app.model.Film;
import com.spring.boot.movie.app.repositories.FilmRepository;
import com.spring.boot.movie.app.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FilmServiceImpl implements FilmService {

    private static final Logger logger = Logger.getLogger(FilmServiceImpl.class.getName());

    private final FilmRepository filmRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    @Cacheable("findAll")
    public List<Film> findAll() {
        try {
            List<Film> films = filmRepository.findAll();
            logger.info("Retrieved all films successfully.");
            return films;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding all films: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Film findById(Long id) {
        try {
            Film film = filmRepository.findById(id).orElse(null);
            if (film != null) {
                logger.info("Retrieved film by id " + id + " successfully.");
            } else {
                logger.warning("No film found for id " + id);
            }
            return film;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding film by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    @CacheEvict(value = "film", allEntries = true)
    public Film save(Film object) {
        try {
            Film savedFilm = filmRepository.save(object);
            logger.info("Saved film successfully: " + savedFilm);
            return savedFilm;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while saving film: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void delete(Film object) {
        try {
            filmRepository.delete(object);
            logger.info("Deleted film successfully: " + object);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting film: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            filmRepository.deleteById(id);
            logger.info("Deleted film by id successfully: " + id);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting film by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    @Cacheable("findByTitleContaining")
    public List<Film> findByTitleContaining(@RequestParam("title") String title) {
        try {
            List<Film> films = filmRepository.findByTitleContaining(title);
            logger.info("Retrieved films by title containing '" + title + "' successfully.");
            return films;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding films by title containing: " + title + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Film> findFilmByCategoryId(@Param("categoryId") Long categoryId) {
        try {
            List<Film> films = filmRepository.findFilmByCategoryId(categoryId);
            logger.info("Retrieved films by category id " + categoryId + " successfully.");
            return films;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding films by category id: " + categoryId + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Film> findFilmByActorId(@Param("actorId") Long actorId) {
        try {
            List<Film> films = filmRepository.findFilmByActorId(actorId);
            logger.info("Retrieved films by actor id " + actorId + " successfully.");
            return films;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding films by actor id: " + actorId + ". " + e.getMessage(), e);
            throw e;
        }
    }
}
