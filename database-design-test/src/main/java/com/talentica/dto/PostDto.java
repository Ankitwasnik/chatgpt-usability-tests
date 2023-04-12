package com.talentica.dto;

import java.time.Instant;
import lombok.Data;

@Data
public class PostDto {
  private Long id;
  private String content;
  private String imageUrl;
  private Long userId;
  private Instant createdAt;

  // Constructors, getters, and setters
}
