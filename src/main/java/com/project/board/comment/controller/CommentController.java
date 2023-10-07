package com.project.board.comment.controller;

import com.project.board.comment.controller.dto.CommentCreateRequestDto;
import com.project.board.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    public ResponseEntity<Void> createComment(@RequestBody @Valid CommentCreateRequestDto requestDto) {
        commentService.createComment(requestDto);
        return ResponseEntity.ok().build();
    }
}
