package com.test.whatap.handling;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.h2.jdbc.JdbcSQLDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    // 존재하지 않는 페이지 접근
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException e) {
        return "error-page";
    }

    // 다른 형식의 데이터 입력
    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ErrorResponse> handleInvalidFormatException(InvalidFormatException e) {
        ErrorResponse response = new ErrorResponse(ErrorCode.INPUT_INVALID, (String)e.getValue());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // 데이터 길이 초과
    @ExceptionHandler(JdbcSQLDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidFormatException(JdbcSQLDataException e) {
        ErrorResponse response = new ErrorResponse(ErrorCode.TOO_LONG_DATA, e.toString());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
