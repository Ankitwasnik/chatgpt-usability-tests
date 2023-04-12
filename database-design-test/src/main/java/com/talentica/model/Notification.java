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
@Table(name = "Notifications")
@Data
public class Notification {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "notification_id")
  private Long notificationId;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "type_id", referencedColumnName = "type_id")
  private NotificationType type;

  @ManyToOne
  @JoinColumn(name = "source_user_id", referencedColumnName = "user_id")
  private User sourceUser;

  @ManyToOne
  @JoinColumn(name = "post_id", referencedColumnName = "post_id")
  private Post post;

  @ManyToOne
  @JoinColumn(name = "comment_id", referencedColumnName = "comment_id")
  private Comment comment;

  @Column(name = "received_at")
  private LocalDateTime receivedAt;

  @Column(name = "read_at")
  private LocalDateTime readAt;

  // getters and setters
}

