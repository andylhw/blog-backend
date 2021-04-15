package com.alwayslearn.blog.contorller.response;


import com.alwayslearn.blog.model.Comment;
import com.alwayslearn.blog.model.Post;
import com.alwayslearn.blog.model.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class CommentResponse {

    private long userId;
    private Post post;
    private Date date;
    private String content;

    public CommentResponse(CommentDto comment){
        this.userId = comment.getUserId();
        this.date = comment.getDate();
        this.content = comment.getContent();
    }

}
