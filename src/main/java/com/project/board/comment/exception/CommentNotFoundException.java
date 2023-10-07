package com.project.board.comment.exception;

import com.project.board.global.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class CommentNotFoundException extends GlobalException {

    private static final String MESSAGE = "유효하지 않은 댓글입니다.";

    public CommentNotFoundException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }
}
