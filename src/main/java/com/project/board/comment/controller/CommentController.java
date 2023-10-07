package com.project.board.comment.controller;

import com.project.board.comment.dto.request.CommentCreateRequestDto;
import com.project.board.comment.dto.request.CommentUpdateRequestDto;
import com.project.board.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/comments/{commentId}")
    public ResponseEntity<Void> updateComment(@PathVariable Long commentId,
                                              @RequestBody @Valid CommentUpdateRequestDto requestDto) {
        commentService.updateComment(commentId, requestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}
