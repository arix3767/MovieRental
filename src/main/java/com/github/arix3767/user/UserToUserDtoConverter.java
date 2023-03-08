package com.github.arix3767.user;

import com.github.arix3767.user.dto.UserDto;

enum UserToUserDtoConverter implements Converter<User, UserDto> {
    INSTANCE;

    @Override
    public UserDto convert(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
