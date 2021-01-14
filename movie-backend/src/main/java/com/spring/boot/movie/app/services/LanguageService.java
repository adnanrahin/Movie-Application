package com.spring.boot.movie.app.services;

import com.spring.boot.movie.app.model.Language;

import java.util.List;

public interface LanguageService {

    List<Language> findAll();

    Language findById(Long id);

    Language save(Language object);

    void delete(Language object);

    void deleteById(Long id);

}
