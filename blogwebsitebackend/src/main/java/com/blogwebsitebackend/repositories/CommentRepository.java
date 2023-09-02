package com.blogwebsitebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogwebsitebackend.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    
}
