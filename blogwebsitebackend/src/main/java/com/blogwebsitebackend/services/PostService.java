package com.blogwebsitebackend.services;

import java.util.List;

import com.blogwebsitebackend.model.Post;
import com.blogwebsitebackend.payloads.PostDto;
import com.blogwebsitebackend.payloads.PostResponse;

public interface PostService {
    
    PostDto createPost(PostDto postDto,Long usedId,Long categoryId);
    PostDto updatePost(PostDto postDto,Long postId);
    void deletePost(Long postId);
    PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
    PostDto getPostById(Long postId);
    List<PostDto> getPostByCategory(Long categoryId);
    List<PostDto> getPostByUser(Long userId);
    List<PostDto> searchPost(String keyword);
}
