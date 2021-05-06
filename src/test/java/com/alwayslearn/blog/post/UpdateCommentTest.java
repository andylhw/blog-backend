package com.alwayslearn.blog.post;

import com.alwayslearn.blog.common.BaseControllerTest;
import com.alwayslearn.blog.contorller.request.UpdateCommentRequest;
import com.alwayslearn.blog.contorller.request.UpdatePostRequest;
import com.alwayslearn.blog.contorller.request.WritePostRequest;
import com.alwayslearn.blog.model.dto.ModifyCommentDto;
import com.alwayslearn.blog.model.dto.ModifyPostDto;
import com.alwayslearn.blog.service.CommentService;
import com.alwayslearn.blog.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("댓글 수정 테스트")
public class UpdateCommentTest extends BaseControllerTest {

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @Test
    @DisplayName("댓글 수정(성공)")
    void updateCommentSuccess() throws Exception{
        //Given
        Long postId = postService.writePost((long)1, new ModifyPostDto(1, "제목", "내용")).getPostId();
        Long commentId = commentService.addComment(postId, new ModifyCommentDto((long)1, "댓글내용")).getId();
        UpdateCommentRequest updateCommentRequest = new UpdateCommentRequest(1,"Subject");

        //When
        ResultActions resultActions = this.mockMvc.perform(put("/boards/{boardId}/posts/{postId}/comments/{commentId}",1, postId, commentId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(updateCommentRequest))
        );
        //Then
        resultActions.andExpect(status().isOk())

                .andExpect(jsonPath("userId").value(1))
                .andExpect(jsonPath("content").value("Subject"))

                .andDo(document("update-comment",
                        requestFields(
                                fieldWithPath("content").type(JsonFieldType.STRING).description("댓글 수정문"),
                                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("유저 ID")
                        ),
                        responseFields(
                                fieldWithPath("post.postId").type(JsonFieldType.NUMBER).description("포스트 ID"),
                                fieldWithPath("post.userId").type(JsonFieldType.NUMBER).description("포스트 ID"),
                                fieldWithPath("post.title").type(JsonFieldType.STRING).description("포스트 ID"),
                                fieldWithPath("post.subject").type(JsonFieldType.STRING).description("포스트 ID"),
                                fieldWithPath("post.createdDate").type(JsonFieldType.STRING).description("포스트 ID"),
                                fieldWithPath("post.commentNum").type(JsonFieldType.NUMBER).description("포스트 ID"),
                                fieldWithPath("post.viewCount").type(JsonFieldType.NUMBER).description("포스트 ID"),
                                fieldWithPath("date").type(JsonFieldType.STRING).description("포스트 ID"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("포스트 본문"),
                                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("유저 ID"))
                        )
                )
        ;

    }
}
