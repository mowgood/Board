package com.project.board.post.exception;

import com.project.board.global.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class PostNotFoundException extends GlobalException {

    private static final String MESSAGE = "게시글이 존재하지 않습니다.";

    public PostNotFoundException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }
}
