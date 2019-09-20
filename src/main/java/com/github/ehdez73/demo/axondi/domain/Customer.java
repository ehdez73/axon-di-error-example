package com.github.ehdez73.demo.axondi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Slf4j
@Data
@Builder @AllArgsConstructor @NoArgsConstructor
@Aggregate
public class Customer {

  @AggregateIdentifier
  private Long id;
  private String name;
  private String address;

  @CommandHandler
  public Customer(CreateCommand command, CustomerService customerService) {
    log.info( customerService.doSomething(command.getId(), command.getName()));
    AggregateLifecycle.apply(new CreatedEvent(command.getId(), command.getName()));
  }

  @CommandHandler
  public void on(UpdateCommand command, CustomerService customerService){
    log.info( customerService.doSomething(command.getId(), command.getAddress()));
    AggregateLifecycle.apply( new UpdatedEvent(command.getId(), command.getAddress()));
  }

  @EventSourcingHandler
  public void on(CreatedEvent event){
    this.id = event.getId();
    this.name = event.getName();
  }

  @EventSourcingHandler
  public void on(UpdatedEvent event){
    this.address = event.getAddress();
  }
}