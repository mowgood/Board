package com.project.board.dto.response;

import com.project.board.common.enumeration.PostCategory;
import com.project.board.common.util.DateFormatUtil;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
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

    private String modifiedDateTime;

    private List<CommentGetByPostResponseDto> commentList;

    @Builder
    public PostGetResponseDto(Long postId, String title, String content, PostCategory postCategory, UUID memberId, String nickname, LocalDateTime createdDateTime, LocalDateTime modifiedDateTime, List<CommentGetByPostResponseDto> commentList) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.postCategory = postCategory;
        this.memberId = memberId;
        this.nickname = nickname;
        this.createdDateTime = DateFormatUtil.toDateTime(createdDateTime);
        this.modifiedDateTime = DateFormatUtil.toDateTime(modifiedDateTime);
        this.commentList = commentList;
    }
}
