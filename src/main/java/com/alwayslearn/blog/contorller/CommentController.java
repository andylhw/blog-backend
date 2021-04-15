package com.alwayslearn.blog.contorller;

import com.alwayslearn.blog.contorller.request.AddCommentRequest;
import com.alwayslearn.blog.contorller.response.CommentsResponse;
import com.alwayslearn.blog.model.Comment;
import com.alwayslearn.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards/{boardsId}/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CommentsResponse getComments(@RequestParam(required = false) long size, @RequestParam(required = false) long page, @PathVariable long boardsId, @PathVariable long postId){
        List<Comment> comment = this.commentService.getComment(size, page, boardsId, postId);
        return new CommentsResponse(comment);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addComment(@PathVariable long boardsId, @PathVariable long postId, @RequestBody AddCommentRequest addCommentRequest){

    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateComment(@PathVariable long boardsId, @PathVariable long postId){
    
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(@PathVariable long boardsId, @PathVariable long postId){
    
    }
}
