package com.github.ehdez73.demo.axondi;

import com.github.ehdez73.demo.axondi.domain.CreateCommand;
import com.github.ehdez73.demo.axondi.domain.UpdateCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AxonDiApplication implements ApplicationRunner {

  @Autowired
  private CommandGateway commandGateway;

  public static void main(String[] args) {
    SpringApplication.run(AxonDiApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    commandGateway.send(new CreateCommand(1L, "Elmo"));
    commandGateway.send(new UpdateCommand(1L, "Sesame Street"));
    // Just wait for command execution finish
    Thread.sleep(2000);
  }
}
