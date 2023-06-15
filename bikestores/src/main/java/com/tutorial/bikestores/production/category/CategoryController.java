package com.tutorial.bikestores.production.category;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    private final CategoryService service;

    public CategoryController(@Qualifier("dbCategoryService") CategoryService service) {
        this.service = service;
    }

    @ModelAttribute("category")
    public Category findCategory(@PathVariable(required = false) Integer id){
        return id == null? new Category() : service.getCategoryById(id);
    }
    @GetMapping("/categories")
    public ModelAndView showAllCategories(){
        ModelAndView modelAndView = new ModelAndView("/categories/categories-index");
        modelAndView.addObject("categories", service.getAllCategories());
        return modelAndView;
    }
    @GetMapping("/categories/{id}")
    public ModelAndView showCategory(){
        ModelAndView modelAndView = new ModelAndView("/categories/category-details");
        return modelAndView;
    }

    @GetMapping("/categories/new")
    public ModelAndView initCreationCategory(){
        ModelAndView modelAndView = new ModelAndView("/categories/upsert-category");
        return modelAndView;
    }

    @PostMapping("/categories/new")
    public String newCategoryCreation(@Valid Category category, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "categories/upsert-category";
        }
        service.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/edit")
    public ModelAndView initEditCategory(){
        ModelAndView modelAndView = new ModelAndView("/categories/upsert-category");
        return modelAndView;
    }

    @PostMapping("/categories/{id}/edit")
    public String editCategory(@Valid Category category, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "categories/upsert-category";
        }
        service.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/remove")
    public String removeCategory(@PathVariable Integer id){
        service.deleteCategoryById(id);
        return "redirect:/categories";
    }

}
