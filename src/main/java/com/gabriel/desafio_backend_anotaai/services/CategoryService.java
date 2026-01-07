package com.gabriel.desafio_backend_anotaai.services;

import com.gabriel.desafio_backend_anotaai.domain.category.Category;
import com.gabriel.desafio_backend_anotaai.domain.category.CategoryDTO;
import com.gabriel.desafio_backend_anotaai.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category insert(CategoryDTO categoryData) {
        Category newCategory = new Category(categoryData);
        this.repository.save(newCategory);
        return newCategory;
    }

    public Category update(String id,CategoryDTO categoryData) {
        Category category = this.repository.findById(id).orElseThrow(CategoryNotFoundException);
        return newCategory;
    }

    public List<Category> getAll() {
        return this.repository.findAll();
    }



}
