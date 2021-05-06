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
    private Post post;
    private long userId;
    private Date date;
    private String content;

    public CommentDto(Comment comment){
        this.post = comment.getPost();
        this.Id = comment.getId();
        this.post=comment.getPost();
        this.userId = comment.getUserId();
        this.date = comment.getDate();
        this.content = comment.getContent();
    }

}
