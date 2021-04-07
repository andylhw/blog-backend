package com.alwayslearn.blog.service;

import com.alwayslearn.blog.contorller.response.PostResponse;
import com.alwayslearn.blog.model.Post;
import com.alwayslearn.blog.model.dto.ModifyPostDto;
import com.alwayslearn.blog.model.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post getPost(Long boardId, Long postId) throws ChangeSetPersister.NotFoundException {
        Post post =  postRepository.findById(postId).orElseThrow(ChangeSetPersister.NotFoundException::new);
        post.increaseViewCount();
        return postRepository.save(post);
    }

    public PostResponse writePost(Long boardId, ModifyPostDto modifyPostDto) { return null; }

    public Post updatePost(Long boardId, Long postId, ModifyPostDto modifyPostDto) throws ChangeSetPersister.NotFoundException {
        Post post = postRepository.findById(postId).orElseThrow(ChangeSetPersister.NotFoundException::new);
        post.editPost(modifyPostDto.getTitle() ,modifyPostDto.getSubject());
        return postRepository.save(post);

    }
}
