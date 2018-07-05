package com.forum.service.impl;

import com.forum.entity.Notification;
import com.forum.mapper.NotificationMapper;
import com.forum.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationMapper notificationMapper;

    @Override
    public void insertNotification(Notification notification) {
        notificationMapper.insertNotification(notification);
    }

    @Override
    public List<Notification> selectNoteByUser(int userId) {
        return notificationMapper.selectNoteByUser(userId);
    }
}
