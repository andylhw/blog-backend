package com.alwayslearn.blog.model.dto;

import com.alwayslearn.blog.contorller.request.UpdatePostRequest;
import com.alwayslearn.blog.contorller.request.WritePostRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ModifyPostDto {

    private long userId;
    private String title;
    private String subject;

    public ModifyPostDto(WritePostRequest writePostRequest){
        this.userId = writePostRequest.getUserId();
        this.title = writePostRequest.getTitle();
        this.subject = writePostRequest.getSubject();
    }

    public ModifyPostDto(UpdatePostRequest updatePostRequest){
        this.userId = updatePostRequest.getUserId();
        this.title = updatePostRequest.getTitle();
        this.subject = updatePostRequest.getSubject();
    }
}
