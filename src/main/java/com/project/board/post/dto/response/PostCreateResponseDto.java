package com.project.board.post.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Getter
public class PostCreateResponseDto extends RepresentationModel<PostCreateResponseDto> {

    private Long createdId;

    @Builder
    public PostCreateResponseDto(Long createdId) {
        this.createdId = createdId;
    }
}
