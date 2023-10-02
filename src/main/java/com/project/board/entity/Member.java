package com.project.board.entity;

import com.project.board.common.converter.MemberStatusConverter;
import com.project.board.common.converter.RoleConverter;
import com.project.board.common.enumeration.MemberStatus;
import com.project.board.common.enumeration.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE member SET deleted = true WHERE id = ?")
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

    private boolean deleted = Boolean.FALSE;

    @NotNull
    private int blockCount;

}
