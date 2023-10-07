package com.project.board.comment.repository;

import com.project.board.comment.dto.response.CommentGetResponseDto;

import java.util.List;
import java.util.Map;

public interface CommentRepositoryCustom {

    List<CommentGetResponseDto> findParentByPostId(Long postId);

    Map<Long, List<CommentGetResponseDto>> findChildByParentId(List<Long> parentId);
}
