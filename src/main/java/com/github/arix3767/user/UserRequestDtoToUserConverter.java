package com.github.arix3767.user;

import com.github.arix3767.user.dto.AddUserRequestDto;

enum UserRequestDtoToUserConverter implements Converter<AddUserRequestDto, User> {

    INSTANCE;

    @Override
    public User convert(AddUserRequestDto addUserRequestDto) {
        return User.builder()
                .email(addUserRequestDto.getEmail())
                .password(addUserRequestDto.getPassword())
                .build();
    }
}
