package com.github.ehdez73.demo.axondi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CreatedEvent {
  private Long id;
  private String name;
}
