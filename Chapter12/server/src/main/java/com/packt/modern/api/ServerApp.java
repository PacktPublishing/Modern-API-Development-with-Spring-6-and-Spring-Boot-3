package com.packt.modern.api;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ServerApp {
  public static void main(String[] args) {
    new SpringApplicationBuilder(ServerApp.class).web(WebApplicationType.NONE).run(args);
  }
}
