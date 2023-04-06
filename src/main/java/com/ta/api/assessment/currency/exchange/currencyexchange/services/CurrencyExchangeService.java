package com.ta.api.assessment.currency.exchange.currencyexchange.services;

import com.ta.api.assessment.currency.exchange.currencyexchange.models.CurrencyExchangeModel;
import com.ta.api.assessment.currency.exchange.currencyexchange.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

       @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;
    public CurrencyExchangeModel getCurrencyExchangeByTwoCountreis(String from, String to) {
        return  currencyExchangeRepository.findByCurrencyFromAndCurrencyTo(from, to);
    }
}
