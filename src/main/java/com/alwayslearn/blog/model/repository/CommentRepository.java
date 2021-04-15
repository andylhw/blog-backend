package com.alwayslearn.blog.model.repository;

import com.alwayslearn.blog.model.Comment;
import com.alwayslearn.blog.model.dto.CommentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<CommentDto> findAllByPost_PostId(long postId);
}
