package com.project.board.post.controller;

import com.project.board.post.controller.dto.PostCreateRequestDto;
import com.project.board.post.service.dto.PostCreateResponseDto;
import com.project.board.post.service.dto.PostGetResponseDto;
import com.project.board.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<Void> createPost(@RequestBody @Valid PostCreateRequestDto requestDto) {
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
