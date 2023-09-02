package com.blogwebsitebackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogwebsitebackend.model.Category;
import com.blogwebsitebackend.model.Post;
import com.blogwebsitebackend.model.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    
    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);
}
