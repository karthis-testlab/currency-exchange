package com.ta.api.assessment.currency.exchange.currencyexchange.controllers;

import com.ta.api.assessment.currency.exchange.currencyexchange.models.ApplicationConfigModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/config")
public class ApplicationConfigController {

    @Value("${api.keys.orders.service}")
    private String orderServiceKey;

    @Value("${api.keys.accounts.service}")
    private String accountServiceKey;

    @Value("${db.hostname:dev.database.com}")
    private String dbHostName;

    @Value("${db.username}")
    private String dbUserName;

    @Value("${db.usercredentials}")
    private String dbUserCredentials;

    @Value("${db.connections}")
    private String dbNumberOfConnections;

    @Autowired
    private ApplicationConfigModel applicationConfig;

    @GetMapping("/keys/{service}")
    public String getApiServiceKey(@PathVariable String service) {
        if(service.equalsIgnoreCase("ORDER")) {
            return orderServiceKey;
        } else {
            return accountServiceKey;
        }
    }

    @GetMapping("/db/hostname")
    public String getDbHostName() {
        return dbHostName;
    }

    @GetMapping("/db/username")
    public String getDbUserName() {
        return dbUserName;
    }

    @GetMapping("/db/usercredentials")
    public String getDbUserCredentials() {
        return dbUserCredentials;
    }

    @GetMapping("/db/connections")
    public String getDbNumberOfConnections() {
        return dbNumberOfConnections;
    }

    @GetMapping("/db")
    public String getDbDetails() {
        return "| "+applicationConfig.getHostname()+" | "+applicationConfig.getUsername()+" | "+applicationConfig.getUsercredentials()+" | "+applicationConfig.getConnections()+" |";
    }

}