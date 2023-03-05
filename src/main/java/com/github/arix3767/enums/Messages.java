package com.github.arix3767.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Messages {

    MISSING_DATA("Missing data"),
    USER_ALREADY_EXISTS("Customer already exists");

    private final String text;
}
