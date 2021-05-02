package com.alwayslearn.blog.post;

import com.alwayslearn.blog.common.BaseControllerTest;
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

@DisplayName("포스트 수 테스트")
public class UpdatePostTest extends BaseControllerTest {

    @Test
    @DisplayName("포스트 수정(성공)")
    void updatePostSuccess() throws Exception{
        //Given
        UpdatePostRequest updatePostRequest = new UpdatePostRequest(1, "Title", "Subject");
        //When
        ResultActions resultActions = this.mockMvc.perform(post("/boards/{boardId}/posts",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(updatePostRequest))
        );
        //Then
        resultActions.andExpect(status().isCreated())정

                .andExpect(jsonPath("userId").value(1))
                .andExpect(jsonPath("title").value("Title"))
                .andExpect(jsonPath("subject").value("Subject"))
                .andExpect(jsonPath("commentNum").value(0))
                .andExpect(jsonPath("viewCount").value(0))

                .andDo(document("update-post",
                        requestFields(
                                fieldWithPath("title").type(JsonFieldType.STRING).description("포스트 제목"),
                                fieldWithPath("subject").type(JsonFieldType.STRING).description("포스트 본문"),
                                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("유저 ID")
                        ),
                        responseFields(
                                fieldWithPath("title").type(JsonFieldType.STRING).description("포스트 제목"),
                                fieldWithPath("postId").type(JsonFieldType.NUMBER).description("포스트 ID"),
                                fieldWithPath("subject").type(JsonFieldType.STRING).description("포스트 본문"),
                                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("유저 ID"),
                                fieldWithPath("createdDate").type(JsonFieldType.STRING).description("포스트 Date"),
                                fieldWithPath("commentNum").type(JsonFieldType.NUMBER).description("댓글 갯수"),
                                fieldWithPath("viewCount").type(JsonFieldType.NUMBER).description("조회수"))
                        )
                )
        ;

    }
}
