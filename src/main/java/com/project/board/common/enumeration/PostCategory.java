package com.project.board.common.enumeration;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PostCategory {
    NOTICE("0"),
    FREE("0"),
    DEV("1");

    private String title;

    PostCategory(String title) {
        this.title = title;
    }

    public static PostCategory ofString(String title) {
        return Arrays.stream(PostCategory.values())
                .filter(x -> x.getTitle().equals(title))
                .findAny()
                .orElseThrow(RuntimeException::new);
    }
}
