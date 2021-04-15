package com.alwayslearn.blog.model.dto;

import com.alwayslearn.blog.contorller.request.AddCommentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ModifyCommentDto {
    private long userId;
    private String content;

    public ModifyCommentDto(AddCommentRequest addCommentRequest){
        this.userId = addCommentRequest.getUserId();
        this.content = addCommentRequest.getContent();
    }
}
