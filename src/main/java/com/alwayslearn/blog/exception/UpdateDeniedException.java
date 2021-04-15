package com.alwayslearn.blog.exception;

public class UpdateDeniedException extends RuntimeException{
    public UpdateDeniedException(Long postId) {
        super("postId: " + postId + " // 잘못된 접근으로 수정이 불가합니다.");
    }
}
