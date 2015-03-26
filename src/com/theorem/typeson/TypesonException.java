package com.theorem.typeson;

public class TypesonException extends RuntimeException {
    public TypesonException(String message) {
        super(message);
    }

    public TypesonException(String message, Throwable cause) {
        super(message, cause);
    }
}
