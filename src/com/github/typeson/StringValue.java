package com.github.typeson;


public class StringValue<T> extends TinyType<String, StringValue<T>> {
    protected StringValue(String value) {
        super(value);
    }
}
