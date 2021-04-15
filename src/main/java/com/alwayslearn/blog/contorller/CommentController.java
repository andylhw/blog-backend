package com.alwayslearn.blog.contorller;

import com.alwayslearn.blog.contorller.request.AddCommentRequest;
import com.alwayslearn.blog.contorller.response.CommentResponse;
import com.alwayslearn.blog.model.Comment;
import com.alwayslearn.blog.model.dto.ModifyCommentDto;
import com.alwayslearn.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards/{boardsId}/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void getComments(@RequestParam(required = false) long size, @RequestParam(required = false) long page, @PathVariable long boardsId, @PathVariable long postId){

    }
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CommentResponse addComment(@PathVariable long boardsId, @PathVariable long postId, @RequestBody AddCommentRequest addCommentRequest){
        Comment comment = commentService.addComment(postId, new ModifyCommentDto(addCommentRequest));
        return new CommentResponse(comment);
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
