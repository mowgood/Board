package com.project.board.member.exception;

import com.project.board.global.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class RoleNotFoundException extends GlobalException {

    private static final String MESSAGE = "해당 권한이 존재하지 않습니다.";

    public RoleNotFoundException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }
}
