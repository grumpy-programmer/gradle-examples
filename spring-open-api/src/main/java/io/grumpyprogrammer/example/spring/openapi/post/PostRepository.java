package io.grumpyprogrammer.example.spring.openapi.post;

import io.grumpyprogrammer.example.spring.openapi.api.dto.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    List<Post> findAll();

    Optional<Post> findById(String id);

    Post save(Post post);

    Optional<Post> delete(String id);
}
