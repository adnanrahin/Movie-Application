package com.spring.boot.movie.app.services.implementaions;

import com.spring.boot.movie.app.model.Language;
import com.spring.boot.movie.app.repositories.LanguageRepository;
import com.spring.boot.movie.app.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class LanguageServiceImpl implements LanguageService {

    private static final Logger logger = Logger.getLogger(LanguageServiceImpl.class.getName());

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> findAll() {
        try {
            List<Language> languages = languageRepository.findAll();
            logger.info("Retrieved all languages successfully.");
            return languages;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding all languages: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Language findById(Long id) {
        try {
            Language language = languageRepository.findById(id).orElse(null);
            if (language != null) {
                logger.info("Retrieved language by id " + id + " successfully.");
            } else {
                logger.warning("No language found for id " + id);
            }
            return language;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding language by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Language save(Language object) {
        try {
            Language savedLanguage = languageRepository.save(object);
            logger.info("Saved language successfully: " + savedLanguage);
            return savedLanguage;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while saving language: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void delete(Language object) {
        try {
            languageRepository.delete(object);
            logger.info("Deleted language successfully: " + object);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting language: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            languageRepository.deleteById(id);
            logger.info("Deleted language by id successfully: " + id);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting language by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }
}
