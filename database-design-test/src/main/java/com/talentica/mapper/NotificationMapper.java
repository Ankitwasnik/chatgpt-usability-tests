package com.talentica.mapper;

import com.talentica.dto.NotificationDto;
import com.talentica.model.Notification;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {BaseMapper.class,UserMapper.class, CommentMapper.class, PostMapper.class})
public interface NotificationMapper {

  NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

  @Mapping(source = "user.userId", target = "userId")
  @Mapping(target = "receivedAt", source = "receivedAt", qualifiedByName = "toInstant")
  @Mapping(target = "readAt", source = "readAt", qualifiedByName = "toInstant")
  @Mapping(source = "comment", target = "comment")
  @Mapping(source = "post", target = "post")
  NotificationDto notificationToNotificationDto(Notification notification);

}


