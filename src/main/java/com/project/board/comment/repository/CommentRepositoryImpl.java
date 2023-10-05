package com.project.board.comment.repository;

import com.project.board.comment.service.dto.CommentGetResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import static com.project.board.entity.QComment.comment;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;

@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<CommentGetResponseDto> findParentByPostId(Long postId) {
        return jpaQueryFactory
                .select(Projections.constructor(CommentGetResponseDto.class, comment.parent.commentId, comment.commentId, comment.content,
                        comment.member.nickname, comment.createdDateTime, comment.modifiedDateTime))
                .from(comment)
                .where(comment.parent.isNull(),
                        comment.post.postId.eq(postId))
                .fetch();
    }

    @Override
    public Map<Long, List<CommentGetResponseDto>> findChildByParentId(List<Long> parentId) {
        return jpaQueryFactory
                .selectFrom(comment)
                .where(comment.parent.isNotNull(),
                        comment.parent.commentId.in(parentId))
                .transform(groupBy(comment.parent.commentId).as(list(Projections.constructor(
                        CommentGetResponseDto.class, comment.parent.commentId, comment.commentId, comment.content,
                        comment.member.nickname, comment.createdDateTime, comment.modifiedDateTime))));
    }
}
