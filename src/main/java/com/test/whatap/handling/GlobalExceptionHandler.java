package com.test.whatap.handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // 존재하지 않는 페이지 접근
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException e) {
        return "error-page";
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException e) {
        return "products";
    }

//    // 다른 형식의 데이터 입력
//    @ExceptionHandler(InvalidFormatException.class)
//    public ResponseEntity<ErrorResponse> handleInvalidFormatException(InvalidFormatException e) {
//        ErrorResponse response = new ErrorResponse(ErrorCode.INPUT_INVALID, (String)e.getValue());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseBody
    public ResponseEntity<ErrorResponse> handleUnexpectedTypeException(ConstraintViolationException e) {
        return new ResponseEntity<>(
                new ErrorResponse()
                .builder()
                .code(-400)
                .message(getResultMessage(e.getConstraintViolations().iterator()))
                .build(), HttpStatus.BAD_REQUEST); // HttpStatus에 따라 jquery의 성공 실패 여부 컨트롤 가능
    }

    protected String getResultMessage(final Iterator<ConstraintViolation<?>> violationIterator) {
        final StringBuilder resultMessageBuilder = new StringBuilder();
        while (violationIterator.hasNext() == true) {
            final ConstraintViolation<?> constraintViolation = violationIterator.next(); // 에러 정보 포함
            resultMessageBuilder
                    .append("['")
                    .append(getPopertyName(constraintViolation.getPropertyPath().toString())) // 유효성 검사가 실패한 속성
                    .append("' is '")
                    .append(constraintViolation.getInvalidValue()) // 유효하지 않은 값
                    .append("', ")
                    .append(constraintViolation.getMessage()) // 유효성 검사 실패 시 메시지
                    .append("]");

            if (violationIterator.hasNext() == true) {
                resultMessageBuilder.append(", ");
            }
        }

        return resultMessageBuilder.toString();
    }

    protected String getPopertyName(String propertyPath) {
        return propertyPath.substring(propertyPath.lastIndexOf('.') + 1); // 전체 속성 경로에서 속성 이름만 가져온다.
    }

//    // 데이터 길이 초과
//    @ExceptionHandler(JdbcSQLDataException.class)
//    public ResponseEntity<ErrorResponse> handleInvalidFormatException(JdbcSQLDataException e) {
//        ErrorResponse response = new ErrorResponse(ErrorCode.TOO_LONG_DATA, e.toString());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
}
