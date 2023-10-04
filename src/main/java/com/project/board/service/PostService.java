package com.project.board.service;

import com.project.board.dto.request.PostCreateRequestDto;
import com.project.board.dto.response.CommentGetByPostResponseDto;
import com.project.board.dto.response.CommentGetResponseDto;
import com.project.board.dto.response.PostCreateResponseDto;
import com.project.board.dto.response.PostGetResponseDto;
import com.project.board.entity.Member;
import com.project.board.entity.Post;
import com.project.board.repository.CommentRepository;
import com.project.board.repository.MemberRepository;
import com.project.board.repository.PostRepository;
import com.project.board.repository.mapping.PostGetMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;

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

    public PostGetResponseDto getPost(Long postId) {
        PostGetMapping postGetMapping = postRepository.findByPostId(postId);

        if(postGetMapping == null) {

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
