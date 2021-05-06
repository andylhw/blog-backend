package com.alwayslearn.blog.Comment;

import com.alwayslearn.blog.common.BaseControllerTest;
import com.alwayslearn.blog.contorller.request.AddCommentRequest;
import com.alwayslearn.blog.contorller.request.WritePostRequest;
import com.alwayslearn.blog.model.dto.ModifyCommentDto;
import com.alwayslearn.blog.model.dto.ModifyPostDto;
import com.alwayslearn.blog.service.CommentService;
import com.alwayslearn.blog.service.PostService;
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

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @Test
    @DisplayName("댓글 열람 (성공)")
    void GetCommentSuccess() throws Exception {
        //Given
        Long postId = postService.writePost((long)1, new ModifyPostDto(1, "제목", "내용")).getPostId();
        Long commentId = commentService.addComment(postId, new ModifyCommentDto((long)1, "content")).getId();

        //When
        ResultActions commentCheck = this.mockMvc.perform(get("/boards/{boardId}/posts/{postId}/comments/{commentId}", 1, postId, commentId));
                
        //Then
        commentCheck.andExpect(status().isOk())

                .andExpect(jsonPath("comments[0].userId").value(1))
                .andExpect(jsonPath("comments[0].content").value("content"))

                .andDo(document("get-comment",
                        responseFields(
                                fieldWithPath("comments[0].id").type(JsonFieldType.NUMBER).description("댓글 ID"),
                                fieldWithPath("comments[0].userId").type(JsonFieldType.NUMBER).description("유저 ID"),
                                fieldWithPath("comments[0].post.postId").type(JsonFieldType.NUMBER).description("포스트 ID"),
                                fieldWithPath("comments[0].post.userId").type(JsonFieldType.NUMBER).description("유저 ID"),
                                fieldWithPath("comments[0].post.title").type(JsonFieldType.STRING).description("제목"),
                                fieldWithPath("comments[0].post.subject").type(JsonFieldType.STRING).description("내용"),
                                fieldWithPath("comments[0].post.createdDate").type(JsonFieldType.STRING).description("날짜"),
                                fieldWithPath("comments[0].post.commentNum").type(JsonFieldType.NUMBER).description("댓글 수"),
                                fieldWithPath("comments[0].post.viewCount").type(JsonFieldType.NUMBER).description("조회수"),
                                fieldWithPath("comments[0].date").type(JsonFieldType.STRING).description("댓글 작성 날짜"),
                                fieldWithPath("comments[0].content").type(JsonFieldType.STRING).description("댓글 내용"))
                        )
                );
    };
}
