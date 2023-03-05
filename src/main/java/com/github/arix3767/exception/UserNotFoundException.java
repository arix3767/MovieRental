package com.github.arix3767.exception;

import com.github.arix3767.enums.Messages;

public class UserNotFoundException extends UserException {

    public UserNotFoundException() {
        super(Messages.USER_NOT_FOUND.getText());
    }
}
