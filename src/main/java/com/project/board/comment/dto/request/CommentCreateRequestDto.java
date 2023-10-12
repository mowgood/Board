package com.project.board.comment.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentCreateRequestDto {

    @NotBlank(message = "내용을 입력하세요.")
    private String content;

    private Long postId;

    private Long parentId;

    private Long memberId;

}
