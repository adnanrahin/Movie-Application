package com.spring.boot.movie.app.repositories;

import com.spring.boot.movie.app.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
}
