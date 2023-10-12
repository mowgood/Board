package com.project.board.comment.dto.request;

import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Getter
public class CommentUpdateRequestDto {

    @NotBlank(message = "내용을 입력하세요.")
    private String content;

}
