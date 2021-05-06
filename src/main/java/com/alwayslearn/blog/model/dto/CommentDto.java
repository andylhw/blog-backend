package com.alwayslearn.blog.model.dto;

import com.alwayslearn.blog.model.Comment;
import com.alwayslearn.blog.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class CommentDto {

    long Id;
    private long userId;
    private Post post;
    private Date date;
    private String content;

    public CommentDto(Comment comment){
        this.Id = comment.getId();
        this.post=comment.getPost();
        this.userId = comment.getUserId();
        this.date = comment.getDate();
        this.content = comment.getContent();
    }

}
