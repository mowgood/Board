package com.project.board.post.repository;

import com.project.board.post.controller.dto.PostGetListRequestDto;
import com.project.board.post.service.dto.PostGetResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepositoryCustom {

    Page<PostGetResponseDto> getPostList(PostGetListRequestDto requestDto, Pageable pageable);
}
