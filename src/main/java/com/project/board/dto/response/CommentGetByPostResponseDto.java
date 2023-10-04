package com.project.board.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CommentGetByPostResponseDto {
    private Long parentId;

    private Long commentId;

    private String content;

    private String nickname;

    private String createdDateTime;

    private String modifiedDateTime;

    List<CommentGetResponseDto> childCommentList;

    @Builder
    public CommentGetByPostResponseDto(Long parentId, Long commentId, String content, String nickname, String createdDateTime, String modifiedDateTime, List<CommentGetResponseDto> childCommentList) {
        this.parentId = parentId;
        this.commentId = commentId;
        this.content = content;
        this.nickname = nickname;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
        this.childCommentList = childCommentList;
    }
}
