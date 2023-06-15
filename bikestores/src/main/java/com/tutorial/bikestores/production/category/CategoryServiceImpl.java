package com.tutorial.bikestores.production.category;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbCategoryService")
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id).get();
        return category;
    }

    @Override
    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }
}
