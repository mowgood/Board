package com.project.board.post.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.project.board.post.exception.PostCategoryNotFoundException;
import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Stream;

@Getter
public enum PostCategory {
    NOTICE("notice"),
    FREE("free"),
    DEV("dev");

    private String title;

    PostCategory(String title) {
        this.title = title;
    }

    public static PostCategory ofString(String title) {
        return Arrays.stream(PostCategory.values())
                .filter(x -> x.getTitle().equals(title))
                .findAny()
                .orElseThrow(PostCategoryNotFoundException::new);
    }

    @JsonCreator
    public static PostCategory parsing(String request) {
        return Stream.of(PostCategory.values())
                .filter(x -> x.toString().equals(request.toUpperCase()))
                .findFirst()
                .orElse(null);
    }
}
