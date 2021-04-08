package com.alwayslearn.blog.contorller.request;

import com.alwayslearn.blog.model.dto.ModifyCommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddCommentRequest {
    private long userId;
    private String content;

    public ModifyCommentDto toDto(){
        return new ModifyCommentDto(userId, content);
    }
}
