package com.securepay;

import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {
  @Bean
  public PhysicalNamingStrategy getPhysicalNamingStrategy() {
    return new PhysicalNamingStrategyStandardImpl();
  }
}
