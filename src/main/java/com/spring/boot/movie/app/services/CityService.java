package com.spring.boot.movie.app.services;

import com.spring.boot.movie.app.model.Address;
import com.spring.boot.movie.app.model.City;

import java.util.List;

public interface CityService {

    List<City> findAll();

    City findById(Long id);

    City save(City object);

    void delete(City object);

    void deleteById(Long id);

}
