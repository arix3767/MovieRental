package com.github.arix3767.result;

import java.util.Map;

public class MissingDataResult<T> extends ApiResult<T> {

    private static final ResultCode RESULT_CODE = ResultCode.MISSING_DATA;

    public MissingDataResult() {
        super(RESULT_CODE);
    }

    public MissingDataResult(Map<ResultProperty, String> properties) {
        super(RESULT_CODE, properties);
    }
}
