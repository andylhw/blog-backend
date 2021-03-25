package com.alwayslearn.blog.contorller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/boards/{boardsId}/posts")
public class PostController {

    @PatchMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void patchPosts(@PathVariable long postId, @PathVariable String boardsId){

    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePosts(@PathVariable long postId, @PathVariable String boardsId){

    }
}
