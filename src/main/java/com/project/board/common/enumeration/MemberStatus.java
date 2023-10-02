package com.project.board.common.enumeration;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum MemberStatus {
    NOTFOUND("0"),
    ACTIVE("1"),
    DEACTIVE("2"),
    INIT("3"),
    BLOCK("4");

    private String title;

    MemberStatus(String title) {
        this.title = title;
    }

    public static MemberStatus ofString(String title) {
        return Arrays.stream(MemberStatus.values())
                .filter(x -> x.getTitle().equals(title))
                .findAny()
                .orElseThrow(RuntimeException::new);
    }
}
