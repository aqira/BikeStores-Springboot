package com.tutorial.bikestores.production.product;

import com.tutorial.bikestores.production.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private Integer id;
    private String name;
    private Integer categoryId;
    private Category category;
    private Integer modelYear;
    private BigDecimal listPrice;

    public Product(Integer id, String name, Category category, Integer modelYear, BigDecimal listPrice) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.modelYear = modelYear;
        this.listPrice = listPrice;
    }
}
