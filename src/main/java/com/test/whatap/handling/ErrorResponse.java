package com.test.whatap.handling;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorResponse {
    private int code;
    private String message;

    @Builder
    public ErrorResponse(int code, String message) {
        this.message = message;
        this.code = code;
    }
}
