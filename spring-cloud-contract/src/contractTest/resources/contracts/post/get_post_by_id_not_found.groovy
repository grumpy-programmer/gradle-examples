package contracts.post

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should return not found error'

    request {
        url '/posts/100'
        method GET()
    }

    response {
        status NOT_FOUND()
        headers {
            contentType applicationJson()
        }
        body(
                message: 'Post with id 100 not found'
        )
    }
}
