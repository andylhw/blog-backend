package com.alwayslearn.blog.contorller.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {

    private final LocalDateTime timestamp;
    private final String error;
    private final String message;

    public ErrorResponse(String errCode, String message) {
        this.timestamp = LocalDateTime.now();
        this.error = errCode;
        this.message = message;
    }


}
