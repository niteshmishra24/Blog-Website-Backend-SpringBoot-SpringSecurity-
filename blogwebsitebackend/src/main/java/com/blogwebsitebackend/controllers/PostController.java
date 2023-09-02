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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogwebsitebackend.configs.AppConstants;
import com.blogwebsitebackend.payloads.ApiResponse;
import com.blogwebsitebackend.payloads.PostDto;
import com.blogwebsitebackend.payloads.PostResponse;
import com.blogwebsitebackend.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
    
    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Long userId,@PathVariable Long categoryId){
        PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createdPost,HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Long userId){
        List<PostDto> posts = this.postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Long categoryId){
        List<PostDto> posts = this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(
        @RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
        @RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false) Integer pageSize,
        @RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY,required = false) String sortBy,
        @RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIR,required = false) String sortDir){
        PostResponse postDtos = this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);   
        return new ResponseEntity<PostResponse>(postDtos,HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long postId){
        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable Long postId){
        this.postService.deletePost(postId);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Long postId){
        PostDto updatedPostDto = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<PostDto>(updatedPostDto,HttpStatus.OK);
    }    

    @GetMapping("/posts/search/{keyword}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable String keyword){
        List<PostDto> result = this.postService.searchPost(keyword);
        return new ResponseEntity<List<PostDto>>(result, HttpStatus.OK);
    }
}
