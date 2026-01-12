package com.gabriel.desafio_backend_anotaai.services;

import com.gabriel.desafio_backend_anotaai.domain.product.Product;
import com.gabriel.desafio_backend_anotaai.domain.product.ProductDTO;
import com.gabriel.desafio_backend_anotaai.domain.product.exceptions.ProductNotFoundException;
import com.gabriel.desafio_backend_anotaai.repositories.ProductRepository;

import java.util.List;

public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product insert(ProductDTO productData) {
        Product newProduct = new Product(productData);
        this.repository.save(newProduct);
        return newProduct;
    }

    public Product update(String id,ProductDTO productData) {
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException:: new);

        if (!productData.title().isEmpty()) product.setTitle(productData.title());
        if (!productData.description().isEmpty()) product.setDescription(productData.description());

        this.repository.save(product);

        return product;
    }

    public void delete(String id) {
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException:: new);

        this.repository.delete(product);
    }

    public List<Product> getAll() {
        return this.repository.findAll();
    }



}
