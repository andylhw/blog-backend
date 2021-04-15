package com.alwayslearn.blog.exception;

public class CommentCantUpdateException extends RuntimeException {

    public CommentCantUpdateException(Long postId) {
        super("postId: " + postId + "존재하지 않는 댓글입니다. 업데이트가 불가능합니다.");
    }
}