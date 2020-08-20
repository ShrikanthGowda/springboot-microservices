package com.learnings.microservices.currencyexchangeservice.controller;

import com.learnings.microservices.currencyexchangeservice.bean.ExchangeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

  @Autowired
  private Environment environment;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeBean fetchExchangeValue(@PathVariable String from, @PathVariable String to) {

    ExchangeBean exchangeBean = new ExchangeBean(1000L, from, to, BigDecimal.valueOf(75));
    exchangeBean.setPort(Integer.valueOf(environment.getProperty("server.port")));
    return exchangeBean;
  }
}
