package com.project.board.global.exception.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExceptionResponseDto {

    private String statusCode;

    private String message;

    @Builder
    public ExceptionResponseDto(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
