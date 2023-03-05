package com.github.arix3767.exception;

import com.github.arix3767.enums.Messages;

public class MissingDataException extends UserException {

    public MissingDataException() {
        super(Messages.MISSING_DATA.getText());
    }
}
