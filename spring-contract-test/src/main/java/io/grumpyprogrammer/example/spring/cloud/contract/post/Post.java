package io.grumpyprogrammer.example.spring.cloud.contract.post;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Post {

    private Integer id;

    private String name;

}
