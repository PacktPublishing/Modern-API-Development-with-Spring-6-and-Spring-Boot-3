package com.packt.modern.api.controllers;

import static org.springframework.http.ResponseEntity.ok;

import com.packt.modern.api.CartApi;
import com.packt.modern.api.model.Cart;
import com.packt.modern.api.model.Item;
import java.util.Collections;
import java.util.List;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter03 - Modern API Development with Spring and Spring Boot Ed 2
 * @created : 31/10/2022, Monday
 **/
@RestController
public class CartsController implements CartApi {

  private static final Logger log = LoggerFactory.getLogger(CartsController.class);

  @Override
  public ResponseEntity<List<Item>> addCartItemsByCustomerId(String customerId, @Valid Item item) {
    log.info("Request for customer ID: {}\nItem: {}", customerId, item);
    return ok(Collections.EMPTY_LIST);
  }

  @Override
  public ResponseEntity<List<Item>> addOrReplaceItemsByCustomerId(String customerId,
      @Valid Item item) {
    return null;
  }

  @Override
  public ResponseEntity<Void> deleteCart(String customerId) {
    return null;
  }

  @Override
  public ResponseEntity<Void> deleteItemFromCart(String customerId, String itemId) {
    return null;
  }

  @Override
  public ResponseEntity<List<Cart>> getCartByCustomerId(String customerId) {
    throw new RuntimeException("Manual Exception thrown");
  }

  @Override
  public ResponseEntity<List<Item>> getCartItemsByCustomerId(String customerId) {
    return null;
  }

  @Override
  public ResponseEntity<List<Item>> getCartItemsByItemId(String customerId, String itemId) {
    return null;
  }
}
