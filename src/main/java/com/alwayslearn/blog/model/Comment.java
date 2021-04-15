package com.alwayslearn.blog.model;


import com.alwayslearn.blog.model.dto.ModifyCommentDto;
import com.alwayslearn.blog.model.dto.ModifyPostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
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

    public Comment(long userId, Post post, Date date, String content){
        this.userId = userId;
        this.post = post;
        this.date = new Date();
        this.content = content;
    }

    public Comment(ModifyCommentDto modifyCommentDto, Post post){
        this.userId = modifyCommentDto.getUserId();
        this.content = modifyCommentDto.getContent();
        this.post=post;
        this.date = new Date();
    }

    public String changeContent(String content, Date date) {
        this.content = content;
        this.date = new Date();
        return content;
    }
}

