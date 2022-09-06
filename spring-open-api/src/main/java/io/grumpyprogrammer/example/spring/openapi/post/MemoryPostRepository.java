package io.grumpyprogrammer.example.spring.openapi.post;

import io.grumpyprogrammer.example.spring.openapi.api.dto.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryPostRepository implements PostRepository {

    private final Map<String, Post> data = new ConcurrentHashMap<>();

    @Override
    public List<Post> findAll() {
        return data.values().stream().toList();
    }

    @Override
    public Optional<Post> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public Post save(Post post) {
        if (post.getId() == null) {
            post.setId(UUID.randomUUID().toString());
        }

        data.put(post.getId(), post);

        return post;
    }

    @Override
    public Optional<Post> delete(String id) {
        return Optional.ofNullable(data.remove(id));
    }

}
