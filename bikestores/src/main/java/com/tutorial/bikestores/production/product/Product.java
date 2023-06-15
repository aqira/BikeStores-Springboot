package com.tutorial.bikestores.production.product;

import com.tutorial.bikestores.production.category.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "product_id")
    private Integer id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "model_year")
    private Integer modelYear;
    @Column(name = "list_price")
    private BigDecimal listPrice;
    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;
}
