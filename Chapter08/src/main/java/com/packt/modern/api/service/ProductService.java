package com.packt.modern.api.service;

import com.packt.modern.api.entity.ProductEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter06 - Modern API Development with Spring and Spring Boot Ed 2
 */
@Validated
public interface ProductService {
  @NotNull
  Iterable<ProductEntity> getAllProducts();

  Optional<ProductEntity> getProduct(@Min(value = 1L, message = "Invalid product ID.") String id);
}
