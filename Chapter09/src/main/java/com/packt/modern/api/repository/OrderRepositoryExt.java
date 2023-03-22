package com.packt.modern.api.repository;

import com.packt.modern.api.entity.OrderEntity;
import com.packt.modern.api.model.NewOrder;

import java.util.Optional;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter09 - Modern API Development with Spring and Spring Boot Ed 2
 */
public interface OrderRepositoryExt {
  Optional<OrderEntity> insert(NewOrder m);
}
