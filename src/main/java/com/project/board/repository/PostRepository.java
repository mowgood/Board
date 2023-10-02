package com.project.board.repository;

import com.project.board.entity.Post;
import com.project.board.repository.mapping.PostGetMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    PostGetMapping findByPostId(Long postId);
}
