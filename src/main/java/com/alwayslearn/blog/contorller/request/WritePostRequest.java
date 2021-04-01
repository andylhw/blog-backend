package com.alwayslearn.blog.contorller.request;

import com.alwayslearn.blog.contorller.PostController;
import com.alwayslearn.blog.model.Post;
import com.alwayslearn.blog.service.PostService;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class WritePostRequest {

    private final String name;
    private final String title;
    private final String subject;

}
