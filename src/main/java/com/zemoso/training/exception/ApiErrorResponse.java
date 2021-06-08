package com.zemoso.training.exception;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse {
    private HttpStatus httpStatus;
    private String errorMessage;
    private String details;

    public ApiErrorResponse(){
        super();
    }

    public ApiErrorResponse(HttpStatus httpStatus, String message, String details) {
        super();
        this.httpStatus = httpStatus;
        this.errorMessage = message;
        this.details = details;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
