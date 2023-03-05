package com.github.arix3767.user.converters;

public interface Converter<T, R> {

    R convert(T t);
}
