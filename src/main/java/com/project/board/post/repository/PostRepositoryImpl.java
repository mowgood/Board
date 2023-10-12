package com.project.board.post.repository;

import com.project.board.post.dto.request.PostGetListRequestDto;
import com.project.board.post.dto.response.PostGetResponseDto;
import com.project.board.post.enumeration.PostCategory;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.project.board.post.domain.QPost.post;
import static org.apache.logging.log4j.util.Strings.isEmpty;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<PostGetResponseDto> getPostList(PostGetListRequestDto requestDto, Pageable pageable) {
        List<PostGetResponseDto> content = jpaQueryFactory
                .select(Projections.constructor(PostGetResponseDto.class,
                        post.postId,
                        post.title,
                        post.content,
                        post.postCategory,
                        post.member.nickname,
                        post.createdDateTime,
                        post.modifiedDateTime))
                .from(post)
                .where(titleEq(requestDto.getTitle()),
                        contentEq(requestDto.getContent()),
                        postCategoryEq(requestDto.getPostCategory()),
                        nicknameEq(requestDto.getNickname()))
                .orderBy(new OrderSpecifier(requestDto.getSortDirection().isAscending() ? Order.ASC : Order.DESC,
                        new PathBuilder(post.getType(), post.getMetadata()).get(requestDto.getColumn())))
                .offset(pageable.getOffset())
                .limit(requestDto.getPageSize())
                .fetch();

        Long count = jpaQueryFactory
                .select(post.count())
                .from(post)
                .where(titleEq(requestDto.getTitle()),
                        contentEq(requestDto.getContent()),
                        postCategoryEq(requestDto.getPostCategory()),
                        nicknameEq(requestDto.getNickname()))
                .fetchOne();

        return new PageImpl<>(content, pageable, count);
    }

    private BooleanExpression titleEq(String title) {
        return isEmpty(title) ? null : post.title.contains(title);
    }

    private BooleanExpression contentEq(String content) {
        return isEmpty(content) ? null : post.content.contains(content);
    }

    private BooleanExpression postCategoryEq(PostCategory postCategory) {
        return postCategory == null ? null : post.postCategory.eq(postCategory);
    }

    private BooleanExpression nicknameEq(String nickname) {
        return isEmpty(nickname) ? null : post.member.nickname.eq(nickname);
    }
}
