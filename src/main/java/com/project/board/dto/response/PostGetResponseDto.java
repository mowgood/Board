package com.project.board.dto.response;

import com.project.board.common.enumeration.PostCategory;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class PostGetResponseDto {
    private Long postId;

    private String title;

    private String content;

    private PostCategory postCategory;

    private UUID memberId;

    private String nickname;

    private String createdDateTime;

    @Builder
    public PostGetResponseDto(Long postId, String title, String content, PostCategory postCategory, UUID memberId, String nickname, String createdDateTime) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.postCategory = postCategory;
        this.memberId = memberId;
        this.nickname = nickname;
        this.createdDateTime = createdDateTime;
    }
}
