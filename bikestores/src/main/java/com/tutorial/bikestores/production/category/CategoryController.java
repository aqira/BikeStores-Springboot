package com.tutorial.bikestores.production.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @ModelAttribute("category")
    public Category findCategory(@PathVariable(required = false) Integer categoryId){
        return categoryId == null? new Category() : service.getCategoryById(categoryId);
    }

    @GetMapping("/")
    public ModelAndView showListOfCategories(Model model){
        ModelAndView modelAndView = new ModelAndView("categories/categories-list");
        modelAndView.addObject("categories", service.getAllCategories());
        return modelAndView;
    }

    @GetMapping("{categoryId}")
    public String findCategory(){
        return "categories/category-details";
    }
    @GetMapping("new")
    public String initCategoryCreationalForm(){
        return "categories/upsert-category";
    }

    @PostMapping("new")
    public String createCategory(Category category){
        service.saveCategory(category);
        return "redirect:/categories/";
    }

    @GetMapping("{categoryId}/edit")
    public String initCategoryUpdateForm(){
        return "categories/upsert-category";
    }

    @PostMapping("{categoryId}/edit")
    public String updateCategory(Category category){
        service.saveCategory(category);
        return "redirect:/categories/";
    }

    @GetMapping("{categoryId}/delete")
    public String deleteCategory(@PathVariable Integer categoryId){
        service.deleteCategoryById(categoryId);
        return "redirect:/categories/";
    }
}
