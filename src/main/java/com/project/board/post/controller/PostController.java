package com.project.board.post.controller;

import com.project.board.post.dto.request.PostCreateRequestDto;
import com.project.board.post.dto.request.PostGetListRequestDto;
import com.project.board.post.dto.request.PostUpdateRequestDto;
import com.project.board.post.dto.response.PostCreateResponseDto;
import com.project.board.post.dto.response.PostGetListResponseDto;
import com.project.board.post.dto.response.PostGetOneResponseDto;
import com.project.board.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
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

    @GetMapping("/posts")
    public ResponseEntity<PostGetListResponseDto> getPostList(PostGetListRequestDto requestDto) {
        return ResponseEntity.ok(postService.getPostList(requestDto));
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostGetOneResponseDto> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @PatchMapping("/posts/{postId}")
    public ResponseEntity<Void> updatePost(@PathVariable Long postId,
                                           @RequestBody @Valid PostUpdateRequestDto requestDto) {
        postService.updatePost(postId, requestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}
