package com.project.board.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.board.member.domain.Member;
import com.project.board.member.enumeration.MemberStatus;
import com.project.board.member.enumeration.Role;
import com.project.board.member.repository.MemberRepository;
import com.project.board.post.domain.Post;
import com.project.board.post.dto.request.PostCreateRequestDto;
import com.project.board.post.enumeration.PostCategory;
import com.project.board.post.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private MemberRepository memberRepository;

    private static Member member;

    @BeforeEach
    void setUp() {
        postRepository.deleteAll();

        memberRepository.deleteAll();

        member = Member.builder()
                .name("홍길동")
                .nickname("스폰지밥")
                .email("sss@board.board")
                .password("1234")
                .role(Role.MEMBER)
                .status(MemberStatus.ACTIVE)
                .passwordValidatedDate(LocalDateTime.now())
                .blockCount(0)
                .build();

        memberRepository.save(member);
    }

    @Test
    @DisplayName("게시글 작성 시 새로 생성한 리소스 관련 주소를 응답한다.")
    void test() throws Exception {
        // given
        PostCreateRequestDto requestDto = PostCreateRequestDto.builder()
                .title("게시글 제목")
                .content("게시글 내용")
                .postCategory(PostCategory.DEV)
                .memberId(member.getMemberId())
                .build();

        String json = objectMapper.writeValueAsString(requestDto);

        // expected
        mockMvc.perform(post("/posts")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(header().string(HttpHeaders.LOCATION, "http://localhost/posts/1"))
                .andDo(print());

        postRepository.deleteAll();
    }

    @Test
    @DisplayName("게시글 작성 시 제목을 필수로 입력해야 한다.")
    void test2() throws Exception {
        // given
        PostCreateRequestDto requestDto = PostCreateRequestDto.builder()
                .content("게시글 내용")
                .postCategory(PostCategory.DEV)
                .memberId(member.getMemberId())
                .build();

        String json = objectMapper.writeValueAsString(requestDto);

        // expected
        mockMvc.perform(post("/posts")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.statusCode").value("400"))
                .andExpect(jsonPath("$.message").value("제목을 입력하세요."))
                .andDo(print());
    }

    @Test
    @DisplayName("게시글 작성 시 내용을 필수로 입력해야 한다.")
    void test3() throws Exception {
        // given
        PostCreateRequestDto requestDto = PostCreateRequestDto.builder()
                .title("게시글 제목")
                .postCategory(PostCategory.DEV)
                .memberId(member.getMemberId())
                .build();

        String json = objectMapper.writeValueAsString(requestDto);

        // expected
        mockMvc.perform(post("/posts")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.statusCode").value("400"))
                .andExpect(jsonPath("$.message").value("내용을 입력하세요."))
                .andDo(print());
    }

    @Test
    @DisplayName("게시글 작성 시 존재하지 않는 멤버인 경우 실패한다.")
    void test4() throws Exception {
        // given
        PostCreateRequestDto requestDto = PostCreateRequestDto.builder()
                .title("게시글 제목")
                .content("게시글 내용")
                .postCategory(PostCategory.DEV)
                .memberId(member.getMemberId())
                .build();

        memberRepository.deleteById(member.getMemberId());

        String json = objectMapper.writeValueAsString(requestDto);

        // expected
        mockMvc.perform(post("/posts")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.statusCode").value("404"))
                .andExpect(jsonPath("$.message").value("유효하지 않은 회원입니다."))
                .andDo(print());
    }

    @Test
    @DisplayName("게시글 작성 시 DB에 값이 저장된다.")
    void test5() throws Exception {
        // given
        PostCreateRequestDto requestDto = PostCreateRequestDto.builder()
                .title("게시글 제목")
                .content("게시글 내용")
                .postCategory(PostCategory.DEV)
                .memberId(member.getMemberId())
                .build();

        String json = objectMapper.writeValueAsString(requestDto);

        // when
        mockMvc.perform(post("/posts")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(header().string(HttpHeaders.LOCATION, "http://localhost/posts/2"))
                .andDo(print());

        // then
        assertEquals(1L, postRepository.count());

        Post post = postRepository.findAll().get(0);
        assertEquals("게시글 제목", post.getTitle());
        assertEquals("게시글 내용", post.getContent());
        assertEquals(PostCategory.DEV, post.getPostCategory());
        assertEquals(member.getMemberId(), post.getMember().getMemberId());
    }

}