package com.project.board.service;

import com.project.board.common.util.DateFormatUtil;
import com.project.board.dto.request.PostCreateRequestDto;
import com.project.board.dto.response.PostCreateResponseDto;
import com.project.board.dto.response.PostGetResponseDto;
import com.project.board.entity.Member;
import com.project.board.entity.Post;
import com.project.board.repository.MemberRepository;
import com.project.board.repository.PostRepository;
import com.project.board.repository.mapping.PostGetMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

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

        return PostGetResponseDto.builder()
                .postId(postGetMapping.getPostId())
                .title(postGetMapping.getTitle())
                .content(postGetMapping.getContent())
                .postCategory(postGetMapping.getPostCategory())
                .memberId(postGetMapping.getMemberMemberId())
                .nickname(postGetMapping.getMemberNickname())
                .createdDateTime(DateFormatUtil.toDateTime(postGetMapping.getCreatedDateTime()))
                .build();
    }
}
