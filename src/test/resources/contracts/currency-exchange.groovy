import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description(""" Contract definition for the currency-exchange application """)
    name("should_return_the_inr_currency_for_usd")
    priority(1)
    request {
        method(GET())
        url("/api/currency-exchange/from/USD/to/INR")
    }
    response {
        status(200)
        status(OK())
        body('''
              {
                "id": 1,
                "convertion_multiple": 82.18,
                "currency_from": "USD",
                "currency_to": "INR"
              }
             ''')
    }
}