package com.project.board.member.enumeration;

import com.project.board.member.exception.RoleNotFoundException;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Role {
    NOTFOUND("notfound"),
    ADMIN("admin"),
    MEMBER("member");

    private String title;

    Role(String title) {
        this.title = title;
    }

    public static Role ofString(String title) {
        return Arrays.stream(Role.values())
                .filter(x -> x.getTitle().equals(title))
                .findAny()
                .orElseThrow(RoleNotFoundException::new);
    }
}
