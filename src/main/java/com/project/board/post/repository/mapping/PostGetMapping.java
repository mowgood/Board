package com.project.board.post.repository.mapping;

import com.project.board.post.enumeration.PostCategory;

import java.time.LocalDateTime;
import java.util.UUID;

public interface PostGetMapping {
    Long getPostId();

    String getTitle();

    String getContent();

    PostCategory getPostCategory();

    UUID getMemberMemberId();

    String getMemberNickname();

    LocalDateTime getCreatedDateTime();

    LocalDateTime getModifiedDateTime();
}
