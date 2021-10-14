package com.test.whatap.handling;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorResponse {
    private int code;
    private String message;
    private String field;

    public ErrorResponse(ErrorCode error, String field) {
        this.message = error.getMessage();
        this.code = error.getCode();
        this.field = field;
    }
}
