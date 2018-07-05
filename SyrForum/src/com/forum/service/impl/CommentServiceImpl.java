package com.forum.service.impl;

import com.forum.entity.Comment;
import com.forum.mapper.CommentMapper;
import com.forum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> selectCommentsByItemId(int itemId) {
        return commentMapper.selectCommentsByItemId(itemId);
    }

    @Override
    public void insertComment(Comment comment) {
        commentMapper.insertComment(comment);
    }

    @Override
    public Comment selectCommentById(int commentId) {
        return commentMapper.selectCommentById(commentId);
    }
}
