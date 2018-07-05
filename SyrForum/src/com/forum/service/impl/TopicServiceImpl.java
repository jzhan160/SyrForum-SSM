package com.forum.service.impl;

import com.forum.entity.Topic;
import com.forum.mapper.TopicMapper;
import com.forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicMapper topicMapper;

    public Topic selectOneTopicById(int topicId){
        return topicMapper.selectOneTopicById(topicId);
    }

    @Override
    public void save(Topic topic) {
        topicMapper.insertTopic(topic);
    }

    @Override
    public List<Topic> selectTopicsByUser(int userId) {
        return topicMapper.selectTopicsByUser(userId);
    }

}
