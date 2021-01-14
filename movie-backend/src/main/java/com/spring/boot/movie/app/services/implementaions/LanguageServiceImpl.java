package com.spring.boot.movie.app.services.implementaions;

import com.spring.boot.movie.app.model.Language;
import com.spring.boot.movie.app.repositories.LanguageRepository;
import com.spring.boot.movie.app.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language findById(Long id) {
        return languageRepository.findById(id).orElse(null);
    }

    @Override
    public Language save(Language object) {
        return languageRepository.save(object);
    }

    @Override
    public void delete(Language object) {
        languageRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        languageRepository.deleteById(id);
    }
}
