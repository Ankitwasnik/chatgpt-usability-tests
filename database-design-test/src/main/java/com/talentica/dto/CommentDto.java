package com.talentica.dto;

import java.time.Instant;
import lombok.Data;

@Data
public class CommentDto {
  private Long id;
  private String content;
  private Long postId;
  private Long userId;
  private Instant createdAt;
  private Instant updatedAt;

  // Constructors, getters, and setters
}

