package com.zemoso.training.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(Exception ex, WebRequest webRequest){
        String errorMessage = ex.getMessage();
        var errorResponse = new ApiErrorResponse(HttpStatus.NOT_FOUND, errorMessage, webRequest.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleValidationException(Exception ex, WebRequest webRequest){
        String errorMessage = ex.getMessage();
        var errorResponse = new ApiErrorResponse(HttpStatus.BAD_REQUEST, errorMessage, webRequest.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
