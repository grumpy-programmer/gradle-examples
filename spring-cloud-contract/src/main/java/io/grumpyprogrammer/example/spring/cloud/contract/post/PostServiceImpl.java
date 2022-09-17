package io.grumpyprogrammer.example.spring.cloud.contract.post;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class PostServiceImpl implements PostService {

    @Override
    public Optional<Post> getById(Integer id) {
        return Optional.of(Post.builder().id(id).name("Post " + id).build());
    }

}
