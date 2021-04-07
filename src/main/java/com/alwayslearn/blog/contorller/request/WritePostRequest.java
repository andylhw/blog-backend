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
    private long userId; //<userId 가져오는건 나중에.
    private String title;
    private String subject;

}
