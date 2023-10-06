package com.project.board.post.exception;

import com.project.board.global.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class PostCategoryNotFoundException extends GlobalException {

    private static final String MESSAGE = "해당 게시글 카테고리가 존재하지 않습니다.";

    public PostCategoryNotFoundException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }
}
