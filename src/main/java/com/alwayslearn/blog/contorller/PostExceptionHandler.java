package com.alwayslearn.blog.contorller;

import com.alwayslearn.blog.contorller.response.ErrorResponse;
import com.alwayslearn.blog.exception.PostCantUpdateException;
import com.alwayslearn.blog.exception.PostNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PostExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNotFoundException(PostNotFoundException e) {
        return new ErrorResponse("Post-0", e.getMessage());
    }

    @ExceptionHandler(PostCantUpdateException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleCantUpdateException(PostCantUpdateException e) {
        return new ErrorResponse("Post-1", e.getMessage());
    }
}
