package com.packt.modern.api.entity;

import java.util.Objects;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter05 - Modern API Development with Spring and Spring Boot Ed 2
 **/

@Table("ecomm.order_item")
public class OrderItemEntity {

  @Id
  @Column("id")
  private UUID id;

  @Column("order_id")
  private UUID orderId;

  @Column("item_id")
  private UUID itemId;

  public UUID getId() {
    return id;
  }

  public OrderItemEntity setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getOrderId() {
    return orderId;
  }

  public OrderItemEntity setOrderId(UUID orderId) {
    this.orderId = orderId;
    return this;
  }

  public UUID getItemId() {
    return itemId;
  }

  public OrderItemEntity setItemId(UUID itemId) {
    this.itemId = itemId;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItemEntity that = (OrderItemEntity) o;
    return Objects.equals(id, that.id) && Objects.equals(orderId, that.orderId)
        && Objects.equals(itemId, that.itemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, orderId, itemId);
  }

  @Override
  public String toString() {
    return "OrderItemEntity{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", itemId=" + itemId +
        '}';
  }
}
