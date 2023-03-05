package com.github.arix3767.user;

interface Converter<T, R> {

    R convert(T t);
}
