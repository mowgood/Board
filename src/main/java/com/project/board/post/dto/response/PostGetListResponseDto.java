package com.project.board.post.dto.response;

import com.project.board.global.dto.response.ListResponseDto;
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
