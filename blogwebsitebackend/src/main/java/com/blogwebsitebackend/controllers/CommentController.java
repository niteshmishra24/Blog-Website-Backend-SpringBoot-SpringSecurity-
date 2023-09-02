package com.blogwebsitebackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogwebsitebackend.model.Comment;
import com.blogwebsitebackend.payloads.CommentDto;
import com.blogwebsitebackend.services.CommentService;
import com.blogwebsitebackend.services.PostService;

@RestController
@RequestMapping("/api/")
public class CommentController {
    
    @Autowired
    private CommentService commentService;

    @GetMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody Comment comment,@PathVariable Long postId){
        CommentDto commentDto = this.commentService.createComment(comment, postId);
        return new ResponseEntity<CommentDto>(commentDto,HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        this.commentService.deleteComment(commentId);
    }
}
