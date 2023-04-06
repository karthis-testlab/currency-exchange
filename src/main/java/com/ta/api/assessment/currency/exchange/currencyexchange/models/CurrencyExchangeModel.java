package com.ta.api.assessment.currency.exchange.currencyexchange.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="currency_exchange")
@JsonPropertyOrder({
        "id",
        "convertion_multiple",
        "currency_from",
        "currency_to"
})
public class CurrencyExchangeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_id")
    @SequenceGenerator(initialValue = 3, name = "auto_id")
    private int id;

    @JsonProperty("convertion_multiple")
    private double convertionMultiple;

    @JsonProperty("currency_from")
    private String currencyFrom;

    @JsonProperty("currency_to")
    private String currencyTo;

}