package com.github.ehdez73.demo.axondi.domain;

import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {

  @Override
  public String doSomething(Long customerId, String name) {
    // Just simulates some domain business logic
    return String.format("Hello %d:%s", customerId, name);
  }
}
