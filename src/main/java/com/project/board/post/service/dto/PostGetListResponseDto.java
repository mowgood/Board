package com.project.board.post.service.dto;

import com.project.board.global.dto.ListResponseDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostGetListResponseDto extends ListResponseDto {
    private List<PostGetResponseDto> postList;
}
