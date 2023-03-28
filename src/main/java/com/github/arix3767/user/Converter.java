package com.github.arix3767.user;

/**
 * template for Converting Objects
 * @param <T> - Object to be converted
 * @param <R> - Converted Object
 */
interface Converter<T, R> {

    R convert(T t);
}
