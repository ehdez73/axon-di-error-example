package com.github.ehdez73.demo.axondi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CreateCommand {
 private Long id;
 private String name;
}
