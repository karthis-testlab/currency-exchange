package com.ta.api.assessment.currency.exchange.currencyexchange;

import com.ta.api.assessment.currency.exchange.currencyexchange.models.CurrencyExchangeModel;
import com.ta.api.assessment.currency.exchange.currencyexchange.repository.CurrencyExchangeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CurrencyExchangeRepositoryTest {

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @Test
    public void should_get_currency_for_usd_to_inr() {
        CurrencyExchangeModel repsone = currencyExchangeRepository
                                      .findByCurrencyFromAndCurrencyTo("USD", "INR");
        Assertions.assertEquals(82.18, repsone.getConvertionMultiple());
    }

    @Test
    public void should_get_currency_for_gbp_to_inr() {
        CurrencyExchangeModel response= currencyExchangeRepository
                .findByCurrencyFromAndCurrencyTo("GBP", "INR");
        Assertions.assertEquals(101.45, response.getConvertionMultiple());
    }

    @Test
    public void should_get_currency_for_huf_to_inr() {
        CurrencyExchangeModel testData = CurrencyExchangeModel.builder().id(3).convertionMultiple(0.23).currencyFrom("HUF").currencyTo("INR").build();
        currencyExchangeRepository.save(testData);
        CurrencyExchangeModel response = currencyExchangeRepository
                .findByCurrencyFromAndCurrencyTo("HUF", "INR");
        Assertions.assertEquals(0.23, response.getConvertionMultiple());
    }


}
