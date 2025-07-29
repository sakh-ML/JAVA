package com.booking.mappers;

import com.booking.dto.UserDto;
import com.booking.model.User;

public interface UserMapper {

    User toUser(UserDto user);
    UserDto toDto(User user);
}
