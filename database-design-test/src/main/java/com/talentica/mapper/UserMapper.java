package com.talentica.mapper;

import com.talentica.dto.UserDto;
import com.talentica.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserDto userToUserDto(User user);

  User userDtoToUser(UserDto userDto);
}

