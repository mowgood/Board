package com.project.board.post.repository.mapping;

import com.project.board.post.enumeration.PostCategory;

import java.time.LocalDateTime;

public interface PostGetMapping {
    Long getPostId();

    String getTitle();

    String getContent();

    PostCategory getPostCategory();

    Long getMemberMemberId();

    String getMemberNickname();

    LocalDateTime getCreatedDateTime();

    LocalDateTime getModifiedDateTime();
}
