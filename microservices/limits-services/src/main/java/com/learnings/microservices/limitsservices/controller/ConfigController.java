package com.learnings.microservices.limitsservices.controller;

import com.learnings.microservices.limitsservices.Configuration;
import com.learnings.microservices.limitsservices.bean.ConfigurationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

  @Autowired
  private Configuration configuration;

  @GetMapping("/config")
  public ConfigurationBean fetchLimitsServiceConfig() {

    return new ConfigurationBean(configuration.getMaximum(), configuration.getMinimum());
  }
}
