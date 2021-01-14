package com.spring.boot.movie.app.services.implementaions;

import com.spring.boot.movie.app.model.Film;
import com.spring.boot.movie.app.repositories.FilmRepository;
import com.spring.boot.movie.app.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film findById(Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    @Override
    public Film save(Film object) {
        return filmRepository.save(object);
    }

    @Override
    public void delete(Film object) {
        filmRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        filmRepository.deleteById(id);
    }
}