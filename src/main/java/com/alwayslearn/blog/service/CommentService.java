package com.alwayslearn.blog.service;

import com.alwayslearn.blog.exception.PostNotFoundException;
import com.alwayslearn.blog.model.Comment;
import com.alwayslearn.blog.model.Post;
import com.alwayslearn.blog.model.dto.ModifyCommentDto;
import com.alwayslearn.blog.model.repository.CommentRepository;
import com.alwayslearn.blog.model.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public Comment addComment(long postId, ModifyCommentDto modifyCommentDto){
        Post post = postRepository.findById(postId).orElseThrow(()->new PostNotFoundException(postId));
        Comment comment = new Comment(modifyCommentDto, post);
        return commentRepository.save(comment);
    }
}
