package com.alwayslearn.blog.exception;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(Long postId) {
        super("postId: " + postId + "존재하지 않는 게시글입니다.");
    }
}
