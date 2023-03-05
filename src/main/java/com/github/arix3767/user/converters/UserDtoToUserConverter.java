package com.github.arix3767.user.converters;

import com.github.arix3767.user.dto.UserDto;
import com.github.arix3767.user.entity.User;

public enum UserDtoToUserConverter implements Converter<UserDto, User> {

    INSTANCE;

    @Override
    public User convert(UserDto userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}
