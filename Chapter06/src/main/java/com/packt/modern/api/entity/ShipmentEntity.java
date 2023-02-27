package com.packt.modern.api.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter06 - Modern API Development with Spring and Spring Boot Ed 2
 */
@Entity
@Table(name = "shipment")
public class ShipmentEntity {
  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "EST_DELIVERY_DATE")
  private Timestamp estDeliveryDate;

  @Column(name = "CARRIER")
  private String carrier;

  public UUID getId() {
    return id;
  }

  public ShipmentEntity setId(UUID id) {
    this.id = id;
    return this;
  }

  public Timestamp getEstDeliveryDate() {
    return estDeliveryDate;
  }

  public ShipmentEntity setEstDeliveryDate(Timestamp estDeliveryDate) {
    this.estDeliveryDate = estDeliveryDate;
    return this;
  }

  public String getCarrier() {
    return carrier;
  }

  public ShipmentEntity setCarrier(String carrier) {
    this.carrier = carrier;
    return this;
  }
}
