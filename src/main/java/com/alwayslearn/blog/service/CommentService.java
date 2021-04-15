package com.alwayslearn.blog.service;

import com.alwayslearn.blog.exception.CommentCantUpdateException;
import com.alwayslearn.blog.exception.PostNotFoundException;
import com.alwayslearn.blog.model.Comment;
import com.alwayslearn.blog.model.Post;
import com.alwayslearn.blog.model.dto.CommentDto;
import com.alwayslearn.blog.model.dto.ModifyCommentDto;
import com.alwayslearn.blog.model.repository.CommentRepository;
import com.alwayslearn.blog.model.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentDto addComment(long postId, ModifyCommentDto modifyCommentDto){
        Post post = postRepository.findById(postId).orElseThrow(()->new PostNotFoundException(postId));
        Comment comment = new Comment(modifyCommentDto, post);
        return new CommentDto(commentRepository.save(comment));
    }

    @Transactional
    public List<CommentDto> getComment(Long size, Long page, long boardsId, long postId) {
        List<CommentDto> comment = commentRepository.findAllByPost_PostId(postId);
        return comment;
    }

    @Transactional
    public CommentDto updateComment(long commentId, String content) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new CommentCantUpdateException(commentId));
        comment.changeContent(content);
        return new CommentDto(comment);
    }

}