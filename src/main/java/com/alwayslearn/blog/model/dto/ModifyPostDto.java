package com.alwayslearn.blog.model.dto;

import com.alwayslearn.blog.contorller.request.WritePostRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ModifyPostDto {
    private long postId;
    private long userId;
    private String title;
    private String subject;
    private Date createdDate;
    private int commentNum;
    private long viewCount;

    public ModifyPostDto(WritePostRequest writePostRequest){

    }
}
