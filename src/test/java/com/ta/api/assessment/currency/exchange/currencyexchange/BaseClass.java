package com.ta.api.assessment.currency.exchange.currencyexchange;

import com.ta.api.assessment.currency.exchange.currencyexchange.controllers.CurrencyExchangeController;
import com.ta.api.assessment.currency.exchange.currencyexchange.models.CurrencyExchangeModel;
import com.ta.api.assessment.currency.exchange.currencyexchange.services.CurrencyExchangeService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BaseClass {

    @Autowired
    CurrencyExchangeController currencyExchangeControllers;

    @MockBean
    CurrencyExchangeService currencyExchangeService;

    @BeforeEach
    public void setUp() {

        CurrencyExchangeModel currencyExchange = CurrencyExchangeModel.builder()
                                                 .id(1)
                                                 .convertionMultiple(82.18)
                                                 .currencyFrom("USD")
                                                 .currencyTo("INR")
                                                 .build();

        RestAssuredMockMvc.standaloneSetup(currencyExchangeControllers);

        Mockito.when(currencyExchangeService.getCurrencyExchangeByTwoCountreis("USD", "INR"))
                .thenReturn(currencyExchange);

    }

}