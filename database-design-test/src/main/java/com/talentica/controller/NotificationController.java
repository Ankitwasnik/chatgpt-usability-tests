package com.talentica.controller;

import com.talentica.dto.NotificationDto;
import com.talentica.enums.NotificationFilter;
import com.talentica.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/{userId}/notifications")
public class NotificationController {

  @Autowired
  private NotificationService notificationService;

  @GetMapping
  public ResponseEntity<Page<NotificationDto>> getNotificationsByUser(
      @PathVariable Long userId,
      @RequestParam(defaultValue = "ALL") NotificationFilter filter,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {

    Page<NotificationDto> notifications = notificationService.getNotificationsByUser(userId, filter, page, size);
    return ResponseEntity.ok(notifications);
  }
}

