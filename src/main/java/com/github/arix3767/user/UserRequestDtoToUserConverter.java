package com.github.arix3767.user;

import com.github.arix3767.user.dto.AddUserRequestDto;

enum UserRequestDtoToUserConverter implements Converter<AddUserRequestDto, UserEntity> {

    INSTANCE;

    @Override
    public UserEntity convert(AddUserRequestDto addUserRequestDto) {
        return UserEntity.builder()
                .email(addUserRequestDto.getEmail())
                .password(addUserRequestDto.getPassword())
                .build();
    }
}
