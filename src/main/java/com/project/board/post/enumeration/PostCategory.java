package com.project.board.post.enumeration;

import lombok.Getter;

import java.util.Arrays;

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
                .orElseThrow(RuntimeException::new);
    }
}
