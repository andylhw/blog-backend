package com.alwayslearn.blog.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    private long userId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private Date date;
    private String content;


    public Comment(long userId, Post post, String content) {
        this.userId = userId;
        this.post = post;
        this.date = new Date();
        this.content = content;
    }

    public String changeContent(String content, Date date) {
        this.content = content;
        this.date = new Date();
        return content;
    }
}

