package com.spring.boot.movie.app.services;

import com.spring.boot.movie.app.model.Actor;
import com.spring.boot.movie.app.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    Category save(Category object);

    void delete(Category object);

    void deleteById(Long id);
}
