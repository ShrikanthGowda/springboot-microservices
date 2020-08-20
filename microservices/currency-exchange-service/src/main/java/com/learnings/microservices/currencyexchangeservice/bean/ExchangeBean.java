package com.learnings.microservices.currencyexchangeservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "exchange_value")
public class ExchangeBean {

  @Id
  private Long id;

  @Column(name = "currency_from")
  private String from;

  @Column(name = "currency_to")
  private String to;

  private BigDecimal conversionValue;

  private int port;

  public ExchangeBean() {
  }

  public ExchangeBean(Long id, String from, String to, BigDecimal conversionValue) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionValue = conversionValue;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public BigDecimal getConversionValue() {
    return conversionValue;
  }

  public void setConversionValue(BigDecimal conversionValue) {
    this.conversionValue = conversionValue;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
}
