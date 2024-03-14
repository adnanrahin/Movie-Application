package com.spring.boot.movie.app.services.implementaions;

import com.spring.boot.movie.app.model.Category;
import com.spring.boot.movie.app.repositories.CategoryRepository;
import com.spring.boot.movie.app.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class.getName());

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        try {
            List<Category> categories = (List<Category>) categoryRepository.findAll();
            logger.info("Retrieved all categories successfully.");
            return categories;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding all categories: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Category findById(Long id) {
        try {
            Category category = categoryRepository.findById(id).orElse(null);
            if (category != null) {
                logger.info("Retrieved category by id " + id + " successfully.");
            } else {
                logger.warning("No category found for id " + id);
            }
            return category;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding category by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Category save(Category object) {
        try {
            Category savedCategory = categoryRepository.save(object);
            logger.info("Saved category successfully: " + savedCategory);
            return savedCategory;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while saving category: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void delete(Category object) {
        try {
            categoryRepository.delete(object);
            logger.info("Deleted category successfully: " + object);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting category: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            categoryRepository.deleteById(id);
            logger.info("Deleted category by id successfully: " + id);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting category by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }
}
