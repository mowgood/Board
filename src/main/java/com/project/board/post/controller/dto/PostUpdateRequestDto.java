package com.project.board.post.controller.dto;

import com.project.board.post.enumeration.PostCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostUpdateRequestDto {

    @NotBlank(message = "제목을 입력하세요.")
    private String title;

    @NotBlank(message = "내용을 입력하세요.")
    private String content;

    private PostCategory postCategory;

    @Builder
    public PostUpdateRequestDto(String title, String content, PostCategory postCategory) {
        this.title = title;
        this.content = content;
        this.postCategory = postCategory;
    }
}
