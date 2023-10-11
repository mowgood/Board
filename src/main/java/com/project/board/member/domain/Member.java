package com.project.board.member.domain;

import com.project.board.member.enumeration.MemberStatus;
import com.project.board.member.enumeration.Role;
import com.project.board.member.enumeration.converter.MemberStatusConverter;
import com.project.board.member.enumeration.converter.RoleConverter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID memberId;

    @NotNull
    private String name;

    @NotNull
    @Column(unique = true)
    private String nickname;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

    @Convert(converter = RoleConverter.class)
    private Role role;

    @Convert(converter = MemberStatusConverter.class)
    private MemberStatus status;

    @NotNull
    private LocalDateTime passwordValidatedDate;

    private LocalDateTime deleteDateTime;

    @NotNull
    private int blockCount;

    @Builder
    public Member(String name, String nickname, String email, String password, Role role, MemberStatus status, LocalDateTime passwordValidatedDate, int blockCount) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
        this.passwordValidatedDate = passwordValidatedDate;
        this.blockCount = blockCount;
    }
}
