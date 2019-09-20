package com.github.ehdez73.demo.axondi.domain;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerTest {

  @Mock
  private CustomerService customerService;
  private FixtureConfiguration<Customer> fixture;

  @Before
  public void setUp() {
    fixture = new AggregateTestFixture<>(Customer.class);
    fixture.registerInjectableResource(customerService);
  }

  @Test
  public void testCreation(){

    final Long id = 1L;
    final String name = "Elmo";
    when(customerService.doSomething(id, name)).thenReturn("just called");

    fixture.givenNoPriorActivity()
            .when(new CreateCommand(id, name))
            .expectEvents(new CreatedEvent(id, name));

    verify(customerService).doSomething(id, name);
    verifyNoMoreInteractions(customerService);
  }

  @Test
  public void testUpdate(){

    final Long id = 1L;
    final String name = "Elmo";
    final String address = "Sesame street";

    when(customerService.doSomething(id,name)).thenReturn("called");

    fixture.givenState(() -> new Customer(id, name, null))
            .when(new UpdateCommand(id, address))
            .expectEvents(new UpdatedEvent(id, address));

    verify(customerService).doSomething(id,address);
    verifyNoMoreInteractions(customerService);
  }
}
