package com.project.board.comment.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentCreateRequestDto {

    @NotBlank(message = "내용을 입력하세요.")
    private String content;

    private Long postId;

    private Long parentId;

    private UUID memberId;

}
