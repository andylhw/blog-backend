package com.alwayslearn.blog.comment;

import com.alwayslearn.blog.common.BaseControllerTest;
import com.alwayslearn.blog.contorller.request.AddCommentRequest;
import com.alwayslearn.blog.model.dto.ModifyPostDto;
import com.alwayslearn.blog.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Date;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("댓글 저장 테스트")
public class AddCommentTest extends BaseControllerTest {

    //private final PostService postService;

    @Autowired
    PostService postService;

    @Test
    @DisplayName("댓글 저장(성공)")
    void insertCommentSuccess() throws Exception{
        //Given
        Long postId = postService.writePost((long)1, new ModifyPostDto(1,"제목","내용")).getPostId();
        //WritePostRequest writePostRequest = new WritePostRequest(1,"title","subject");
        AddCommentRequest addCommentRequest = new AddCommentRequest(1, "content");
        //When
        ResultActions resultActions = this.mockMvc.perform(post("/boards/{boardsId}/posts/{postId}/comments",1,postId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(addCommentRequest))
        );
        //Then
        resultActions.andExpect(status().isOk())

                .andExpect(jsonPath("userId").value(1))
                .andExpect(jsonPath("content").value("content"))

                .andDo(document("add-comment",
                        requestFields(
                                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("유저 ID"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("댓글 내용")
                        ),
                        responseFields(
                                fieldWithPath("post.postId").type(JsonFieldType.NUMBER).description("보드 ID"),
                                fieldWithPath("post.userId").type(JsonFieldType.NUMBER).description("유저 ID"),
                                fieldWithPath("post.title").type(JsonFieldType.STRING).description("제목"),
                                fieldWithPath("post.subject").type(JsonFieldType.STRING).description("제목"),
                                fieldWithPath("post.createdDate").type(JsonFieldType.STRING).description("날짜"),
                                fieldWithPath("post.commentNum").type(JsonFieldType.NUMBER).description("제목"),
                                fieldWithPath("post.viewCount").type(JsonFieldType.NUMBER).description("제목"),
                                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("유저 ID"),
                                fieldWithPath("post").type(JsonFieldType.OBJECT).description("포스트"),
                                fieldWithPath("date").type(JsonFieldType.STRING).description("댓글 작성 날짜"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("댓글 내용"))
                        )
                )
        ;
    }

}