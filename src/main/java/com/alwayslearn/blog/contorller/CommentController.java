package com.alwayslearn.blog.contorller;

import com.alwayslearn.blog.contorller.request.AddCommentRequest;
import com.alwayslearn.blog.contorller.request.UpdateCommentRequest;
import com.alwayslearn.blog.contorller.response.CommentResponse;
import com.alwayslearn.blog.contorller.response.CommentsResponse;
import com.alwayslearn.blog.model.dto.CommentDto;
import com.alwayslearn.blog.model.dto.ModifyCommentDto;
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

    @GetMapping("/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public CommentsResponse getComments(@RequestParam(required = false) Long size, @RequestParam(required = false) Long page, @PathVariable long boardsId, @PathVariable long postId){
        List<CommentDto> comment = this.commentService.getComment(size, page, boardsId, postId);
        return new CommentsResponse(comment);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CommentResponse addComment(@PathVariable long boardsId, @PathVariable long postId, @RequestBody AddCommentRequest addCommentRequest){
        CommentDto comment = commentService.addComment(postId, new ModifyCommentDto(addCommentRequest));
        return new CommentResponse(comment);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CommentResponse updateComment(@PathVariable long commentId, @PathVariable long postId, @RequestBody UpdateCommentRequest updateCommentRequest){
        CommentDto comment = commentService.updateComment(commentId, updateCommentRequest.getContent());
        return new CommentResponse(comment);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(@PathVariable long boardsId, @PathVariable long postId){
    
    }
}
