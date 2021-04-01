package com.alwayslearn.blog.service;

import com.alwayslearn.blog.model.Post;
import com.alwayslearn.blog.model.dto.ModifyPostDto;
import com.alwayslearn.blog.model.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void getPost(Long boardId, Long postId) {

    }

    public Post writePost(Long boardId, ModifyPostDto modifyPostDto) {
        Post post = new Post(modifyPostDto);
        return postRepository.save(post);

    }
}
