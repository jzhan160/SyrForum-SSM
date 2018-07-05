package com.forum.service;

import com.forum.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> selectCommentsByItemId(int itemId);
    void insertComment(Comment comment);
    Comment selectCommentById(int commentId);



}
