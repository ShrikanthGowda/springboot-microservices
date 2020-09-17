package com.learnings.microservices.currencyexchangeservice.controller;

import com.learnings.microservices.currencyexchangeservice.bean.ExchangeBean;
import com.learnings.microservices.currencyexchangeservice.dao.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class CurrencyExchangeController {

  @Autowired
  private Environment environment;

  @Autowired
  private CurrencyExchangeRepository currencyExchangeRepository;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeBean fetchExchangeValue(@PathVariable String from, @PathVariable String to) {

    Optional<ExchangeBean> optionalBean = currencyExchangeRepository.findByFromAndTo(from, to);
    if(optionalBean.isPresent()) {
      ExchangeBean exchangeBean = optionalBean.get();
      exchangeBean.setPort(Integer.valueOf(environment.getProperty("server.port")));
      return exchangeBean;
    }

    return null;
  }
}
