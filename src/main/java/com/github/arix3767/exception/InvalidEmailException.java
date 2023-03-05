package com.github.arix3767.exception;

import com.github.arix3767.enums.Messages;

public class InvalidEmailException extends UserException {

    public InvalidEmailException() {
        super(Messages.INVALID_EMAIL.getText());
    }
}
