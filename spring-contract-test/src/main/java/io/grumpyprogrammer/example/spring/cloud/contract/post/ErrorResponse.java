package io.grumpyprogrammer.example.spring.cloud.contract.post;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
class ErrorResponse {

    String message;

}
