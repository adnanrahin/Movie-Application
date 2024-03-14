package com.spring.boot.movie.app.services.implementaions;

import com.spring.boot.movie.app.model.Country;
import com.spring.boot.movie.app.repositories.CountryRepository;
import com.spring.boot.movie.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CountryServiceImpl implements CountryService {

    private static final Logger logger = Logger.getLogger(CountryServiceImpl.class.getName());

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        try {
            List<Country> countries = (List<Country>) countryRepository.findAll();
            logger.info("Retrieved all countries successfully.");
            return countries;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding all countries: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Country findById(Long id) {
        try {
            Country country = countryRepository.findById(id).orElse(null);
            if (country != null) {
                logger.info("Retrieved country by id " + id + " successfully.");
            } else {
                logger.warning("No country found for id " + id);
            }
            return country;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding country by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Country save(Country object) {
        try {
            Country savedCountry = countryRepository.save(object);
            logger.info("Saved country successfully: " + savedCountry);
            return savedCountry;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while saving country: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void delete(Country object) {
        try {
            countryRepository.delete(object);
            logger.info("Deleted country successfully: " + object);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting country: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            countryRepository.deleteById(id);
            logger.info("Deleted country by id successfully: " + id);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting country by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }
}
