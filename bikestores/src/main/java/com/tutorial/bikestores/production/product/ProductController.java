package com.tutorial.bikestores.production.product;

import com.tutorial.bikestores.production.category.Category;
import com.tutorial.bikestores.production.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @ModelAttribute("product")
    public Product findProduct(@PathVariable(required = false) Integer productId){
        return productId == null? new Product() : productService.getProductById(productId);
    }

    @ModelAttribute("categories")
    public List<Category> findCategories(){
        return  categoryService.getAllCategories();
    }

    @GetMapping("/")
    public ModelAndView showListOfProducts(){
        ModelAndView modelAndView = new ModelAndView("products/products-list");
        modelAndView.addObject("products", productService.getAllProducts());
        return modelAndView;
    }

    @GetMapping("{productId}")
    public String findProduct(){
        return "products/product-details";
    }
    @GetMapping("new")
    public String initProductCreationalForm(){
        return "products/upsert-product";
    }

    @PostMapping("new")
    public String createProduct(Product product){

        productService.saveProduct(product);
        return "redirect:/products/";
    }

    @GetMapping("{productId}/edit")
    public String initProductUpdateForm(){
        return "products/upsert-product";
    }

    @PostMapping("{productId}/edit")
    public String updateProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/products/";
    }

    @GetMapping("{productId}/delete")
    public String deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);
        return "redirect:/products/";
    }
}
