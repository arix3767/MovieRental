package com.github.arix3767.result;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class ApiResult<T> {

    private final T value;
    @Getter
    private final ResultCode resultCode;
    private final Map<ResultProperty, String> properties;

    public ApiResult(T value) {
        this.value = value;
        this.resultCode = ResultCode.OK;
        this.properties = Collections.emptyMap();
    }

    public ApiResult(ResultCode resultCode) {
        this.value = null;
        this.resultCode = resultCode;
        this.properties = Collections.emptyMap();
    }

    public ApiResult(ResultCode resultCode, Map<ResultProperty, String> properties) {
        this.value = null;
        this.resultCode = resultCode;
        this.properties = Map.copyOf(properties);
    }

    public Map<ResultProperty, String> getProperties() {
        return Map.copyOf(properties);
    }

    public Optional<T> getValue() {
        return Optional.ofNullable(value);
    }

}
