package com.project.board.post.controller.dto;

import com.project.board.post.enumeration.PostCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostCreateRequestDto {

    @NotBlank(message = "제목을 입력하세요.")
    private String title;

    @NotBlank(message = "내용을 입력하세요.")
    private String content;

    @NotNull(message = "유효하지 않은 카테고리 입니다.")
    private PostCategory postCategory;

    private UUID memberId;

    @Builder
    public PostCreateRequestDto(String title, String content, PostCategory postCategory, UUID memberId) {
        this.title = title;
        this.content = content;
        this.postCategory = postCategory;
        this.memberId = memberId;
    }
}
