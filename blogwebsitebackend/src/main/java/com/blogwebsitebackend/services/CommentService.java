package com.blogwebsitebackend.services;

import com.blogwebsitebackend.model.Comment;
import com.blogwebsitebackend.payloads.CommentDto;

public interface CommentService {
    CommentDto createComment(Comment commentDto,Long postid);
    void deleteComment(Long commentId);
}
