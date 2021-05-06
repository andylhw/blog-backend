package com.alwayslearn.blog.Post;


import com.alwayslearn.blog.common.BaseControllerTest;
import com.alwayslearn.blog.contorller.request.WritePostRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("포스트 저장 테스트")
public class AddPostTest extends BaseControllerTest {


    @Test
    @DisplayName("포스트 저장 (성공)")
    void insertPostSuccess() throws Exception {
        //Given
        WritePostRequest writePostRequest = new WritePostRequest(1,"title", "subject");

        //When
        ResultActions resultActions = this.mockMvc.perform(post("/boards/{boardId}/posts", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(writePostRequest)));

        //Then
        resultActions.andExpect(status().isCreated())
                .andExpect(jsonPath("postId").value(1))
                .andExpect(jsonPath("userId").value(1))
                .andExpect(jsonPath("title").value("title"))
                .andExpect(jsonPath("subject").value("subject"))
                .andExpect(jsonPath("commentNum").value(0))
                .andExpect(jsonPath("viewCount").value(0));
    };

}
