package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        headers {
        }
        url '/event'
    }
    response {
        status 200
        headers {
            contentType('application/json')
        }
        body([[
                      id         : 1,
                      speaker    : 'Johan Malmliden',
                      description: 'State of the Nation',
                      location   : 'Adelsö'

              ],
              [
                      id         : 2,
                      speaker    : 'Martin Carlsson',
                      description: 'Konsumentdrivna kontraktstester',
                      location   : 'Färingsö'
              ],
              [
                      id         : 3,
                      speaker    : 'Fredrik Löfgren',
                      description: 'Att bygga en speldator',
                      location   : 'Lovö'
              ]])
    }

}