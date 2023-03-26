package com.github.arix3767.user;

import com.github.arix3767.user.dto.UserDto;

enum UserDtoToUserConverter implements Converter<UserDto, UserEntity> {

    INSTANCE;

    @Override
    public UserEntity convert(UserDto userDto) {
        return UserEntity.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .build();
    }
}
