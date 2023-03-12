package com.github.arix3767.result;

import java.util.Map;

public class UserAlreadyExistsResult<T> extends ApiResult<T> {

    private static final ResultCode RESULT_CODE = ResultCode.USER_ALREADY_EXISTS;

    public UserAlreadyExistsResult() {
        super(RESULT_CODE);
    }

    public UserAlreadyExistsResult(Map<ResultProperty, String> properties) {
        super(RESULT_CODE, properties);
    }
}
