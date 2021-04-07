package com.alwayslearn.blog.contorller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdatePostRequest {
    private long userId;
    private String title;
    private String subject;


}
