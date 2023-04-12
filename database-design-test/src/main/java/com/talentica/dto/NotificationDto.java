package com.talentica.dto;

import java.time.Instant;
import lombok.Data;

@Data
public class NotificationDto {
  private Long id;
  private Long userId;
  private String message;
  private Instant receivedAt;
  private Instant readAt;
  private CommentDto comment;
  private PostDto post;

  // Constructors, getters, and setters
}


