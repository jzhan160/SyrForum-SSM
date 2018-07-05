package com.forum.mapper;

import com.forum.entity.Topic;

import java.util.List;

public interface TopicMapper {
    Topic selectOneTopicById(int topicId);
    void insertTopic(Topic topic);
    List<Topic> selectTopicsByUser(int userId);
}
