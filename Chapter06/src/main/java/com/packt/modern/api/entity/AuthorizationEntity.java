package com.packt.modern.api.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter06 - Modern API Development with Spring and Spring Boot Ed 2
 */
@Entity
@Table(name = "\"authorization\"")
public class AuthorizationEntity {

  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "AUTHORIZED")
  private boolean authorized;

  @Column(name = "TIME")
  private Timestamp time;

  @Column(name = "MESSAGE")
  private String message;

  @Column(name = "ERROR")
  private String error;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ORDER_ID", referencedColumnName = "id")
  private OrderEntity orderEntity;

  public UUID getId() {
    return id;
  }

  public AuthorizationEntity setId(UUID id) {
    this.id = id;
    return this;
  }

  public boolean isAuthorized() {
    return authorized;
  }

  public AuthorizationEntity setAuthorized(boolean authorized) {
    this.authorized = authorized;
    return this;
  }

  public Timestamp getTime() {
    return time;
  }

  public AuthorizationEntity setTime(Timestamp time) {
    this.time = time;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public AuthorizationEntity setMessage(String message) {
    this.message = message;
    return this;
  }

  public String getError() {
    return error;
  }

  public AuthorizationEntity setError(String error) {
    this.error = error;
    return this;
  }

  public OrderEntity getOrderEntity() {
    return orderEntity;
  }

  public AuthorizationEntity setOrderEntity(OrderEntity orderEntity) {
    this.orderEntity = orderEntity;
    return this;
  }
}
