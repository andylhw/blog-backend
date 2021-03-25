package com.alwayslearn.blog.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards/{boardsId}/posts")
public class PostController {

    @GetMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void getPost(@PathVariable Long boardId, @PathVariable Long postId) {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void writePost(@PathVariable Long boardId, @RequestBody writePostRequest WritePostRequest){

    }
    @PutMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@PathVariable Long boardId, @PathVariable Long postId ) {

    }
}
