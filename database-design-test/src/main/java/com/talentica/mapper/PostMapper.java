package com.talentica.mapper;

import com.talentica.dto.PostDto;
import com.talentica.model.Post;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {BaseMapper.class})
public interface PostMapper {

  PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

  @Mapping(source = "postId", target = "id")
  @Mapping(source = "user.userId", target = "userId")
  @Mapping(target = "createdAt", source = "createdAt", qualifiedByName = "toInstant")
  PostDto postToPostDto(Post post);


}

