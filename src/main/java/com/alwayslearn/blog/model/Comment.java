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

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    private long userId;
    private long postId;
    private Date date;
    private String content;


    public Comment(long userId, long postId, Date date, String content) {
        this.userId = userId;
        this.postId = postId;
        this.date = new Date();
        this.content = content;
    }

    public String changeContent(String content, Date date) {
        this.content = content;
        this.date = new Date();
        return content;
    }
}

