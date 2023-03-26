package com.github.arix3767.user;

import com.github.arix3767.user.dto.UserDto;

enum UserToUserDtoConverter implements Converter<UserEntity, UserDto> {
    INSTANCE;

    @Override
    public UserDto convert(UserEntity user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
