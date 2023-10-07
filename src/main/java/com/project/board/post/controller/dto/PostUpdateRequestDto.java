package com.project.board.post.controller.dto;

import com.project.board.post.enumeration.PostCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostUpdateRequestDto {

    @NotBlank(message = "제목을 입력하세요.")
    private String title;

    @NotBlank(message = "내용을 입력하세요.")
    private String content;

    @NotNull(message = "유효하지 않은 카테고리 입니다.")
    private PostCategory postCategory;

    @Builder
    public PostUpdateRequestDto(String title, String content, PostCategory postCategory) {
        this.title = title;
        this.content = content;
        this.postCategory = postCategory;
    }
}
