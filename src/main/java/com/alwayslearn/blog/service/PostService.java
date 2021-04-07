package com.alwayslearn.blog.service;

import com.alwayslearn.blog.model.Post;
import com.alwayslearn.blog.model.dto.ModifyPostDto;
import com.alwayslearn.blog.model.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post getPost(Long boardId, Long postId) throws ChangeSetPersister.NotFoundException {
        Post post =  postRepository.findById(postId).orElseThrow(ChangeSetPersister.NotFoundException::new);
        post.increaseViewCount();
        return postRepository.save(post);
    }

    public Post writePost(Long boardId, ModifyPostDto modifyPostDto) {
        Post post = new Post(modifyPostDto);
        return postRepository.save(post);

    }
}
