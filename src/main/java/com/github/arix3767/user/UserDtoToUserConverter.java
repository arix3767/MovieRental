package com.github.arix3767.user;

import com.github.arix3767.user.dto.UserDto;

enum UserDtoToUserConverter implements Converter<UserDto, User> {

    INSTANCE;

    @Override
    public User convert(UserDto userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}
