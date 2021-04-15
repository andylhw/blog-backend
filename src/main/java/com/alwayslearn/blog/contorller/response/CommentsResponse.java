package com.alwayslearn.blog.contorller.response;

import com.alwayslearn.blog.model.Comment;
import com.alwayslearn.blog.model.Post;
import com.alwayslearn.blog.model.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class CommentsResponse {
    private List<CommentDto> comments;


    public CommentsResponse(List<CommentDto> comment){
        this.comments = comment;
    }
}

