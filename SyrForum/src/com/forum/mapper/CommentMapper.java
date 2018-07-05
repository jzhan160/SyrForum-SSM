package com.forum.mapper;

import com.forum.entity.Comment;

import java.util.List;

public interface CommentMapper {
    List<Comment> selectCommentsByItemId(int itemId);
    void insertComment(Comment comment);
    Comment selectCommentById(int commentId);
}
