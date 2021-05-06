package com.alwayslearn.blog.Comment;

import com.alwayslearn.blog.common.BaseControllerTest;
import com.alwayslearn.blog.contorller.request.AddCommentRequest;
import com.alwayslearn.blog.contorller.request.WritePostRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.restdocs.payload.JsonFieldType;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;

@DisplayName("댓글 열람 테스트")
public class GetCommentTest extends BaseControllerTest {

    @Test
    @DisplayName("댓글 열람 (성공)")
    void GetCommentSuccess() throws Exception {
        //Given
        AddCommentRequest addCommentRequest = new AddCommentRequest(1, "content");
        WritePostRequest writePostRequest = new WritePostRequest(1,"title", "subject");

        ResultActions postResultActions = this.mockMvc.perform(post("/boards/{boardId}/posts", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(writePostRequest))
        );

        ResultActions commentResultActions = this.mockMvc.perform(post("/boards/{boardId}/posts/{postId}/comments}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(addCommentRequest))
        );

        //When
        ResultActions postCheck = this.mockMvc.perform(get("/boards/{boardId}/posts", 1));
        ResultActions commentCheck = this.mockMvc.perform(get("/boards/{boardId}/posts/{postId}/comments}", 1));
                
        //Then
        postCheck.andExpect(status().isCreated());
        commentCheck.andExpect(status().isOk())

                .andExpect(jsonPath("userId").value(1))
                .andExpect(jsonPath("content").value("Content"))

                .andDo(document("get-comment",
                        requestFields(
                                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("유저 ID"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("댓글 내용")
                        ),
                        responseFields(
                                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("유저 ID"),
                                fieldWithPath("post").type(JsonFieldType.OBJECT).description("포스트"),
                                fieldWithPath("date").type(JsonFieldType.STRING).description("댓글 작성 날짜"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("댓글 내용"))
                        )
                );
    };
}
