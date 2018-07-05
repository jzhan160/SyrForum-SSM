package com.forum.mapper;

import com.forum.entity.Notification;

import java.util.List;

public interface NotificationMapper {
    void insertNotification(Notification notification);

    List<Notification> selectNoteByUser(int userId);
}
