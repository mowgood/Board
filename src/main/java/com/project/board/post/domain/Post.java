package com.project.board.post.domain;

import com.project.board.global.domain.BaseEntity;
import com.project.board.member.domain.Member;
import com.project.board.post.dto.request.PostUpdateRequestDto;
import com.project.board.post.enumeration.PostCategory;
import com.project.board.post.enumeration.converter.PostCategoryConverter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @NotNull
    private String title;

    @NotNull
    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    @Convert(converter = PostCategoryConverter.class)
    private PostCategory postCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @Builder
    public Post(String title, String content, PostCategory postCategory, Member member) {
        this.title = title;
        this.content = content;
        this.postCategory = postCategory;
        this.member = member;
    }

    public void update(PostUpdateRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.postCategory = requestDto.getPostCategory();
    }
}
