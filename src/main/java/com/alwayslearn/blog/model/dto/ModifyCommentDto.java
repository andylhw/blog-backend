package com.alwayslearn.blog.model.dto;

import com.alwayslearn.blog.contorller.request.AddCommentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
