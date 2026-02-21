package com.financial_control.controllers;

import com.financial_control.dtos.requests.CategoryRequestDTO;
import com.financial_control.dtos.responses.CategoryResponseDTO;
import com.financial_control.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryResponseDTO createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        return categoryService.createCategory(categoryRequestDTO);
    }

    @GetMapping
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/category/{id}")
    public CategoryResponseDTO getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PutMapping("/category/{id}")
    public CategoryResponseDTO updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDTO categoryRequestDTO) {
        return categoryService.updateCategory(id, categoryRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }

}
