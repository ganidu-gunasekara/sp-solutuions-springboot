package com.example.demo.controller;

import com.example.demo.entities.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String showCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/categories/{id}")
    public String showCategoryDetails(@PathVariable Long id, Model model) {
        Category category = categoryService.getCategoryWithNewsItems(id);
        model.addAttribute("category", category);
        model.addAttribute("newsItems", category.getNewsItems());
        return "category-details";
    }
}
