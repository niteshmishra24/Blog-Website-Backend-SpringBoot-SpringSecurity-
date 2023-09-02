package com.blogwebsitebackend.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogwebsitebackend.exceptions.ResourceNotFoundException;
import com.blogwebsitebackend.model.Category;
import com.blogwebsitebackend.payloads.CategoryDto;
import com.blogwebsitebackend.repositories.CategoryRepository;
import com.blogwebsitebackend.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.dtoToCategory(categoryDto);
        Category createdCategory = this.categoryRepository.save(category);
        return this.categoryToDto(createdCategory);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "ID", categoryId));
        category.setCategorytitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        return this.categoryToDto(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }

    @Override
    public CategoryDto getCategory(Long categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "ID", categoryId));
        return this.categoryToDto(category);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map(category -> this.categoryToDto(category)).collect(Collectors.toList());
        return categoryDtos;
    }

    public CategoryDto categoryToDto(Category category){
        CategoryDto categoryDto = this.modelMapper.map(category,CategoryDto.class);
        return categoryDto;
    }
    
    public Category dtoToCategory(CategoryDto categoryDto){
        Category category = this.modelMapper.map(categoryDto,Category.class);
        return category;
    }
}
