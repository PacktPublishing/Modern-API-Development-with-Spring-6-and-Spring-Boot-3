package com.packt.modern.api.service;

import com.packt.modern.api.entity.ShipmentEntity;
import com.packt.modern.api.repository.ShipmentRepository;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter06 - Modern API Development with Spring and Spring Boot Ed 2
 */
@Service
public class ShipmentServiceImpl implements ShipmentService {

  private final ShipmentRepository repository;

  public ShipmentServiceImpl(ShipmentRepository repository) {
    this.repository = repository;
  }

  @Override
  public Iterable<ShipmentEntity> getShipmentByOrderId(
      @Min(value = 1L, message = "Invalid shipment ID.") String id) {
    return repository.findAllById(List.of(UUID.fromString(id)));
  }
}
