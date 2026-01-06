package com.gabriel.desafio_backend_anotaai.controllers;

import com.gabriel.desafio_backend_anotaai.domain.category.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody) {


    }
}
