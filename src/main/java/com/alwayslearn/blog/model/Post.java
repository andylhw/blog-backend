package com.alwayslearn.blog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long postId;

    private long userId; //<userId 가져오는건 나중에.
    private String title;
    private String subject;
    private Date createdDate;
    private int commentNum;
    private long viewCount;

    public Post(long userId, String title, String subject, int commentNum){
        //this.userId = userId;
        this.title = title;
        this.subject = subject;
        this.createdDate = new Date();
        this.commentNum = commentNum;
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
