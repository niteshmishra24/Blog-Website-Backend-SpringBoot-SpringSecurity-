package com.blogwebsitebackend.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogwebsitebackend.exceptions.ResourceNotFoundException;
import com.blogwebsitebackend.model.Comment;
import com.blogwebsitebackend.model.Post;
import com.blogwebsitebackend.payloads.CommentDto;
import com.blogwebsitebackend.repositories.CommentRepository;
import com.blogwebsitebackend.repositories.PostRepository;
import com.blogwebsitebackend.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(Comment commentDto, Long postid) {
        Post post = this.postRepository.findById(postid).orElseThrow(()-> new ResourceNotFoundException("Post", "Id", postid));

        Comment comment = this.modelMapper.map(commentDto,Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepository.save(comment);
        
        return this.modelMapper.map(savedComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment com = this.commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "Id", commentId));
        this.commentRepository.delete(com);
    }

}
