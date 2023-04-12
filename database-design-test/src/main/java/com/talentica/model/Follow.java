package com.talentica.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Follows")
@Data
public class Follow {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "follow_id")
  private Long followId;

  @ManyToOne
  @JoinColumn(name = "follower_id", referencedColumnName = "user_id")
  private User follower;

  @ManyToOne
  @JoinColumn(name = "following_id", referencedColumnName = "user_id")
  private User following;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  // getters and setters
}

