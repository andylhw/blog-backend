package com.alwayslearn.blog.contorller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WritePostRequest {
    private long userId; //<userId 가져오는건 나중에.
    private String title;
    private String subject;

}
