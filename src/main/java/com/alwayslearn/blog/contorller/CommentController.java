package com.alwayslearn.blog.contorller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards/{boardsId}/posts/{postId}/comments")
public class CommentController {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addComment(@PathVariable long boardsId, @PathVariable long postId){

    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateComment(@PathVariable long boardsId, @PathVariable long postId){}

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(@PathVariable long boardsId, @PathVariable long postId){}

}
