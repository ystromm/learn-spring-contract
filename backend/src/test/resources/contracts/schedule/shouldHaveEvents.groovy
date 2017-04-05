package contracts.schedule

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/schedule'
        headers {
            contentType('application/json')
        }
    }
    response {
        status 200
        body([[
                      description: "Konsumentdrivna kontraktstester",
                      location   : "Ekerö",
                      speaker    : "Martin Carlsson"
              ],
              [
                      description: "State of the nation",
                      location   : "Adelsö",
                      speaker    : "Johan Malmliden"

              ]
        ])
        headers {
            contentType('application/json')
        }
    }

}