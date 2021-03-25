package com.alwayslearn.blog.contorller;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards/{boardsId}/posts")
public class PostController {

    @GetMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void getPost(@PathVariable Long boardId, @PathVariable Long postId) throws ChangeSetPersister.NotFoundException {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void writePost(@RequestBody Long title, @RequestBody Long body){

    }
    @PutMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@PathVariable Long boardId, @PathVariable Long postId ) throws ChangeSetPersister.NotFoundException {

    }
}
