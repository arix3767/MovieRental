package com.github.arix3767.user;

import com.github.arix3767.user.dto.AddUserRequestDto;

public enum UserToUserRequestDtoConverter implements Converter<User, AddUserRequestDto> {
    INSTANCE;

    @Override
    public AddUserRequestDto convert(User user) {
        return AddUserRequestDto.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
