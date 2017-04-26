package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/v2/event/1'
        headers {
        }
    }
    response {
        status 200
        body([
                id      : 1,
                speaker : 'Johan Malmliden',
                description: 'State of the Nation',
                location: 'Adelsö',
                start: '2017-01-19T18:36:51Z'

        ])
        headers {
            contentType('application/json')
        }
    }

}