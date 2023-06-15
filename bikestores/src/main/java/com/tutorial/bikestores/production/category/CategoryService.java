package com.tutorial.bikestores.production.category;

import java.util.ArrayList;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    void saveCategory(Category category);

    Category getCategoryById(Integer id);

    void deleteCategoryById(Integer id);
}
