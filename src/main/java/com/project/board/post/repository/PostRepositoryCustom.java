package com.project.board.post.repository;

import com.project.board.post.dto.request.PostGetListRequestDto;
import com.project.board.post.dto.response.PostGetResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepositoryCustom {

    Page<PostGetResponseDto> getPostList(PostGetListRequestDto requestDto, Pageable pageable);
}
