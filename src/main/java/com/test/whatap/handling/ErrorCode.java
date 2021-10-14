package com.test.whatap.handling;

import lombok.Getter;

@Getter
public enum ErrorCode {
    // Common
    PAGE_NOT_FOUND(100, "Page not found"),

    // Product
    INPUT_INVALID(201, "Input is invalid"),
    TOO_LONG_DATA(202, "Value too long");

    private final int code;
    private final String message;

    ErrorCode(final int code, final String message) {
        this.message = message;
        this.code = code;
    }
}
