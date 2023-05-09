package com.packt.modern.api.instrumentation;

import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.tracing.TracingInstrumentation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InstrumentationConfig {
  @Bean
  @ConditionalOnProperty( prefix = "graphql.tracing", name = "enabled", matchIfMissing = true)
  public Instrumentation tracingInstrumentation(){
    return new TracingInstrumentation();
  }
}
