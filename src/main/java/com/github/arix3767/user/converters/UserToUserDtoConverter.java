package com.github.arix3767.user.converters;

import com.github.arix3767.user.dto.CustomerDto;
import com.github.arix3767.user.dto.UserDto;
import com.github.arix3767.user.entity.User;

public enum UserToUserDtoConverter implements Converter<User, UserDto> {
    INSTANCE;

    @Override
    public UserDto convert(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
