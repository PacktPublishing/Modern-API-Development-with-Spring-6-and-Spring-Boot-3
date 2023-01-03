package com.packt.modern.api.service;

import com.packt.modern.api.entity.OrderEntity;
import com.packt.modern.api.model.NewOrder;
import java.util.Optional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
public interface OrderService {

  Optional<OrderEntity> addOrder(@Valid NewOrder newOrder);
  Iterable<OrderEntity> getOrdersByCustomerId(@NotNull @Valid String customerId);
  Optional<OrderEntity> getByOrderId(String id);
}
