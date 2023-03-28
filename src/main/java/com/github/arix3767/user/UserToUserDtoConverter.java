package com.github.arix3767.user;

import com.github.arix3767.user.dto.UserDto;

enum UserToUserDtoConverter implements Converter<UserEntity, UserDto> {
    INSTANCE;

    /**
     * Converts UserEntity to UserDto model
     * using singleton
     * @param user
     * @return UserDto
     */
    @Override
    public UserDto convert(UserEntity user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
