package com.gabriel.desafio_backend_anotaai.domain.product;

import com.gabriel.desafio_backend_anotaai.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    private String Id;
    private String title;
    private String description;
    private String ownerId;
    private Integer price;
    private Category category;
}
