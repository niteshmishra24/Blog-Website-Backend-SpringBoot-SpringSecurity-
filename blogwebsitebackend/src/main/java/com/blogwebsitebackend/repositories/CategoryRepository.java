package com.blogwebsitebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogwebsitebackend.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
