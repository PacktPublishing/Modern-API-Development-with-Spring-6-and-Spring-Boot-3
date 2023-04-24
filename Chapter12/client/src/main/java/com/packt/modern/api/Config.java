package com.packt.modern.api;

import io.micrometer.core.instrument.binder.grpc.ObservationGrpcClientInterceptor;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
  @Bean
  public ObservationGrpcClientInterceptor interceptor(ObservationRegistry observationRegistry) {
    return new ObservationGrpcClientInterceptor(observationRegistry);
  }
}
