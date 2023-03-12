package com.github.arix3767.result;

import java.util.Map;

public class NotFoundResult<T> extends ApiResult<T> {

    private static final ResultCode RESULT_CODE = ResultCode.USER_NOT_FOUND;

    public NotFoundResult() {
        super(RESULT_CODE);
    }

    public NotFoundResult(Map<ResultProperty, String> properties) {
        super(RESULT_CODE, properties);
    }
}
