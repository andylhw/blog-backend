package com.alwayslearn.blog.exception;

public class PostCantUpdateException extends RuntimeException {

    public PostCantUpdateException(Long postId) {
        super("postId: " + postId + "존재하지 않는 게시글입니다.");
    }
}
