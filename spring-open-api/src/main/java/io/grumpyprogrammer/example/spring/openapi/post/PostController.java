package io.grumpyprogrammer.example.spring.openapi.post;

import io.grumpyprogrammer.example.spring.openapi.api.PostsApi;
import io.grumpyprogrammer.example.spring.openapi.api.dto.Post;
import io.grumpyprogrammer.example.spring.openapi.api.dto.PostCreate;
import io.grumpyprogrammer.example.spring.openapi.api.dto.PostUpdate;
import io.grumpyprogrammer.example.spring.openapi.common.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController implements PostsApi {

    private final PostRepository repository;

    @Override
    public ResponseEntity<Post> createPost(PostCreate postCreate) {
        Post post = repository.save(new Post().title(postCreate.getTitle()));

        return ResponseEntity.created(URI.create("/posts/" + post.getId())).body(post);
    }

    @Override
    public ResponseEntity<Void> deletePostById(String postId) {
        return repository.delete(postId)
                .map(post -> ResponseEntity.status(HttpStatus.NO_CONTENT).<Void>build())
                .orElseThrow(() -> new NotFoundException(postId, "post not found"));
    }

    @Override
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Override
    public ResponseEntity<Post> getPostById(String postId) {
        return repository.findById(postId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException(postId, "post not found"));
    }

    @Override
    public ResponseEntity<Post> updatePostById(String postId, PostUpdate postUpdate) {
        return repository.findById(postId)
                .map(post -> post.title(postUpdate.getTitle()))
                .map(repository::save)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException(postId, "post not found"));
    }


}
