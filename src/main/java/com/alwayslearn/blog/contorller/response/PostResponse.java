package com.alwayslearn.blog.contorller.response;

import com.alwayslearn.blog.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class PostResponse {
    long postId;
    long userId;
    String title;
    String subject;
    Date createdDate;
    int commentNum;
    long viewCount;

    public PostResponse(Post post){
        this.postId= post.getPostId();
        this.userId= post.getUserId();
        this.title = post.getTitle();
        this.subject = post.getSubject();
        this.createdDate = post.getCreatedDate();
        this.commentNum = post.getCommentNum();
        this.viewCount = post.getViewCount();
    }
}
