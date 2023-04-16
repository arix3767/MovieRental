package com.github.arix3767.result;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResultCode {

    OK("everything is ok"),
    MISSING_DATA("Missing data"),
    USER_ALREADY_EXISTS("Customer already exists"),
    INVALID_EMAIL("invalid email"),
    USER_NOT_FOUND("user has not been found"),
    USER_EDIT_SUCCESS("user edited successfully");

    private final String text;
}
