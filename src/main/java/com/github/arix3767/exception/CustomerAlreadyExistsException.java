package com.github.arix3767.exception;

import com.github.arix3767.enums.Messages;

public class CustomerAlreadyExistsException extends UserException {
    public CustomerAlreadyExistsException() {
        super(Messages.USER_ALREADY_EXISTS.getText());
    }
}
