package com.packt.modern.api.service;

import com.packt.modern.api.entity.ShipmentEntity;
import jakarta.validation.constraints.Min;
import reactor.core.publisher.Flux;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter05 - Modern API Development with Spring and Spring Boot Ed 2
 **/
public interface ShipmentService {
  Flux<ShipmentEntity> getShipmentByOrderId(@Min(value = 1L, message = "Invalid product ID.")  String id);
}
