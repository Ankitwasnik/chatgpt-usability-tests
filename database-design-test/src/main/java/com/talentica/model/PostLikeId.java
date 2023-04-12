package com.talentica.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class PostLikeId implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "post_id")
  private Long postId;

  @Column(name = "user_id")
  private Long userId;

  // getters and setters
}

