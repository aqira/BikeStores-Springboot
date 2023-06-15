package com.tutorial.bikestores.production.category;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("staticCategoryService")
public class CategoryServiceStaticImpl implements CategoryService{

    private final static Map<Integer, Category> categories = new HashMap<>();

    static {
        categories.put(1, new Category(1, "Street Bike"));
        categories.put(2, new Category(2, "Mountain Bike"));
        categories.put(3, new Category(3, "Road Bike"));
        categories.put(4, new Category(4, "Family Bike"));
        categories.put(5, new Category(5, "Children Bike"));
        categories.put(6, new Category(6, "Electric Bike"));
    }

    private static int counter = categories.size();

    public List<Category> getAllCategories() {
        return new ArrayList<>(categories.values());
    }

    public void saveCategory(Category category) {
        if (category.getId() == null) {
            category.setId(++counter);
        }
        categories.put(category.getId(), category);
    }

    public Category getCategoryById(Integer id) {
        return categories.get(id);
    }

    public void deleteCategoryById(Integer id) {
        categories.remove(id);
    }
}