package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Category;
import com.spring.boot.movie.app.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAllCategory")
    public List<Category> getAllCategory() {
        return (List<Category>) categoryService.findAll();
    }

    @PostMapping("/save")
    public void saveCategory(@RequestBody Category object) {
        categoryService.save(object);
    }

}
