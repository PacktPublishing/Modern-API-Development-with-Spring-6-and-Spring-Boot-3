package com.packt.modern.api.scalar;

import static graphql.scalars.ExtendedScalars.DateTime;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsRuntimeWiring;
import graphql.schema.idl.RuntimeWiring;

/**
 * @author : github.com/sharmasourabh
 * @project : chapter14 - Modern API Development with Spring and Spring Boot Ed 2
 **/
@DgsComponent
public class DateTimeScalar {

  @DgsRuntimeWiring
  public RuntimeWiring.Builder addScalar(RuntimeWiring.Builder builder) {
    return builder.scalar(DateTime);
  }
}
