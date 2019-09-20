package com.github.ehdez73.demo.axondi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data @AllArgsConstructor
@NoArgsConstructor
public class UpdateCommand {
  @TargetAggregateIdentifier
  private Long id;
  private String address;
}
