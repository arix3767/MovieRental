package com.github.arix3767.user;

import com.github.arix3767.user.dto.AddUserRequestDto;

enum UserRequestDtoToUserConverter implements Converter<AddUserRequestDto, UserEntity> {

    INSTANCE;

    /**
     * Converts addUserRequestDto model to UserEntity database model
     * using singleton
     * @param addUserRequestDto
     * @return UserEntity
     */
    @Override
    public UserEntity convert(AddUserRequestDto addUserRequestDto) {
        return UserEntity.builder()
                .email(addUserRequestDto.getEmail())
                .password(addUserRequestDto.getPassword())
                .build();
    }
}
