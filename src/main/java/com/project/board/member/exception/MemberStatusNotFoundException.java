package com.project.board.member.exception;

import com.project.board.global.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class MemberStatusNotFoundException extends GlobalException {

    private static final String MESSAGE = "해당 멤버 상태가 존재하지 않습니다.";

    public MemberStatusNotFoundException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }
}
