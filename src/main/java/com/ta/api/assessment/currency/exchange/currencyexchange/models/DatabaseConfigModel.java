package com.ta.api.assessment.currency.exchange.currencyexchange.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("db")
@Data
@Component
public class DatabaseConfigModel {

    private String hostname;
    private String username;
    private String usercredentials;
    private String connections;

}