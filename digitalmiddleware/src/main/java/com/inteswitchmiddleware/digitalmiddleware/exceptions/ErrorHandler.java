package com.inteswitchmiddleware.digitalmiddleware.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

import static com.inteswitchmiddleware.digitalmiddleware.Utility.AppUtility.sanitize;

@Slf4j
@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(CustomException.class)
//    public final ResponseEntity<AppResponse<ErrorDetails>> handleCustomException(CustomException ex, WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(true), HttpStatus.BAD_REQUEST);
//        return ResponseEntity.status(ex.getStatus()).body(AppResponse.<ErrorDetails>builder()
//        .message(ex.getMessage())
//        .status(HttpStatus.BAD_REQUEST.toString())
//        .error(errorDetails)
//        .build());
//    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<AppResponse<ErrorDetails>> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(true), HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(errorDetails.getCode()).body(AppResponse.<ErrorDetails>builder()
        .message(ex.getMessage())
        .status(sanitize(errorDetails.getCode().name()))
        .error(errorDetails)
        .build());
    }

}
