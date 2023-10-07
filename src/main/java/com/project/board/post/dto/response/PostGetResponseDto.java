package com.project.board.post.dto.response;

import com.project.board.global.util.DateFormatUtil;
import com.project.board.post.enumeration.PostCategory;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostGetResponseDto {

    private Long postId;

    private String title;

    private String content;

    private PostCategory postCategory;

    private String nickname;

    private String createdDateTime;

    private String modifiedDateTime;

    @Builder
    public PostGetResponseDto(Long postId, String title, String content, PostCategory postCategory, String nickname, LocalDateTime createdDateTime, LocalDateTime modifiedDateTime) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.postCategory = postCategory;
        this.nickname = nickname;
        this.createdDateTime = DateFormatUtil.toDateTime(createdDateTime);
        this.modifiedDateTime = DateFormatUtil.toDateTime(modifiedDateTime);
    }
}
