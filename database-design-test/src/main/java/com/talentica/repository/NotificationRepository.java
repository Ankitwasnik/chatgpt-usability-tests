package com.talentica.repository;

import com.talentica.model.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

  Page<Notification> findByUserUserId(Long userId, Pageable pageable);

  Page<Notification> findByUserUserIdAndReadAtIsNull(Long userId, Pageable pageable);

  Page<Notification> findByUserUserIdAndReadAtIsNotNull(Long userId, Pageable pageable);
}

