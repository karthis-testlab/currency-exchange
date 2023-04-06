package com.ta.api.assessment.currency.exchange.currencyexchange.repository;

import com.ta.api.assessment.currency.exchange.currencyexchange.models.CurrencyExchangeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeModel, Integer> {

    CurrencyExchangeModel findByCurrencyFromAndCurrencyTo(String currencyFrom, String currencyTo);

}