package com.tutorial.bikestores.production.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String showListOfCategories(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories/categories-list";
    }

    @GetMapping("{id}")
    public String findCategory(@PathVariable Integer id, Model model){
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "categories/category-details";
    }
    @GetMapping("new")
    public String initCategoryCreationalForm(Model model){
        model.addAttribute("category", new Category());
        return "categories/insert-category";
    }

    @PostMapping("new")
    public String createCategory(Category category){
        categoryService.saveCategory(category);
        return "redirect:/categories/";
    }

    @GetMapping("{id}/edit")
    public String initCategoryUpdateForm(@PathVariable Integer id, Model model){
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "categories/update-category";
    }

    @PostMapping("{id}/edit")
    public String updateCategory(@PathVariable Integer id, Category category){
        categoryService.saveCategory(category);
        return "redirect:/categories/";
    }

    @GetMapping("{id}/delete")
    public String deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategoryById(id);
        return "redirect:/categories/";
    }
}
