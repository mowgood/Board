package com.project.board.post.service;

import com.project.board.post.controller.dto.PostCreateRequestDto;
import com.project.board.comment.service.dto.CommentGetByPostResponseDto;
import com.project.board.comment.service.dto.CommentGetResponseDto;
import com.project.board.post.exception.PostNotFoundException;
import com.project.board.post.service.dto.PostCreateResponseDto;
import com.project.board.post.service.dto.PostGetResponseDto;
import com.project.board.member.domain.Member;
import com.project.board.post.domain.Post;
import com.project.board.comment.repository.CommentRepository;
import com.project.board.member.repository.MemberRepository;
import com.project.board.post.repository.PostRepository;
import com.project.board.post.repository.mapping.PostGetMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public PostCreateResponseDto createPost(PostCreateRequestDto requestDto) {
        Member member = memberRepository.findById(requestDto.getMemberId()).orElseThrow();

        Post post = Post.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .postCategory(requestDto.getPostCategory())
                .member(member)
                .build();

         postRepository.save(post);

        return PostCreateResponseDto.builder()
                .createdId(post.getPostId())
                .build();
    }

    @Transactional(readOnly = true)
    public PostGetResponseDto getPost(Long postId) {
        PostGetMapping postGetMapping = postRepository.findByPostId(postId);

        if(postGetMapping == null) {
            throw new PostNotFoundException();
        }

        List<CommentGetResponseDto> parentCommentList = commentRepository.findParentByPostId(postId);

        List<Long> parentCommentIdList = parentCommentList.stream().map(comment -> comment.getCommentId())
                .collect(Collectors.toList());

        Map<Long, List<CommentGetResponseDto>> childCommentList = commentRepository.findChildByParentId(parentCommentIdList);

        List<CommentGetByPostResponseDto> commentList = parentCommentList.stream().map(
                comment -> CommentGetByPostResponseDto.builder()
                        .parentId(comment.getParentId())
                        .commentId(comment.getCommentId())
                        .content(comment.getContent())
                        .nickname(comment.getNickname())
                        .createdDateTime(comment.getCreatedDateTime())
                        .modifiedDateTime(comment.getModifiedDateTime())
                        .childCommentList(childCommentList.get(comment.getCommentId()))
                        .build()).collect(Collectors.toList());

        return PostGetResponseDto.builder()
                .postId(postGetMapping.getPostId())
                .title(postGetMapping.getTitle())
                .content(postGetMapping.getContent())
                .postCategory(postGetMapping.getPostCategory())
                .memberId(postGetMapping.getMemberMemberId())
                .nickname(postGetMapping.getMemberNickname())
                .createdDateTime(postGetMapping.getCreatedDateTime())
                .modifiedDateTime(postGetMapping.getModifiedDateTime())
                .commentList(commentList)
                .build();
    }
}
