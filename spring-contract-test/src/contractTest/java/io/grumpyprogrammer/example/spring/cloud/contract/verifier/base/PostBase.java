package io.grumpyprogrammer.example.spring.cloud.contract.verifier.base;

import io.grumpyprogrammer.example.spring.cloud.contract.post.Post;
import io.grumpyprogrammer.example.spring.cloud.contract.post.PostRestController;
import io.grumpyprogrammer.example.spring.cloud.contract.post.PostService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

@WebMvcTest(PostRestController.class)
public class PostBase {

    @MockBean
    private PostService service;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.webAppContextSetup(context);

        given(service.getById(eq(1))).willReturn(Optional.of(Post.builder().id(1).name("Post 1").build()));
        given(service.getById(eq(100))).willReturn(Optional.empty());
    }

}
