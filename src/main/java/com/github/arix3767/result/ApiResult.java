package com.github.arix3767.result;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class ApiResult<T> {

    private T value;
    private ResultCode resultCode;
    private Map<ResultParameter, String> properties;


}
