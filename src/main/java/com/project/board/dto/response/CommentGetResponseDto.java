package com.project.board.dto.response;

import com.project.board.common.util.DateFormatUtil;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentGetResponseDto {
    private Long parentId;

    private Long commentId;

    private String content;

    private String nickname;

    private String createdDateTime;

    private String modifiedDateTime;

    @Builder
    public CommentGetResponseDto(Long parentId, Long commentId, String content, String nickname, LocalDateTime createdDateTime, LocalDateTime modifiedDateTime) {
        this.parentId = parentId;
        this.commentId = commentId;
        this.content = content;
        this.nickname = nickname;
        this.createdDateTime = DateFormatUtil.toDateTime(createdDateTime);
        this.modifiedDateTime = DateFormatUtil.toDateTime(modifiedDateTime);
    }
}
