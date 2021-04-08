package com.alwayslearn.blog.service;

import com.alwayslearn.blog.exception.PostCantUpdateException;
import com.alwayslearn.blog.exception.PostNotFoundException;
import com.alwayslearn.blog.model.Post;
import com.alwayslearn.blog.model.dto.ModifyPostDto;
import com.alwayslearn.blog.model.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post getPost(Long boardId, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId));
        post.increaseViewCount();
        return post;
    }

    public Post writePost(Long boardId, ModifyPostDto modifyPostDto) {
        Post post = new Post(modifyPostDto);
        return postRepository.save(post);
    }

    public Post updatePost(Long boardId, Long postId, ModifyPostDto modifyPostDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostCantUpdateException(postId));
        post.editPost(modifyPostDto.getTitle(), modifyPostDto.getSubject());
        return postRepository.save(post);

    }
}
