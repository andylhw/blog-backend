package com.alwayslearn.blog.contorller.response;

import com.alwayslearn.blog.model.Comment;
import com.alwayslearn.blog.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class CommentResponse {
    private List<Comment> comments;


    public CommentResponse(List<Comment> comment){
        this.comments = comment;
    }
}

