package com.project.board.member.enumeration;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum MemberStatus {
    NOTFOUND("notfound"),
    ACTIVE("active"),
    DEACTIVE("deactive"),
    INIT("init"),
    BLOCK("block");

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
