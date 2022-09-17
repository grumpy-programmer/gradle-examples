package io.grumpyprogrammer.example.spring.cloud.contract.post;

import java.util.Optional;

public interface PostService {
    Optional<Post> getById(Integer id);
}
