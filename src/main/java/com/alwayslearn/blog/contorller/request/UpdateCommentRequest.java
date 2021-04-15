package com.alwayslearn.blog.contorller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateCommentRequest {
    private long userId;
    private String content;
}
