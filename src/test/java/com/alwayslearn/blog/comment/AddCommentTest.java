package com.alwayslearn.blog.comment;

import com.alwayslearn.blog.common.BaseControllerTest;
import com.alwayslearn.blog.contorller.request.AddCommentRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("댓글 저장 테스트")
public class AddCommentTest extends BaseControllerTest {

    @Test
    @DisplayName("댓글 저장(성공)")
    void insertCommentSuccess() throws Exception{
        //Given
        AddCommentRequest addCommentRequest = new AddCommentRequest(1, "content");
        //When
        ResultActions resultActions = this.mockMvc.perform(post("/boards/{boardsId}/posts/{postId}/comments",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(addCommentRequest))
        );
        //Then
        resultActions.andExpect(status().isCreated())

                .andExpect(jsonPath("userId").value(1))
                .andExpect(jsonPath("content").value("Content"))

                .andDo(document("add-comment",
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
                )
        ;
    }

}