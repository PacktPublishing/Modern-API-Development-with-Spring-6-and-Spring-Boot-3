package com.packt.modern.api.service;

import com.packt.modern.api.entity.AuthorizationEntity;
import com.packt.modern.api.model.PaymentReq;
import java.util.Optional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
public interface PaymentService {

  Optional<AuthorizationEntity> authorize(@Valid PaymentReq paymentReq);
  Optional<AuthorizationEntity> getOrdersPaymentAuthorization(@NotNull String orderId);
}
