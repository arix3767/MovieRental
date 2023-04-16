package com.github.arix3767.result;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

/**
 * This class is responsible for managing
 * results returned by service
 * @param <T>
 */
public class ApiResult<T> {

    private final T value;
    @Getter
    private final ResultCode resultCode;
    private final Map<ResultProperty, String> properties;

    /**
     * Displays positive result
     * of a functionality
     * @param value received from other methods
     * depending on the transferred object
     */
    public ApiResult(T value) {
        this.value = value;
        this.resultCode = ResultCode.OK;
        this.properties = Collections.emptyMap();
    }

    /**
     * Displays negative result
     * of a functionality with specific
     * cause
     * @param resultCode - code of the result
     */
    public ApiResult(ResultCode resultCode) {
        this.value = null;
        this.resultCode = resultCode;
        this.properties = Collections.emptyMap();
    }

    /**
     * Displays negative result
     * of a functionality with specific cause
     * and additional properties
     * @param resultCode code of the result
     * @param properties specific description
     * of the result
     */
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
