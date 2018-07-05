package com.forum.service;

import com.forum.entity.Notification;

import java.util.List;

public interface NotificationService {
    void insertNotification(Notification notification);
    List<Notification> selectNoteByUser(int userId);


}
