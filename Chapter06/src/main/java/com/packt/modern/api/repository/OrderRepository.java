package com.packt.modern.api.repository;

import com.packt.modern.api.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter06 - Modern API Development with Spring and Spring Boot Ed 2
 */
@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, UUID>, OrderRepositoryExt {

  @Query("select o from OrderEntity o join o.userEntity u where u.id = :customerId")
  Iterable<OrderEntity> findByCustomerId(@Param("customerId") UUID customerId);
}
