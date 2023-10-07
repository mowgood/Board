package com.project.board.post.dto.request;

import com.project.board.global.dto.request.ListRequestDto;
import com.project.board.post.enumeration.PostCategory;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostGetListRequestDto extends ListRequestDto {

    private String title;

    private String content;

    private PostCategory postCategory;

    private String nickname;

    @Builder
    public PostGetListRequestDto(String title, String content, PostCategory postCategory, String nickname) {
        this.title = title;
        this.content = content;
        this.postCategory = postCategory;
        this.nickname = nickname;
    }
}
