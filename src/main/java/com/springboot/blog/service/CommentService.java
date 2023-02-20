package com.springboot.blog.service;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.payload.CommentDto;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
    List<CommentDto> findCommentByPostId(Long postId);

    Comment editComment(CommentDto commentDto);
    void  deleteCommment(Long postId);
}
