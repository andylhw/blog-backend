package com.alwayslearn.blog.contorller;

import com.alwayslearn.blog.contorller.request.WritePostRequest;
import com.alwayslearn.blog.contorller.response.PostResponse;
import com.alwayslearn.blog.model.Post;
import com.alwayslearn.blog.model.dto.ModifyPostDto;
import com.alwayslearn.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards/{boardId}/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public PostResponse getPost(@PathVariable Long boardId, @PathVariable Long postId) throws ChangeSetPersister.NotFoundException {
        Post post = this.postService.getPost(boardId, postId);
        return new PostResponse(post);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponse writePost(@PathVariable Long boardId, @RequestBody WritePostRequest writePostRequest){
        return null;
    }

    @PutMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@PathVariable Long boardId, @PathVariable Long postId ) {

    }
    @PatchMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void patchPosts(@PathVariable long postId, @PathVariable long boardsId){

    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePosts(@PathVariable long postId, @PathVariable long boardsId){

    }
}
