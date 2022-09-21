package contracts.post

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should return post by id=1'

    request {
        url '/posts/1'
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                id: 1,
                name: 'Post 1'
        )
    }
}
