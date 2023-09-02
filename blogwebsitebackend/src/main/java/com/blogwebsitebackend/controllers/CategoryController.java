package com.blogwebsitebackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogwebsitebackend.payloads.CategoryDto;
import com.blogwebsitebackend.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category/")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createdCategoryDto = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategoryDto,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable("id") Long categoryId){
        CategoryDto updatedCategoryDto = this.categoryService.updateCategory(categoryDto, categoryId);
        return ResponseEntity.ok(updatedCategoryDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long categoryId){
        this.categoryService.deleteCategory(categoryId);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Long categoryid){
        return ResponseEntity.ok(this.categoryService.getCategory(categoryid));
    }
}
