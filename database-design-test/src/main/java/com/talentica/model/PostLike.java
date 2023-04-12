package com.talentica.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Post_Likes")
@Data
public class PostLike {

  @EmbeddedId
  private PostLikeId id;

  @ManyToOne
  @MapsId("postId")
  @JoinColumn(name = "post_id")
  private Post post;

  @ManyToOne
  @MapsId("userId")
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  // getters and setters
}

