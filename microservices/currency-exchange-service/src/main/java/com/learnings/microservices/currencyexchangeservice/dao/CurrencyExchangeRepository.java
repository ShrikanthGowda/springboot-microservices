package com.learnings.microservices.currencyexchangeservice.dao;

import com.learnings.microservices.currencyexchangeservice.bean.ExchangeBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeBean, Long> {

  Optional<ExchangeBean> findByFromAndTo(String from, String to);
}
