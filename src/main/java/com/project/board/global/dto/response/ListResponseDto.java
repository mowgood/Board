package com.project.board.global.dto.response;

import com.project.board.global.util.PagingUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ListResponseDto {
    private PagingUtil pagingUtil;
}
