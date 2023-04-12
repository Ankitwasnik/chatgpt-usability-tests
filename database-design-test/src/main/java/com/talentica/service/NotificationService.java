package com.talentica.service;

import com.talentica.dto.NotificationDto;
import com.talentica.enums.NotificationFilter;
import com.talentica.mapper.NotificationMapper;
import com.talentica.model.Notification;
import com.talentica.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

  @Autowired
  private NotificationRepository notificationRepository;

  @Autowired
  private NotificationMapper notificationMapper;

  public Page<NotificationDto> getNotificationsByUser(Long userId, NotificationFilter filter, int page, int size) {
    Pageable pageable = PageRequest.of(page, size, Sort.by("receivedAt").descending());

    Page<Notification> notifications;
    switch (filter) {
      case ALL:
        notifications = notificationRepository.findByUserUserId(userId, pageable);
        break;
      case UNREAD:
        notifications = notificationRepository.findByUserUserIdAndReadAtIsNull(userId, pageable);
        break;
      case READ:
        notifications = notificationRepository.findByUserUserIdAndReadAtIsNotNull(userId, pageable);
        break;
      default:
        throw new IllegalArgumentException("Invalid filter value: " + filter);
    }

    return notifications.map(notificationMapper::notificationToNotificationDto);
  }
}

