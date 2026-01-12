package com.gabriel.desafio_backend_anotaai.controllers;


import com.gabriel.desafio_backend_anotaai.domain.category.Category;
import com.gabriel.desafio_backend_anotaai.domain.category.CategoryDTO;
import com.gabriel.desafio_backend_anotaai.domain.product.Product;
import com.gabriel.desafio_backend_anotaai.domain.product.ProductDTO;
import com.gabriel.desafio_backend_anotaai.services.CategoryService;
import com.gabriel.desafio_backend_anotaai.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private CategoryService service;

    public  ProductController (ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productData) {
        Product newProduct = this.service.insert(productData);
        return ResponseEntity.ok().body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = this.service.getAll();
        return ResponseEntity.ok().body(products);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update (@PathParam("id") String id, @RequestBody ProductDTO productData) {
        Product updatedProduct = this.service.update(id, productData);
        return ResponseEntity.ok().body(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete (@PathParam("id") String id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
