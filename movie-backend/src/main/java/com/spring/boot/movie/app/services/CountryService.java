package com.spring.boot.movie.app.services;

import com.spring.boot.movie.app.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll();

    Country findById(Long id);

    Country save(Country object);

    void delete(Country object);

    void deleteById(Long id);
}
