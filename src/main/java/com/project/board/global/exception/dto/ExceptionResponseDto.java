package com.project.board.global.exception.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExceptionResponseDto {

    private String code;

    private String message;

    @Builder
    public ExceptionResponseDto(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
