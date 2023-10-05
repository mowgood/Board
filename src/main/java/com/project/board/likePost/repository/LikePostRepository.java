package com.project.board.likePost.repository;

import com.project.board.likePost.domain.LikePost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikePostRepository extends JpaRepository<LikePost, Long> {
}
