package com.alwayslearn.blog.post;

import com.alwayslearn.blog.common.BaseControllerTest;
import com.alwayslearn.blog.contorller.request.UpdateCommentRequest;
import com.alwayslearn.blog.contorller.request.UpdatePostRequest;
import com.alwayslearn.blog.contorller.request.WritePostRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("댓글 수정 테스트")
public class UpdateCommentTest extends BaseControllerTest {

    @Test
    @DisplayName("댓글 수정(성공)")
    void updateCommentSuccess() throws Exception{
        //Given
        UpdateCommentRequest updateCommentRequest = new UpdateCommentRequest(1,"Subject");

        //When
        ResultActions resultActions = this.mockMvc.perform(post("/boards/{boardId}/posts/{postId}/comments/{commentId}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(updateCommentRequest))
        );
        //Then
        resultActions.andExpect(status().isCreated())

                .andExpect(jsonPath("userId").value(1))
                .andExpect(jsonPath("subject").value("Subject"))

                .andDo(document("update-comment",
                        requestFields(
                                fieldWithPath("subject").type(JsonFieldType.STRING).description("댓글 수정문"),
                                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("유저 ID")
                        ),
                        responseFields(
                                fieldWithPath("postId").type(JsonFieldType.NUMBER).description("포스트 ID"),
                                fieldWithPath("subject").type(JsonFieldType.STRING).description("포스트 본문"),
                                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("유저 ID"))
                        )
                )
        ;

    }
}
