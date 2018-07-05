package com.forum.service;

import com.forum.entity.Topic;

import java.util.List;

public interface TopicService {
    Topic selectOneTopicById(int topicId);
    void save(Topic topic);
    List<Topic> selectTopicsByUser(int userId);

}
