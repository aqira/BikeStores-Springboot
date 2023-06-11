package com.tutorial.bikestores.production.category;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    private static final Map<Integer, Category> categories = new HashMap<>();

    static{
        categories.put(1, new Category(1, "Mountain bike"));
        categories.put(2, new Category(2, "Street bike"));
        categories.put(3, new Category(3, "City bike"));
    }

    public List<Category> getAllCategories() {
        return new ArrayList<>(categories.values());
    }

    public Category getCategoryById(Integer id) {
        return categories.get(id);
    }

    public void saveCategory(Category category) {
        categories.put(category.getId(), category);
    }

    public void deleteCategoryById(Integer id) {
        categories.remove(id);
    }


}
