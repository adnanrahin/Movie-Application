package com.spring.boot.movie.app.repositories;

import com.spring.boot.movie.app.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
}
