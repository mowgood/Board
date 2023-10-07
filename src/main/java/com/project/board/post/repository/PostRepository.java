package com.project.board.post.repository;

import com.project.board.post.domain.Post;
import com.project.board.post.repository.mapping.PostGetMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {

    PostGetMapping findByPostId(Long postId);
}
