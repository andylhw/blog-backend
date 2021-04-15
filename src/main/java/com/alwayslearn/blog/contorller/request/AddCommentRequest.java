package com.alwayslearn.blog.contorller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddCommentRequest {
    private long userId;
    private String content;
}
