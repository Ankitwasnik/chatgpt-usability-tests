package com.talentica.mapper;

import com.talentica.dto.CommentDto;
import com.talentica.model.Comment;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {BaseMapper.class, UserMapper.class})
public interface CommentMapper {

  CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

  @Mapping(source = "user.userId", target = "userId")
  @Mapping(source = "post.postId", target = "postId")
  @Mapping(target = "createdAt", source = "createdAt", qualifiedByName = "toInstant")
  CommentDto commentToCommentDto(Comment comment);


}

