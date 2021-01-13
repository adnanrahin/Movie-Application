package com.spring.boot.movie.app.services.implementaions;

import com.spring.boot.movie.app.model.Country;
import com.spring.boot.movie.app.repositories.CountryRepository;
import com.spring.boot.movie.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return (List<Country>) countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country save(Country object) {
        return countryRepository.save(object);
    }

    @Override
    public void delete(Country object) {
        countryRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
