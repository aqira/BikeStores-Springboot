package com.tutorial.bikestores.production.product;

import com.tutorial.bikestores.production.category.CategoryServiceStaticImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final CategoryServiceStaticImpl categoryServiceStaticImpl;
}
