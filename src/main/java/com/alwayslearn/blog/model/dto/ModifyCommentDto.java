package com.alwayslearn.blog.model.dto;

import com.alwayslearn.blog.contorller.request.UpdatePostRequest;
import com.alwayslearn.blog.contorller.request.WritePostRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@AllArgsConstructor
public class ModifyCommentDto {
    private long userId;
    private String content;
}
