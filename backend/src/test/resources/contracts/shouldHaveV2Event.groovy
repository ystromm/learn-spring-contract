package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/event/1'
        headers {
        }
    }
    response {
        status 200
        body([
                id      : 1,
                speaker : 'Johan Malmliden',
                description: 'State of the Nation',
                location: 'Adelsö'
        ])
        headers {
            contentType('application/json')
        }
    }

}