package com.project.board.comment.service;

import com.project.board.comment.dto.request.CommentCreateRequestDto;
import com.project.board.comment.domain.Comment;
import com.project.board.comment.exception.CommentNotFoundException;
import com.project.board.comment.repository.CommentRepository;
import com.project.board.member.domain.Member;
import com.project.board.member.exception.MemberNotFoundException;
import com.project.board.member.repository.MemberRepository;
import com.project.board.post.domain.Post;
import com.project.board.post.exception.PostNotFoundException;
import com.project.board.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void createComment(CommentCreateRequestDto requestDto) {

        Member member = memberRepository.findById(requestDto.getMemberId()).orElseThrow(MemberNotFoundException::new);

        Post post = postRepository.findById(requestDto.getPostId()).orElseThrow(PostNotFoundException::new);

        Comment comment;

        if (requestDto.getParentId() == null || "".equals(requestDto.getParentId())) {
            comment = Comment.builder()
                    .content(requestDto.getContent())
                    .member(member)
                    .post(post)
                    .build();
        } else {
            Comment parentComment = commentRepository.findById(requestDto.getParentId()).orElseThrow(CommentNotFoundException::new);

            comment = Comment.builder()
                    .content(requestDto.getContent())
                    .member(member)
                    .post(post)
                    .parent(parentComment)
                    .build();
        }
        commentRepository.save(comment);
    }
}
