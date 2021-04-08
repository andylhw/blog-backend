package com.alwayslearn.blog.contorller;

import com.alwayslearn.blog.contorller.response.ErrorResponse;
import com.alwayslearn.blog.exception.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse reportError(Throwable throwable) {
        return new ErrorResponse("Global-0", "예상치 못한 에러가 발생했습니다. 빨리 고치겠습니다.");
    }

}
