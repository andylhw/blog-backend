package com.alwayslearn.blog.service;

import com.alwayslearn.blog.exception.CommentCantUpdateException;
import com.alwayslearn.blog.exception.PostNotFoundException;
import com.alwayslearn.blog.model.Comment;
import com.alwayslearn.blog.model.Post;
import com.alwayslearn.blog.model.dto.ModifyCommentDto;
import com.alwayslearn.blog.model.repository.CommentRepository;
import com.alwayslearn.blog.model.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

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

    @Transactional
    public List<Comment> getComment(long size, long page, long boardsId, long postId) {
        List<Comment> comment = commentRepository.findAllByPost_PostId(postId);
        return comment;
    }
    public Comment updateComment(long commentId, String content) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new CommentCantUpdateException(commentId));
        comment.changeContent(content);
        return commentRepository.save(comment);
    }

}