package com.tutorial.bikestores.production.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String createCategory(){
        return "redirect:/categories/";
    }

    @GetMapping("{id}/edit")
    public String initCategoryUpdateForm(@PathVariable Integer id, Model model){
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "categories/update-category";
    }

    @PostMapping("{id}/edit")
    public String updateCategory(){
        return "redirect:/categories/";
    }
}
