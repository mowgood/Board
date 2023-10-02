package com.project.board.dto.request;

import com.project.board.common.enumeration.PostCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostCreateRequestDto {
    private String title;

    private String content;

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
