package com.alwayslearn.blog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class CommentDto {

    long Id;
    private long userId;
    private Date date;
    private String content;

}
