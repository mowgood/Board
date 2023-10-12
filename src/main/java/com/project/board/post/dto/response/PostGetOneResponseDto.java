package com.project.board.post.dto.response;

import com.project.board.comment.dto.response.CommentGetByPostResponseDto;
import com.project.board.global.util.DateFormatUtil;
import com.project.board.post.enumeration.PostCategory;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PostGetOneResponseDto {
    private Long postId;

    private String title;

    private String content;

    private PostCategory postCategory;

    private Long memberId;

    private String nickname;

    private String createdDateTime;

    private String modifiedDateTime;

    private List<CommentGetByPostResponseDto> commentList;

    @Builder
    public PostGetOneResponseDto(Long postId, String title, String content, PostCategory postCategory, Long memberId, String nickname, LocalDateTime createdDateTime, LocalDateTime modifiedDateTime, List<CommentGetByPostResponseDto> commentList) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.postCategory = postCategory;
        this.memberId = memberId;
        this.nickname = nickname;
        this.createdDateTime = DateFormatUtil.toDateTime(createdDateTime);
        this.modifiedDateTime = DateFormatUtil.toDateTime(modifiedDateTime);
        this.commentList = commentList;
    }
}
