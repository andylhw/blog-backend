package com.alwayslearn.blog.model;

import com.alwayslearn.blog.model.dto.ModifyPostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "post_id")
    long postId;

    private Long userId; //<userId 가져오는건 나중에.
    private String title;
    private String subject;
    private Date createdDate;
    private int commentNum;
    private long viewCount;

    public Post(long userId, String title, String subject){
        this.userId = userId;
        this.title = title;
        this.subject = subject;
        this.createdDate = new Date();
        this.commentNum = 0;
        this.viewCount = 0;
    }

    public Post(ModifyPostDto modifyPostDto){
        this.userId = modifyPostDto.getUserId();
        this.title = modifyPostDto.getTitle();
        this.subject = modifyPostDto.getSubject();
        this.createdDate = new Date();
        this.commentNum = 0;
        this.viewCount = 0;
    }

    public Post editPost(String title, String subject){
        this.title = title;
        this.subject = subject;
        return this;
    }

    public void increaseViewCount(){
        this.viewCount++;
    }

    public void increaseCommentNum(){
        this.commentNum++;
    }

    public void decreaseCommentNum(){
        this.commentNum--;
    }

}
