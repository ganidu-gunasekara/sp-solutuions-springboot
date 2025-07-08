package com.example.demo.service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entities.Category;
import com.example.demo.repository.CategoryRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryWithNewsItems(Long id) {
        return categoryRepository.findByIdWithNewsItems(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
}
