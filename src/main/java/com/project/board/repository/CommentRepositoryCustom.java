package com.project.board.repository;

import com.project.board.dto.response.CommentGetResponseDto;

import java.util.List;
import java.util.Map;

public interface CommentRepositoryCustom {

    List<CommentGetResponseDto> findParentByPostId(Long postId);

    Map<Long, List<CommentGetResponseDto>> findChildByParentId(List<Long> parentId);
}
