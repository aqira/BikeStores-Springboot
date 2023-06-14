package com.tutorial.bikestores.production.product;

import com.tutorial.bikestores.production.category.Category;
import com.tutorial.bikestores.production.category.CategoryService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private static final Map<Integer, Product> products = new HashMap<>();
    private static int counter;
    private final CategoryService categoryService;

    public ProductService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void exampleProductData() {
        products.put(1, new Product(1, "Electra Townie Original 21D - 2016", categoryService.getCategoryById(2), 2016, new BigDecimal("549.99")));
        products.put(2, new Product(2, "Electra Cruiser 1 (24-Inch) - 2016", categoryService.getCategoryById(3), 2016, new BigDecimal("269.99")));
        products.put(3, new Product(3, "Electra Girl's Hawaii 1 (16-inch) - 2015/2016", categoryService.getCategoryById(1), 2016, new BigDecimal("269.99")));

        counter = products.size();
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProductById(Integer id) {
        return products.get(id);
    }

    public void saveProduct(Product product) {
        product.setCategory(categoryService.getCategoryById(product.getCategoryId()));
        if (product.getId() == null) product.setId(++counter);
        products.put(product.getId(), product);
    }

    public void deleteProductById(Integer id) {
        products.remove(id);
    }
}
