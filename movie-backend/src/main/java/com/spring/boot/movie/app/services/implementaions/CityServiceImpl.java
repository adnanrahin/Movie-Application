package com.spring.boot.movie.app.services.implementaions;

import com.spring.boot.movie.app.model.City;
import com.spring.boot.movie.app.repositories.CityRepository;
import com.spring.boot.movie.app.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CityServiceImpl implements CityService {

    private static final Logger logger = Logger.getLogger(CityServiceImpl.class.getName());

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> findAll() {
        try {
            List<City> cities = (List<City>) cityRepository.findAll();
            logger.info("Retrieved all cities successfully.");
            return cities;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding all cities: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public City findById(Long id) {
        try {
            City city = cityRepository.findById(id).orElse(null);
            if (city != null) {
                logger.info("Retrieved city by id " + id + " successfully.");
            } else {
                logger.warning("No city found for id " + id);
            }
            return city;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding city by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public City save(City object) {
        try {
            City savedCity = cityRepository.save(object);
            logger.info("Saved city successfully: " + savedCity);
            return savedCity;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while saving city: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void delete(City object) {
        try {
            cityRepository.delete(object);
            logger.info("Deleted city successfully: " + object);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting city: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            cityRepository.deleteById(id);
            logger.info("Deleted city by id successfully: " + id);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting city by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }
}
