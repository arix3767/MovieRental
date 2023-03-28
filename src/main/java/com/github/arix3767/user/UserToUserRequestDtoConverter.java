package com.github.arix3767.user;

import com.github.arix3767.user.dto.AddUserRequestDto;

public enum UserToUserRequestDtoConverter implements Converter<UserEntity, AddUserRequestDto> {
    INSTANCE;

    /**
     * Converts UserEntity to AddUserRequestDto model
     * using singleton
     * @param user
     * @return AddUserRequestDto
     */
    @Override
    public AddUserRequestDto convert(UserEntity user) {
        return AddUserRequestDto.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
