package com.project.board.controller;

import com.project.board.dto.request.PostCreateRequestDto;
import com.project.board.dto.response.PostCreateResponseDto;
import com.project.board.dto.response.PostGetResponseDto;
import com.project.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<Void> createPost(@RequestBody PostCreateRequestDto requestDto) {
        PostCreateResponseDto responseDto = postService.createPost(requestDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{postId}")
                .buildAndExpand(responseDto.getCreatedId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostGetResponseDto> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPost(postId));
    }
}
