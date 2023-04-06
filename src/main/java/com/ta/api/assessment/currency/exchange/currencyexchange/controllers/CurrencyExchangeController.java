package com.ta.api.assessment.currency.exchange.currencyexchange.controllers;

import com.ta.api.assessment.currency.exchange.currencyexchange.exceptions.CurrencyCodeNotFoundException;
import com.ta.api.assessment.currency.exchange.currencyexchange.models.CurrencyExchangeModel;
import com.ta.api.assessment.currency.exchange.currencyexchange.services.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CurrencyExchangeController {

    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchangeModel> getCurrencyExchange(@PathVariable String from, @PathVariable String to) {
        CurrencyExchangeModel response = currencyExchangeService.getCurrencyExchangeByTwoCountreis(from, to);
        if(response == null) {
            throw new CurrencyCodeNotFoundException("Given currency code was not found in the our database");
        } else {
            return ResponseEntity.ok().body(currencyExchangeService.getCurrencyExchangeByTwoCountreis(from, to));
        }
    }

}